package step11;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MybatisInsert {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext iocContainer = 
                new ClassPathXmlApplicationContext(
                        "step11/application-context.xml");
        
        BoardDao boardDao = iocContainer.getBean(BoardDao.class);

        // insert를 실행할 때 Board 객체를 넘겨줄 것이다.
        Board board = new Board();
        board.setTitle("오호라~ 제목이래요2!");
        board.setContents("내용이더래요~~~2");
        
        int count = boardDao.insert(board);
        System.out.printf("%d 개가 입력되었습니다.", count);
        iocContainer.close();
    }
}
