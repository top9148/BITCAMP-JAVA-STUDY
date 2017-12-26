// JDBC Driver 정보 조회
// 1) 접속하려는 DBMS의 JDBC Driver를 다운로드 받는다.
// 2) Eclipse의 자바프로젝트 속성에서 사용하려는 
//    JDBC Driver 파일(.jar)의 경로를 build path에 추가한다.
// 잠깐!
// => 자바 프로그램에서 다른 개발자가 만든 라이브러리를 사용하기 위해서는
//    이렇게 다운로드하고 프로젝트의 빌드 경로에 추가해야 한다
// => 이렇게 반복적이고 번거로운 빌드 작업을 단순화시키는 도구를 
//    "빌드 도구"라 부른다.
// => 대표적인 제품이 ant, maven, gradle 이다.
// => 빌드 도구를 사용하면 프로그램에서 사용하는 라이브러리(의존라이브러리)를 
//    자동으로 다운로드 받고 
//    이클립스 프로젝트의 빌드 경로에 자동으로 추가할 수 있다.
// => Gradle 빌드 도구 사용예)
//    - build.gradle 파일의 dependencies{} 블록에 의존 라이브러리 파일 정보를 
//      등록하라!
//    - 의존 라이브러리 정보는 mvnrepository.com 에서 검색해보라!
//    - 명령창에서 "gradle eclipse"를 실행하라!
// 
package bitcamp.java100.ch17.ex1;

public class Test1 {

    public static void main(String[] args) throws Exception {
        
        // JDBC Driver에 대한 정보는 
        // java.sql.Driver 인터페이스를 구현한 클래스를 통해 확인할 수 있다.
        
        // 그러면 MySQL JDBC Driver 파일(xxx.jar)에 들어있는 클래스 중에서
        // 어떤 클래스가 java.sql.Driver 구현체인가?
        // => 매뉴얼에 나와있다.
        
        java.sql.Driver driver = new com.mysql.jdbc.Driver();
        
        System.out.println(driver.getMajorVersion());
        System.out.println(driver.getMinorVersion());

    }

}









