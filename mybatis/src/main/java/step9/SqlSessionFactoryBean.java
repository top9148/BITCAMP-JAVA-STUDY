package step9;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

// 역할?
// => SqlSessionFactory 객체를 만들어주는 공장 역할을 한다.
public class SqlSessionFactoryBean {
    
    public static SqlSessionFactory getObject() throws Exception {
        InputStream inputStream = 
                Resources.getResourceAsStream("step9/mybatis-config.xml");
        return new SqlSessionFactoryBuilder().build(inputStream);
    }
}








