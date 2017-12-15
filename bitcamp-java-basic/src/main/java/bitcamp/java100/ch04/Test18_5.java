// ## String 클래스 사용법 - 기타 메서드들 
// - String 인스턴스에 대해 사용할 수 있는 기타 인스턴스 메서드의 사용법을 알아보자!
//

package bitcamp.java100.ch04;

public class Test18_5 {

    public static void main(String[] args) throws Exception {
        String s1 = "ABC가각간";
        
        // replace()
        // > 기존 문자열에서 특정 문자열을 다른 문자열로 교체한 새 String 인스턴스 생성.
        String s2 = s1.replace("BC", "하하하");
        
        System.out.println(s1);
        System.out.println(s2);
        // String 인스턴스의 값은 한 번 정해지면 변경할 수 없다.
        // 이런 인스턴스를 "immutable object" 라고 부른다.
        // String 클래스의 모든 메서드들은 기존의 값을 변경하지 못하기 때문에
        // 늘 새로운 String 인스턴스를 만들어 리턴한다.
        
        // charAt(위치번호)
        // > 문자열에서 특정 위치의 문자를 찾아 리턴한다.
        // > 위치번호(index)는 0부터 시작한다.
        System.out.println(s1.charAt(4));
        
        s1 = "ABBCDEBBFGH";

        // indexOf(찾을 문자열)
        // > 앞에서 부터 문자열을 찾는다. 찾은 위치(인덱스)를 리턴한다.
        System.out.println(s1.indexOf("BB"));
        
        // lastIndexOf(찾을 문자열)
        // > 뒤에서부터 찾는다. 
        System.out.println(s1.lastIndexOf("BB"));
        
        // substring(추출할 문자열의 시작 인덱스)
        // > 지정된 인덱스의 문자부터 끝까지 문자열을 추출한다.
        System.out.println(s1.substring(3));
        
        // substring(추출할 문자열의 시작 인덱스, 끝 인덱스)
        // > 시작 인덱스의 문자부터 끝 인덱스 바로 직전까지의 문자까지 추출한다.
        // > 끝 인덱스의 문자는 포함하지 않는다.
        System.out.println(s1.substring(3, 6));
        
        s1 = "홍길동";
        
        // startsWith(시작문자열)
        // > 해당 문자열이 주어진 문자열로 시작하는 지 검사한다. 리턴 값은 true 또는 false. 
        System.out.println(s1.startsWith("홍길"));
        System.out.println(s1.startsWith("길"));
        
        // endsWith(끝문자열)
        // > 해당 문자열이 주어진 문자열로 끝나는 지 검사한다. true 또는 false.
        System.out.println(s1.endsWith("동"));
        System.out.println(s1.endsWith("원"));
        
        s1 = "홍길동,유관순,임꺽정,안중근,윤봉길,이육사,윤동주";
        
        // contains(포함문자열)
        // > 해당 문자열에 주어진 문자열이 있는지 검사한다.
        System.out.println(s1.contains("꺽정"));
        System.out.println(s1.contains("김꺽정"));
        
        String s3 = "ABC";
        String s4 = "가각간";
        
        // concat(추가할 문자열)
        // > 해당 문자열에 주어진 문자열을 추가하여 새 String 인스턴스를 만든다.
        System.out.println(s3.concat(s4));
        
        // 주의! 절대로 기존 String 인스턴스의 값은 바뀌지 않는다.
        System.out.println(s3);
        System.out.println(s4);
        
        s3 = new String("탕수육");
        s4 = new String("탕수육2");
        String s5 = new String("탈수육");
        String s6 = new String("탕수육");
        
        // 문자열1.compareTo(문자열2)
        // > 두 문자열을 비교하여 같으면 0을 리턴한다.
        // > 알파벳/가나다 순서에서 문자열1이 문자열2 보다 앞서면 음수를 리턴한다.
        // > 알파벳/가나다 순서에서 문자열1이 문자열2 보다 뒤면 양수를 리턴한다.
        System.out.println(s3.compareTo(s6));
        System.out.println(s3.compareTo(s4));
        System.out.println(s3.compareTo(s5));
        
        s1 = "홍길동";
        s2 = ""; // 빈문자열
        s3 = null; // 인스턴스 없음
        
        // isEmpty()
        // > String 인스턴스에 저장된 문자열이 비어 있는지 검사한다.
        System.out.println(s1.isEmpty());
        System.out.println(s2.isEmpty());
        
        //System.out.println(s3.isEmpty()); // 실행 오류!
        // 빈문자열과 String 인스턴스 없음은 다르다!
        // 빈문자열도 String 인스턴스이다. 
        
        // length()
        // > String 인스턴스에 저장된 문자의 개수를 리턴한다.
        System.out.println(s1.length());
        System.out.println(s2.length());
        
        //System.out.println(s3.length()); // 인스턴스가 없으면 실행오류!
        // 인스턴스 메서드를 호출할 때는 항상 유효한 인스턴스 주소로 호출해야 한다.
        
        s1 = "홍길동,유관순,,임꺽정,안중근,윤봉길,이육사,윤동주";
        
        // split(구분자)
        // > 해당 문자열을 구분자로 분리하여 String[] 배열로 만들어 리턴한다.
        String[] arr = s1.split(",");
        for (String s : arr) {
            System.out.print(s);
            System.out.print("-");
        }
        System.out.println();
        
        // > 해당 문자열에 구분자가 없다면 그 문자열을 그대로 배열에 담아 리턴한다.
        arr = s1.split(" ");
        System.out.println(arr.length);
        System.out.println(arr[0]);
        
        // > 빈문자열도 문자열이기 때문에 배열로 리턴된다.
        s1 = "";
        arr = s1.split(",");
        System.out.println(arr.length);
        System.out.println(arr[0]);
        
        s1 = "Hong Gil Dong";
        
        // toLowerCase()
        // > 해당 문자열을 모두 소문자로 바꾼 새 String (객체)을 만든 후 그 객체(의 주소)를 리턴. 
        System.out.println(s1.toLowerCase());
        
        // toUpperCase()
        // > 해당 문자열을 모두 대문자로 바꾼 새 String (객체)을 만든 후 그 객체(의 주소)를 리턴.
        System.out.println(s1.toUpperCase());
        
        s1 = "  \t홍\t길 동 \n입니다. \n\n\n\t\n";
        
        // trim()
        // > 해당 문자열의 양쪽에 존재하는 공백(white space)을 제거한다.
        System.out.print(">");
        System.out.print(s1.trim());
        System.out.println("<");
        
        // 공백(white space)?
        // - 스페이스(스페이스 바를 눌러 추가한 빈 칸 한 개), 탭, 줄바꿈 모두 공백으로 취급한다.
        
        s1 = "ABC\n가각간\n똘똠똥";
        
        // getBytes()
        // > 해당 문자열을 바이트 배열로 만들어 리턴한다.
        //   바이트 배열에 저장되는 값은 JVM에 설정된 문자집합의 코드 값이다.
        //   JVM에 설정된 문자 집합이 없으면, OS의 기본 문자 집합을 사용한다.
        // 
        byte[] bytes = s1.getBytes();
        for (byte b : bytes) {
            System.out.print(Integer.toHexString(b & 0x00ff));
            System.out.print(" ");
        }
        System.out.println();
        
        // getBytes(문자집합)
        // > 가능한 문자 집합을 명시하여 바이트 배열을 만들라!
        // > OS에 상관없이 동일한 결과를 얻을 수 있다.
        bytes = s1.getBytes("UTF-8");
        for (byte b : bytes) {
            System.out.print(Integer.toHexString(b & 0x00ff));
            System.out.print(" ");
        }
        System.out.println();
        
        // String의 클래스 메서드 
        // valueOf(값)
        // > 주어진 값을 가지고 String 인스턴스를 생성하는 메서드이다.
        s1 = String.valueOf(true);
        s2 = String.valueOf(3.14);
        s3 = String.valueOf(100);
        
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        
        // 문자열을 다루는 특별한 연산자 '+'
        // > 두 문자열을 연결하여 새 String 인스턴스를 만든다.
        s1 = "ABC";
        s2 = "가각간";
        s3 = s1 + s2;
        // s1 + s2는 주소를 더하는 것이 아니라,
        // 두 인스턴스의 값을 연결하여 새 String 객체를 만든다.
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        
        
    }
    
}











