public class SelectStudent {
    static String[] names = {
        "김석희", "황지은", "정소현", "오세현", "강성현", "김이든",
        "김다솔", "이보미", "이철희", "김미애", "송우정", "윤효진",
        "김정훈", "심현석", "윤재훈", "이승서", "이해성", "장나성", 
        "김준엽", "박정남", "김지성", "황원철", "장욱진", "민혜린",
        "최명송", "조인성", "서정혁"};

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 27; i++) {
            int no = (int)(Math.random() * 27);
            System.out.println(names[no]);
            Thread.sleep(500);
        }
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            System.out.print(".");
        }
        System.out.println();
        System.out.println("당첨: " + names[(int)(Math.random() * 27)]);
    }
}