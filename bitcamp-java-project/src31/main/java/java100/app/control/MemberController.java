package java100.app.control;

import java.util.Iterator;

import java100.app.domain.Member;
import java100.app.util.Prompts;

public class MemberController extends GenericController<Member> {
    
    // 실제 이 클래스가 오버라이딩 하는 메서드는 
    // GenericController가 따른다고 한 Controller 인터페이스의 
    // 추상 메서드이다.
    @Override    
    public void execute() {
        loop:
        while (true) {
            System.out.print("회원관리> ");
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
        System.out.println("[회원 목록]");
        
        Iterator<Member> iterator = list.iterator();
        while (iterator.hasNext()) {
            Member member = iterator.next();
            System.out.printf("%-4s, %s\n",  
                    member.getName(), 
                    member.getEmail());
        }
    }
    
    private void doAdd() {
        System.out.println("[회원 등록]");
        
        Member member = new Member();
        member.setEmail(Prompts.inputString("이메일? "));
        
        if (findByEmail(member.getEmail()) != null) {
            System.out.println("이미 등록된 이메일입니다.");
            return;
        }
        
        member.setName(Prompts.inputString("이름? "));
        member.setPassword(Prompts.inputString("암호? "));
        
        list.add(member);
    } 
    
    private void doView() {
        System.out.println("[회원 상세 정보]");
        String email = Prompts.inputString("이메일? ");
        
        Member member = findByEmail(email);
        
        if (member == null) {
            System.out.printf("'%s'의 회원 정보가 없습니다.\n", email);
            return;
        }
        
        System.out.printf("이름: %s\n", member.getName());
        System.out.printf("이메일: %s\n", member.getEmail());
        System.out.printf("암호: %s\n", member.getPassword());
    } 
    
    private void doUpdate() {
        System.out.println("[회원 변경]");
        String email = Prompts.inputString("이메일? ");
        
        Member member = findByEmail(email);
        
        if (member == null) {
            System.out.printf("'%s'의 회원 정보가 없습니다.\n", email);
            return;
        }
        
        String name = Prompts.inputString("이름?(%s) ", member.getName());
        if (name.isEmpty()) {
            name = member.getName();
        }
        
        String password = Prompts.inputString("암호? ");
        if (password.isEmpty()) {
            password = member.getPassword();
        }
        
        if (Prompts.confirm2("변경하시겠습니까?(y/N) ")) {
            member.setName(name);
            member.setPassword(password);
            System.out.println("변경하였습니다.");
            
        } else {
            System.out.println("변경을 취소하였습니다.");
        }
    }
    
    private void doDelete() {
        System.out.println("[회원 삭제]");
        String email = Prompts.inputString("이메일? ");
        
        Member member = findByEmail(email);
        
        if (member == null) {
            System.out.printf("'%s'의 회원 정보가 없습니다.\n", email);
            return;
        }
        
        if (Prompts.confirm2("정말 삭제하시겠습니까?(y/N) ")) {
            list.remove(member);
            System.out.println("삭제하였습니다.");
        } else {
            System.out.println("삭제를 취소하였습니다.");
        }
    }
    
    private Member findByEmail(String email) {
        Iterator<Member> iterator = list.iterator();
        while (iterator.hasNext()) {
            Member member = iterator.next();
            if (member.getEmail().equals(email)) {
                return member;
            }
        }
        return null;
    }
}










