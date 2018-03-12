package step11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MybatisSelectList {
    public static void main(String[] args) throws Exception {
        
        ClassPathXmlApplicationContext iocContainer = 
                new ClassPathXmlApplicationContext(
                        "step11/application-context.xml");
        
        BoardDao boardDao = iocContainer.getBean(BoardDao.class);
        
        // 정렬 정보를 맵 객체에 담아 selectList()에 넘긴다.
        Map<String,Object> data = new HashMap<>();
        
        // order by를 위한 값
        data.put("orderColumn", "regdt");
        data.put("align", "desc");
        
        // where 절을 위한 값
        List<String> words = new ArrayList<>();
        words.add("aa");
        words.add("1");
        words.add("5");
        
        //data.put("words", words);
        
        List<Board> records = boardDao.findAll(data);
        
        for (Board board : records) {
            System.out.printf("%d,%s,%s,%s\n", 
                    board.getNo(),
                    board.getTitle(),
                    board.getCreatedDate(),
                    board.getViewCount());
        }
        
        iocContainer.close();
    }
}
