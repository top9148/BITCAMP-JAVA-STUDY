package java100.app;

public class Test {

    public static void main(String[] args) {
        String[] path = 
                "/score/add?name=aaa&kor=100&eng=100".split("\\?");
        
        String[] arr = path[1].split("&");
        for (String param : arr) {
            String[] kv = param.split("=");
            System.out.printf("%s : %s\n", kv[0], kv[1]);
        }

    }

}
