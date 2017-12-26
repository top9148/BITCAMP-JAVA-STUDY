package java100.app.beans;

import java.util.HashMap;

// 이 클래스는 인스턴스를 보관하는 역할을 수행한다.
public class ApplicationContext {
    static HashMap<String,Object> beanContainer = 
            new HashMap<>();

    public static Object getBean(String name) {
        Object bean = beanContainer.get(name);
        if (bean == null)
            throw new BeansException("빈을 찾을 수 없습니다.");
        return bean;
    }
    
    public static void addBean(String name, Object bean) {
        beanContainer.put(name, bean);
    }
}






