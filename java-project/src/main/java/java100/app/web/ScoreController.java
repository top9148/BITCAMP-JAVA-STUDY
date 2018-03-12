package java100.app.web;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java100.app.domain.Score;
import java100.app.service.ScoreService;

@Controller
@RequestMapping("/score")
public class ScoreController {
    
    @Autowired ScoreService scoreService;
    
    @RequestMapping("list")
    public String list(
            @RequestParam(value="pn", defaultValue="1") int pageNo,
            @RequestParam(value="ps", defaultValue="5") int pageSize,
            @RequestParam(value="words", required=false) String[] words,
            @RequestParam(value="oc", required=false) String orderColumn,
            @RequestParam(value="al", required=false) String align,
            Model model) throws Exception {

        // UI 제어와 관련된 코드는 이렇게 페이지 컨트롤러에 두어야 한다.
        //
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
        
        // view 컴포넌트가 사용할 값을 Model에 담는다.
        model.addAttribute("pageNo", pageNo);
        model.addAttribute("lastPageNo", lastPageNo);
        model.addAttribute("list", scoreService.list(pageNo, pageSize, options));
        
        return "score/list";
    }
    
    @RequestMapping("{no}")
    public String view(@PathVariable int no, Model model) throws Exception {
        
        model.addAttribute("score", scoreService.get(no));
        return "score/view";        
    }

    @RequestMapping("form")
    public String form() throws Exception {
        return "score/form";
    }

    @RequestMapping("add")
    public String add(Score score, BindingResult bindingResult) throws Exception {
        
        // 파라미터 값을 모델 객체의 프로퍼티 값으로 변환하는 중에  
        // 오류가 발생했을 때, 
        // 그 오류 내용을 받고 싶다면, 
        // 요청 핸들러가 정상적으로 호출되게 하고 싶다면,
        // 파라미터 값을 받는 모델 객체의 선언 다음에 BindingResult 변수를 선언하라!
        // 그리고 다음 코드와 같이 오류 여부를 검사하라!
        if (bindingResult.hasErrors()) {
            // 파라미터 값을 변수의 타입으로 변환하는데 오류가 있을 때,
            // 여기에 작업 코드를 작성하라!
            System.out.println("파라미터 값을 변환하는 중에 오류 발생!");
        }
        
        scoreService.add(score);
        return "redirect:list";
    }
    
    @RequestMapping("update")
    public String update(Score score) throws Exception {
        
        scoreService.update(score);
        return "redirect:list";
    }

    @RequestMapping("delete")
    public String delete(int no) throws Exception {
        
        scoreService.delete(no);
        return "redirect:list";
    }
}








