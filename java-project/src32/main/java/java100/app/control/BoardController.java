package java100.app.control;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.util.Iterator;
import java.util.Scanner;

import java100.app.domain.Board;
import java100.app.util.Prompts;

public class BoardController extends GenericController<Board> {
    
    private String dataFilePath;
    
    public BoardController(String dataFilePath) {
        this.dataFilePath = dataFilePath;
        this.init();
    }
    
    @Override
    public void destroy() {
        
        try (FileWriter out = new FileWriter(this.dataFilePath);) {
            for (Board board : this.list) {
                out.write(board.toCSVString() + "\n");
            }
            
        } catch (IOException e) {
            e.printStackTrace();
            
        }
    }
    
    @Override
    public void init() {
        
        try (
                FileReader in = new FileReader(this.dataFilePath);
                Scanner lineScan = new Scanner(in);) {
            
            String csv = null;
            while (lineScan.hasNextLine()) {
                csv = lineScan.nextLine();
                try {
                    list.add(new Board(csv));
                } catch (CSVFormatException e) {
                    System.err.println("CSV 데이터 형식 오류!");
                    e.printStackTrace();
                }
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // 실제 이 클래스가 오버라이딩 하는 메서드는 
    // GenericController가 따른다고 한 Controller 인터페이스의 
    // 추상 메서드이다.
    @Override
    public void execute() {
        loop:
        while (true) {
            System.out.print("게시판> ");
            String input = keyScan.nextLine();
            
            // 명령어를 처리하는 각 코드를 별도의 메서드로 추출한다.
            switch (input) {
            case "list": this.doList(); break;
            case "add": this.doAdd(); break;
            case "view": this.doView(); break;
            case "update": this.doUpdate(); break;
            case "delete": this.doDelete(); break;
            case "main": break loop;
            default: 
                System.out.println("해당 명령이 없습니다.");
            }
        }
    }
    
    private void doList() {
        System.out.println("[게시물 목록]");
        
        Iterator<Board> iterator = list.iterator();
        while (iterator.hasNext()) {
            Board board = iterator.next();
            System.out.printf("%d, %s, %s, %d\n",  
                    board.getNo(), 
                    board.getTitle(),
                    board.getRegDate().toString(),
                    board.getViewCount());
        }
    }

    private void doAdd() {
        System.out.println("[게시물 등록]");
        
        Board board = new Board(); 
        board.setNo(Prompts.inputInt("번호? "));

        if (findByNo(board.getNo()) != null) {
            System.out.println("이미 등록된 번호입니다.");
            return;
        } 
            
        board.setTitle(Prompts.inputString("제목? "));
        board.setContent(Prompts.inputString("내용? "));
        board.setRegDate(new Date(System.currentTimeMillis()));
        
        list.add(board);
    } 
    
    private void doView() {
        System.out.println("[게시물 상세 정보]");
        int no = Prompts.inputInt("번호? ");
        
        Board board = findByNo(no);
        
        if (board == null) {
            System.out.printf("%d번 게시물이 없습니다.\n", no);
            return;
        }
        
        System.out.printf("제목: %s\n", board.getTitle());
        System.out.printf("내용: %s\n", board.getContent());
        System.out.printf("등록일: %s\n", board.getRegDate().toString());
        board.setViewCount(board.getViewCount() + 1);
        System.out.printf("조회수: %d\n", board.getViewCount());
    } 
    
    private void doUpdate() {
        System.out.println("[게시물 변경]");
        int no = Prompts.inputInt("번호? ");
        
        Board board = findByNo(no);
        
        if (board == null) {
            System.out.printf("%d번 게시물이 없습니다.\n", no);
            return;
        } 
        
        String title = Prompts.inputString("제목?(%s) ", board.getTitle());
        if (title.isEmpty()) {
            title = board.getTitle();
        }
        
        String content = Prompts.inputString("내용? ");
        
        if (Prompts.confirm2("변경하시겠습니까?(y/N) ")) {
            board.setTitle(title);
            board.setContent(content);
            board.setRegDate(new Date(System.currentTimeMillis()));
            System.out.println("변경하였습니다.");
            
        } else {
            System.out.println("변경을 취소하였습니다.");
        }
    }
    
    private void doDelete() {
        System.out.println("[게시물 삭제]");
        int no = Prompts.inputInt("번호? ");
        
        Board board = findByNo(no);
        
        if (board == null) {
            System.out.printf("%d번 게시물이 없습니다.\n", no);
            return;
        } 

        if (Prompts.confirm2("정말 삭제하시겠습니까?(y/N) ")) {
            list.remove(board);
            System.out.println("삭제하였습니다.");
        } else {
            System.out.println("삭제를 취소하였습니다.");
        }
    }
    
    private Board findByNo(int no) {
        Iterator<Board> iterator = list.iterator();
        while (iterator.hasNext()) {
            Board board = iterator.next();
            if (board.getNo() == no) {
                return board;
            }
        }
        return null;
    }
}








