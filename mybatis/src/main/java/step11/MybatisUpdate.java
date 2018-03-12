package step11;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MybatisUpdate {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext iocContainer = 
                new ClassPathXmlApplicationContext(
                        "step11/application-context.xml");
        
        BoardDao boardDao = iocContainer.getBean(BoardDao.class);
        Board board = new Board();
        board.setNo(31);
        board.setTitle("제목 변경!");
        board.setContents("내용 변경!");
        
        int count = boardDao.update(board);
        
        System.out.printf("%d 개가 변경되었습니다.", count);
        
        iocContainer.close();
    }
}
