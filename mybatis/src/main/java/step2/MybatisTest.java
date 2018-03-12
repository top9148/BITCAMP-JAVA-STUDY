// Mybatis 사용을 준비하기
// 0) Mybatis 라이브러리를 가져온다.
//    - mvnrepository.com에서 mybatis를 검색하여 build.gradle 파일에 추가한다.
//    - "gradle eclipse"를 실행하여 이클립스 설정 파일을 갱신한다.
//    - 이클립스 프로젝트를 "refresh" 한다.
// 1) Mybatis 설정 파일을 준비한다.
//    - mybatis-config.xml 파일 생성
//    - mybatis 매뉴얼에서 해당 코드 가져온다.
// 2) SQL문이 들어있는 XML 파일을 준비한다.
//    - JdbcTestMapper.xml 파일 생성
//    - mybatis 매뉴얼에서 해당 코드를 가져온다.
// 3) SqlSessionFactory 객체를 준비한다.
//    - SqlSessionFactory의 역할은 SQL문을 실행할 SqlSession을 만들어주는 일을 한다.
//    - 그래서 SqlSessionFactory 객체를 준비한 다음에 SqlSession을 얻어서 
//      SQL문을 실행시키면 된다.
//    - mybatis 매뉴얼에서 해당 코드를 가져온다.
//
package step2;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisTest {

    public static void main(String[] args) throws Exception {
        
        // Resources 역할
        // => 파라미터로 주어진 파일을 자바 클래스 경로에서 찾는다.
        // => 그리고 그 파일을 읽을 도구를 리턴한다.
        InputStream inputStream = 
                Resources.getResourceAsStream("step2/mybatis-config.xml");
        
        // SqlSessionFactoryBuilder 역할
        // => 설계도에 맞춰 SqlSessionFactory 객체를 만들어준다.
        // 
        SqlSessionFactory sqlSessionFactory =
          new SqlSessionFactoryBuilder().build(inputStream);
        
        // SqlSessionFactory 역할
        // => SQL문을 실행할 때 사용할 SqlSession 객체를 만들어준다.
        SqlSession sqlSession = sqlSessionFactory.openSession();
        
        // SqlSession 역할
        // => SQL Mapper 파일을 뒤져 SQL을 꺼낸다. 그리고 실행한다.
        
        // SQL을 실행하는 코드를 이 자리에 두면 된다.
        
        // SqlSession을 사용한 후에는 항상 닫아라!
        sqlSession.close();
        
        System.out.println("종료!");
    }

}







