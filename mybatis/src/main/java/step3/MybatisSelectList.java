package step3;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisSelectList {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = 
                Resources.getResourceAsStream("step3/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory =
          new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        
        // selectList(SQL문을 찾을 때 이름)
        // => SQL문을 찾을 때 이름 = 네임스페이스명.SQL아이디
        // => 네임스페이스명?
        //    <mapper namespace="네임스페이스명">
        // => SQL 아이디?
        //    <select id="SQL 아이디">
        List<Map<String,Object>> records = sqlSession.selectList("JdbcTestMapper.findAll");
        
        // List에 저장된 객체의 타입은?
        // => SQL Mapper에 설정된 resultType이다.
        for (Map<String,Object> record : records) {
            
            //Map 객체는 record 값을 갖고 있다.
            //Map 객체에서 한 개의 컬럼 값을 꺼내고 싶다면,
            //컬럼의 이름으로 꺼내라!
            System.out.printf("%d,%s,%s,%s\n", 
                    record.get("no"),
                    record.get("title"),
                    record.get("regdt"),
                    record.get("vwcnt"));
        }
        
        sqlSession.close();
    }
}
