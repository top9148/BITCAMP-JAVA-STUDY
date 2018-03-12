import java.util.ArrayList;

public class SelectStudent {
    static String[] names = {"오세현", "김이든", "윤효진"};
    /*
    static String[] names = {
        "김석희", "황지은", "정소현", "오세현", "강성현", "김이든",
        "김다솔", "이보미", "이철희", "김미애", "송우정", "윤효진",
        "김정훈", "심현석", "윤재훈", "이승서", "이해성", "장나성", 
        "김준엽", "박정남", "김지성", "황원철", "장욱진", "민혜린",
        "최명송", "조인성", "서정혁"};
    */
    /*
    static String[] names = {
            "박정남", "김지성", "김석희", "윤재훈", "장욱진", "오세현"};
    */
    /*
    static String[] names = {
            "황지은", "강성현", "김이든",
            "김다솔", "이보미", "김미애", "송우정", "윤효진",
            "김정훈", "심현석", "이승서", "이해성",  
            "민혜린",
            "조인성", "서정혁"};
    */
    
    //static String[] names = {"김다솔", "강성현", "송우정"};
    
    public static void main(String[] args) throws Exception {
        ArrayList<String> list = new ArrayList<>();
        for (String name : names) {
            list.add(name);
        }
        
        ArrayList<Integer> teamNoList = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            teamNoList.add(i);
        }
        
        
        //while (list.size() > 0) {
            
            for (int i = 0; i < 10; i++) {
                Thread.sleep(1000);
                System.out.print(".");
            }
            
            int no = (int)(Math.random() * list.size());
            System.out.print(list.remove(no));
            
            /*
            for (int i = 0; i < 10; i++) {
                Thread.sleep(1000);
                System.out.print("=");
            }
            System.out.print(">");
            
            no = (int)(Math.random() * teamNoList.size());
            System.out.print(teamNoList.remove(no));
            System.out.println();
            */
        //}
    }
}