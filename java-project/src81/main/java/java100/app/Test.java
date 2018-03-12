package java100.app;

import java.util.HashMap;

import org.springframework.web.client.RestTemplate;


public class Test {

    public static void main(String[] args) {
        HashMap<String,String> parameters = new HashMap<>();
        parameters.put("name", "홍길동");
        parameters.put("age", "20");
        
        RestTemplate template = new RestTemplate();
        String result = template.getForObject("https://www.eomcs.com/", String.class, parameters);
        System.out.println("---------------------------------");
        System.out.println(result);
    }

}






