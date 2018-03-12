package step12;

import java.util.List;
import java.util.Map;

// mybatis의 MapperScannerConfigurer 객체가 
// BoardDao 구현체를 자동으로 생성할 것이다.
// 단 인터페이스의 메서드를 정의할 때 규칙이 있다.
// => 메서드명과 그 메서드가 사용할 SQL문의 아이디가 일치해야 한다.
// => 파라미터의 타입과 리턴 타입이 SQL 맵퍼에 정의된 것과 일치해야 한다.
//
public interface BoardDao {
    
    List<Board> findAll(Map<String,Object> data);
    Board findByNo(int no);
    int insert(Board board);
    int update(Board board);
    int delete(int no);
}








