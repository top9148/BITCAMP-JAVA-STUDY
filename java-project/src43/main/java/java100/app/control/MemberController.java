package java100.app.control;

import java.io.PrintWriter;
import java.util.List;

import java100.app.dao.MemberDao;
import java100.app.domain.Member;

public class MemberController implements Controller {
    
    // MemberDao를 이 클래스에서 준비하지 않고 외부에서 주입받을 것이다.
    MemberDao memberDao;
    
    public void setMemberDao(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    @Override
    public void destroy() {}
    
    @Override
    public void init() {}
    
    @Override    
    public void execute(Request request, Response response) {
        switch (request.getMenuPath()) {
        case "/member/list": this.doList(request, response); break;
        case "/member/add": this.doAdd(request, response); break;
        case "/member/view": this.doView(request, response); break;
        case "/member/update": this.doUpdate(request, response); break;
        case "/member/delete": this.doDelete(request, response); break;
        default: 
            response.getWriter().println("해당 명령이 없습니다.");
        }
    }
    
    private void doList(Request request, Response response) {

        PrintWriter out = response.getWriter();
        out.println("[회원 목록]");
        
        try {
            
            List<Member> list = memberDao.selectList();
            
            for (Member member : list) {
                out.printf("%d, %s, %s, %s\n",
                        member.getNo(),
                        member.getName(), 
                        member.getEmail(),
                        member.getCreatedDate());
            }
            
        } catch (Exception e) {
            e.printStackTrace(); // for developer
            out.println(e.getMessage()); // for user
        }
    }
    
    private void doAdd(Request request, Response response) {

        PrintWriter out = response.getWriter();
        out.println("[회원 등록]");
        
        try {
            
            Member member = new Member();
            member.setName(request.getParameter("name"));
            member.setEmail(request.getParameter("email"));
            member.setPassword(request.getParameter("password"));
            
            memberDao.insert(member);
            
            out.println("저장하였습니다.");
            
        } catch (Exception e) {
            e.printStackTrace(); // for developer
            out.println(e.getMessage()); // for user
        }
    } 
    
    private void doView(Request request, Response response) {

        PrintWriter out = response.getWriter();
        out.println("[회원 상세 정보]");
        
        try {
            
            int no = Integer.parseInt(request.getParameter("no"));
            Member member = memberDao.selectOne(no);
            
            if (member != null) {
                out.printf("번호: %d\n", member.getNo());
                out.printf("이름: %s\n", member.getName());
                out.printf("이메일: %s\n", member.getEmail());
                out.printf("등록일: %s\n", member.getCreatedDate());
            } else {
                out.printf("'%d'번의 회원 정보가 없습니다.\n", no); 
            }
            
        } catch (Exception e) {
            e.printStackTrace(); // for developer
            out.println(e.getMessage()); // for user
        }
    } 
    
    private void doUpdate(Request request, Response response) {

        PrintWriter out = response.getWriter();
        out.println("[회원 변경]");
        
        try {
            Member member = new Member();
            member.setNo(Integer.parseInt(request.getParameter("no")));
            member.setName(request.getParameter("name"));
            member.setEmail(request.getParameter("email"));
            member.setPassword(request.getParameter("password"));
            
            if (memberDao.update(member) > 0) {
                out.println("변경하였습니다.");
            } else {
                out.printf("'%d'번 회원의 정보가 없습니다.\n", member.getNo()); 
            }
            
        } catch (Exception e) {
            e.printStackTrace(); // for developer
            out.println(e.getMessage()); // for user
        }
    }
    
    private void doDelete(Request request, Response response) {

        PrintWriter out = response.getWriter();
        out.println("[회원 삭제]");
        
        try {
            
            int no = Integer.parseInt(request.getParameter("no"));
            
            if (memberDao.delete(no) > 0) {
                out.println("삭제했습니다.");
            } else {
                out.printf("'%d'번의 회원 정보가 없습니다.\n", no); 
            }
            
        } catch (Exception e) {
            e.printStackTrace(); // for developer
            out.println(e.getMessage()); // for user
        }
    }
}










