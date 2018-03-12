package step9;

public class MybatisSelectOne {
    public static void main(String[] args) throws Exception {
        BoardDao boardDao = new BoardDao();
        boardDao.setSqlSessionFactory(SqlSessionFactoryBean.getObject());
        
        Board board = boardDao.findByNo(27);
        
        System.out.printf("번호: %d\n", board.getNo());
        System.out.printf("제목: %s\n", board.getTitle());
        System.out.printf("내용: %s\n", board.getContents());
        System.out.printf("날짜: %s\n", board.getCreatedDate());
        System.out.printf("조회수: %d\n", board.getViewCount());
    }
}
