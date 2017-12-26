package java100.app.control;

import java.util.HashMap;

public class Request {
    // 명령어 경로
    private String menuPath;
    
    // 명령어 뒤에 붙어 온 데이터가 있다면 Map 객체에 보관한다.
    private HashMap<String,String> params = new HashMap<>();
    
    public Request(String command) {
        String[] path = command.split("\\?");
        
        this.menuPath = path[0];
        
        if (path.length > 1) { // ? 다음에 문자열이 있다면 
            String[] arr = path[1].split("&");
            for (String param : arr) {
                String[] kv = param.split("=");
                this.params.put(kv[0], kv[1]);
            }
        }
    }
    
    public String getMenuPath() {
        return this.menuPath;
    }
    
    public String getParameter(String name) {
        return this.params.get(name);
    }
    
}










