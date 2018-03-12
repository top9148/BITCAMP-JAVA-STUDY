package step9;

public class MybatisUpdate {
    public static void main(String[] args) throws Exception {
        BoardDao boardDao = new BoardDao();
        boardDao.setSqlSessionFactory(SqlSessionFactoryBean.getObject());

        Board board = new Board();
        board.setNo(29);
        board.setTitle("제목 변경!");
        board.setContents("내용 변경!");
        
        int count = boardDao.update(board);
        
        System.out.printf("%d 개가 변경되었습니다.", count);
    }
}
