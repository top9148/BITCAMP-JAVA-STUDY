package java100.app.web.json;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import java100.app.domain.Member;
import java100.app.domain.Score;
import java100.app.service.ScoreService;

@RestController
@RequestMapping("/score")
@SessionAttributes("loginUser")
public class ScoreController {
    
    @Autowired ScoreService scoreService;
    
    @RequestMapping("list")
    public Object list(
            @RequestParam(value="pn", defaultValue="1") int pageNo,
            @RequestParam(value="ps", defaultValue="5") int pageSize,
            @RequestParam(value="words", required=false) String[] words,
            @RequestParam(value="oc", required=false) String orderColumn,
            @RequestParam(value="al", required=false) String align) throws Exception {

        if (pageNo < 1) {
            pageNo = 1;
        }
        
        if (pageSize < 5 || pageSize > 15) {
            pageSize = 5;
        }
        
        HashMap<String,Object> options = new HashMap<>();
        
        if (words != null && words[0].length() > 0) {
            options.put("words", words);
        }
        options.put("orderColumn", orderColumn);
        options.put("align", align);
        
        int totalCount = scoreService.getTotalCount();
        int lastPageNo = totalCount / pageSize;
        if ((totalCount % pageSize) > 0) {
            lastPageNo++;
        }
        
        // Client에게 보낼 데이터를 담을 Map 객체를 준비한다.
        HashMap<String,Object> result = new HashMap<>();
        
        result.put("pageNo", pageNo);
        result.put("lastPageNo", lastPageNo);
        result.put("list", scoreService.list(pageNo, pageSize, options));
        
        return result;
    }
    
    @RequestMapping("{no}")
    public Object view(@PathVariable int no) throws Exception {
        
        HashMap<String, Object> result = new HashMap<>();
        result.put("data", scoreService.get(no));
        
        return result;        
    }

    @RequestMapping("add")
    public Object add(Score score) throws Exception {
        
        scoreService.add(score);
        
        HashMap<String,Object> result = new HashMap<>();
        result.put("status", "success");
        
        return result;
    }
    
    @RequestMapping("update")
    public Object update(Score score) throws Exception {
        
        scoreService.update(score);
        
        HashMap<String,Object> result = new HashMap<>();
        result.put("status", "success");
        
        return result;
    }

    @RequestMapping("delete")
    public Object delete(int no) throws Exception {
        
        scoreService.delete(no);
        
        HashMap<String,Object> result = new HashMap<>();
        result.put("status", "success");
        
        return result;
    }
    
    @ModelAttribute("loginUser")
    public Member loginUser() {
        return new Member();
    }
    
    @RequestMapping("test1")
    public Object test(@ModelAttribute(value="loginUser") Member loginUser) throws Exception {
        // @ModelAttribute("loginUser") 객체 찾기
        // 1) 세션에서 찾는다. 있으면 파라미터에 넣어준다.
        // 2) 현재 클래스에서 @ModelAttribute("loginUser")에서 찾는다. 
        
        HashMap<String,Object> result = new HashMap<>();
        result.put("status", "success");
        result.put("loginUser", loginUser);
        return result;
    }
    
}








