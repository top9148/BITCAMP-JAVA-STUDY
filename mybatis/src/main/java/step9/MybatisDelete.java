package step9;

public class MybatisDelete {
    public static void main(String[] args) throws Exception {
        BoardDao boardDao = new BoardDao();
        boardDao.setSqlSessionFactory(SqlSessionFactoryBean.getObject());

        int count = boardDao.delete(29);
        
        System.out.printf("%d 개가 삭제되었습니다.", count);
    }
}
