// 컬렉션(collection) - 배열 사용하기 II 
// => 다른 프로젝트에서도 사용할 수 있도록 별도의 클래스로 분류해보자!
package bitcamp.java100.ch09.ex1;

public class Test2 {

    public static void main(String[] args) {

        Array list = new Array();
        
        // 값을 저장한다.
        list.add(new String("홍길동"));
        list.add(new Integer(100));
        list.add(80); 
        list.add(70);
        list.add(250);
        list.add(250 / 3f);
        list.add("임꺽정");
        list.add(80);
        list.add(80); 
        list.add(80);
        list.add(240);
        list.add(240 / 3f);
        
        
        // 값을 출력한다.
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%d : %s\n", i, list.get(i));
        }
        System.out.println("-------------------------------");
        
        list.insert(6, "유관순");
        
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%d : %s\n", i, list.get(i));
        }
        System.out.println("-------------------------------");
        
        System.out.println(list.remove(11));
        System.out.println(list.remove(10));
        
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%d : %s\n", i, list.get(i));
        }
        System.out.println("-------------------------------");
        
        // 배열의 특징
        // => 크기를 조정할 수 없다.
        // => 만약 크기를 조정하려하면 새 배열을 만든 다음에 기존 배열의 값을 
        //    모조리 복사해야 한다.
        // => 일정 크기의 배열을 생성해 놓아야 하기 때문에 
        //    일정 크기만큼 메모리 낭비가 발생한다.
        // => 배열에 저장된 데이터가 증가할 수록 insert와 remove의 속도도 비례하여  
        //    떨어진다.
        // => 대신 값을 꺼낼 때 인덱스를 사용하여 꺼내기 때문에
        //    조회속도가 빠르다.
        // => 단 인덱스가 아닌 내용으로 값을 찾을 때는
        //    배열의 시작부터 끝까지 전체 내용을 뒤져야 한다.
        //    검색 속도는 배열의 크기에 비례한다.
    }

}






