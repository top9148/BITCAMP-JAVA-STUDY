package java100.app.beans;

import java.io.File;
import java.io.FileFilter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import java100.app.annotation.Component;

public class ApplicationContext {
    
    // 클래스를 찾아야 할 기준 디렉토리 
    String baseDir;
    int startIndexOfPackageName;
    
    // 객체를 보관할 컬렉션
    HashMap<String,Object> pool = new HashMap<>();
    
    // 프로퍼티 파일을 로딩하지 않을 경우를 대비하여 기본 생성자를 만든다.
    public ApplicationContext() {} 
    
    public static void main(String[] args) {
        new ApplicationContext("./bin");
    }
    
    public ApplicationContext(String classpath) {
        
        File dir = new File(classpath);
        if (!dir.isDirectory())
            return;
        
        try {
            // 1) classpath에 있는 모든 .class 파일의 이름을 알아낸다.
            ArrayList<String> classnames = new ArrayList<>();
            this.baseDir = dir.getCanonicalPath();
            this.startIndexOfPackageName = baseDir.length() + 1;
            this.findClassFile(classnames, dir);
            
            for (String classname : classnames) {
                // 2) 그 이름으로 클래스를 로딩한다.
                Class<?> clazz = Class.forName(classname);
                
                // 3) @Component 애노테이션이 붙었는지 검사한다.
                Component compAnno = clazz.getAnnotation(Component.class);
                if (compAnno == null) continue;
                
                // 4) @Component 애노테이션이 붙은 클래스라면,
                //    인스턴스를 생성한다.
                Object obj = clazz.newInstance();
                
                // 5) 객체를 저장할 때 사용할 이름을 꺼낸다.
                if (compAnno.value().length() == 0) {
                    // 이름을 설정되지 않았다면 클래스 이름으로 저장한다.
                    pool.put(clazz.getName(), obj);
                } else {
                    // 이름이 있으면 그 이름을 사용하여 저장한다.
                    pool.put(compAnno.value(), obj);
                }
            }
            
            // 6) 인스턴스를 다 만들었으면 의존 객체를 주입한다.
            injectDependency();
            
        } catch (Exception e) {
            throw new BeansException("프로퍼티 파일 로딩 중 오류 발생!", e);
        }
        
    }
    
    private void findClassFile(List<String> classnames, File dir) 
            throws Exception {
        
        File[] files = dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if (pathname.isFile() && !pathname.getName().endsWith(".class"))
                    return false;
                return true ;
            }
        });
        
        for (File f : files) {
            if (f.isDirectory()) {
                findClassFile(classnames, f);
            } else {
                classnames.add(f.getCanonicalPath()
                         .substring(this.startIndexOfPackageName)
                         .replaceAll("/", ".")
                         .replaceAll("\\\\", ".")
                         .replaceAll(".class", ""));
            }
        }
    }
    
    public Object getBean(String name) {
        Object bean = pool.get(name);
        if (bean == null)
            throw new BeansException("빈을 찾을 수 없습니다.");
        return bean;
    }
    
    public void addBean(String name, Object bean) {
        pool.put(name, bean);
    }
    
    public String[] getBeanDefinitionNames() {
        // pool에서 객체를 저장할 때 사용한 이름 목록을 가져온다.
        Set<String> keySet = pool.keySet();
        
        // 이름을 저장할 배열을 만든다.
        String[] names = new String[keySet.size()];
        
        // 이름이 저장된 Set 객체에 배열을 주면서 이름을 담아 달라고 한다.
        keySet.toArray(names);

        // 이름이 저장된 배열을 리턴한다.
        return names;
    }
    
    // pool에 저장된 각각의 객체에 대해 의존 객체를 찾아 주입한다.
    private void injectDependency() {
        Collection<Object> objs = pool.values();
        for (Object obj : objs) {
            invokeSetter(obj);
        }
    }
    
    // 한 객체의 셋터를 찾아 호출한다.
    private void invokeSetter(Object obj) {
        
        // 해당 객체에 선언된 모든 메서드 목록을 꺼낸다.
        Method[] methods = obj.getClass().getDeclaredMethods();
        
        // 목록에서 셋터를 찾아 호출한다.
        for (Method m : methods) {
            //System.out.println("=>" + m.getName());
            
            if (!m.getName().startsWith("set")) continue;
            
            // 셋터가 원하는 타입의 객체가 pool에 들어 있는지 찾아 본다.
            Object dependency = findObject(getFirstParameterType(m));
            
            if (dependency == null) continue;
                
            // 셋터가 원하는 타입의 객체를 찾았으면,
            // 셋터를 호출하여 그 객체를 주입한다.
            try {
                m.invoke(obj, dependency);
                //System.out.printf("%s.%s() 호출됨!\n",
                //        obj.getClass().getName(),
                //        m.getName());
                
            } catch (Exception e) {
                throw new BeansException(
                        obj.getClass().getName() + 
                        " 클래스의 " + m.getName() +
                        " 메서드 호출 오류!");
            }
        }
    }
    
    private Class<?> getFirstParameterType(Method m) {
        return m.getParameterTypes()[0];
    }
    
    // 주어진 타입의 객체가 있는지 pool을 뒤져서 찾는다. 
    private Object findObject(Class<?> type) {
        
        // pool 저장된 객체 목록을 꺼낸다.
        Collection<Object> objs = pool.values();
        
        // 목록에서 주어진 타입의 객체가 있는지 검사한다.
        for (Object obj : objs) {
            if (type.isInstance(obj)) 
                return obj;
        }
        
        // 못 찾았으면 null을 리턴한다.
        return null;
    }
    
    // 빈 컨테이너에 객체가 추가되거나 제거되었을 때 
    // 의존 객체 주입을 다시해야 한다.
    public void refreshBeanFactory() {
        injectDependency();
    }
}


















