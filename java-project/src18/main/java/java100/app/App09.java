//: ## ver 18
//: - 기능 추가: 변경, 삭제 기능을 추가하라!
//: - 요구사항
//:   - App.java 클래스의 주석을 확인하라!
//: 
//: 
/*

성적관리> add
이름? 홍길동
국어? 100
영어? 100
수학? 100
계속 입력하시겠습니까?(Y/n) <== 'Y' 또는 'y', 그냥 엔터치기 
이름? 임꺽정
국어? 90
영어? 90
수학? 90
계속 입력하시겠습니까?(Y/n) n

성적관리> list
홍길동, 300, 100.0
임꺽정, 270, 90.0

성적관리> view
이름? 홍길동
홍길동, 100, 100, 100, 300, 100.0

성적관리> view
이름? 우헤헤
'우헤헤'의 성적 정보가 없습니다.
성적관리> delete
이름? 홍길동
정말 삭제하시겠습니까?(y/N) y <== 'Y', 'y'를 입력해야 삭제된다.
삭제하였습니다.

성적관리> delete
이름? 임꺽정
정말 삭제하시겠습니까?(y/N) n
삭제취소하였습니다.

성적관리> delete
이름? 우헤헤
'우헤헤'의 성적 정보가 없습니다.

성적관리> update
이름? 홍길동
국어?(100) 80    <== 엔터를 치면 원래 점수 유지
영어?(100) 
수학?(100) 90
변경하시겠습니까?(y/N) y<== 'Y', 'y'를 입력해야 변경된다.
변경하였습니다.

성적관리> update
이름? 홍길동
국어?(100) 80    <== 엔터를 치면 원래 점수 유지
영어?(100) 
수학?(100) 90
변경하시겠습니까?(y/N) n<== 'Y', 'y'를 입력해야 변경된다.
변경취소하였습니다.

성적관리> update
이름? 우헤헤
'우헤헤'의 성적 정보가 없습니다.

성적관리> remove
수행할 수 없는 명령입니다.

성적관리> quit
프로그램을 종료합니다.

 */
package java100.app;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
 
// 9단계:
// => 성적 변경 기능 중에서 사용자가 점수를 입력할 때
//    엔터를 입력하거나 숫자가 아닌 값을 입력할 경우 
//    예외 처리한다.
//    Score 클래스의 update()
public class App09 {
    
    static Scanner keyScan = new Scanner(System.in);
    
    static String prompt(String message) {
        System.out.print(message);
        return keyScan.nextLine();
    }
    
    static boolean confirm(String message) {
        System.out.print(message);
        String response = keyScan.nextLine().toLowerCase();
        
        if (response.equals("y") || 
                response.equals("yes") || 
                response.equals("")) {
            return true;
        }
        return false;
    }
    
    static boolean confirm2(String message) {
        System.out.print(message);
        String response = keyScan.nextLine().toLowerCase();
        
        if (response.equals("n") || 
                response.equals("no") || 
                response.equals("")) {
            return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        ArrayList<Score> list = new ArrayList<>();
        Iterator<Score> iterator;
        
        loop:
        while (true) {
            System.out.print("성적관리> ");
            String input = keyScan.nextLine();
            
            String name = null;
            Score score = null;
            
            switch (input) {
            case "add":
                System.out.println("[학생 등록]");
                
                while (true) {
                    score = new Score(); // 성적 데이터를 저장할 빈 객체를 준비한다.
                    score.input(); // 사용자로부터 입력받은 데이터를 빈 객체에 저장한다.
                    
                    list.add(score);
                    
                    if (!confirm("계속하시겠습니까?(Y/n) "))
                        break;
                }
                
                break;
            case "list":
                System.out.println("[학생 목록]");
                
                iterator = list.iterator();
                while (iterator.hasNext()) {
                    iterator.next().print();
                }
                
                break;
            case "view":
                System.out.println("[학생 정보]");
                name = prompt("이름? ");
                
                iterator = list.iterator();
                while (iterator.hasNext()) {
                    Score temp = iterator.next();
                    if (temp.name.equals(name)) {
                        score = temp;
                        break;
                    }
                }
                
                if (score == null) {
                    System.out.printf("'%s'의 성적 정보가 없습니다.\n", name);
                } else {
                    score.printDetail();
                }
                break;
            case "update":
                System.out.println("[학생 정보 변경]");
                name = prompt("이름? ");
                
                iterator = list.iterator();
                while (iterator.hasNext()) {
                    Score temp = iterator.next();
                    if (temp.name.equals(name)) {
                        score = temp;
                        break;
                    }
                }
                
                if (score == null) {
                    System.out.printf("'%s'의 성적 정보가 없습니다.\n", name);
                } else {
                    score.update();
                }
                
                break;
            case "delete":
                System.out.println("[학생 삭제]");
                name = prompt("이름? ");
                
                iterator = list.iterator();
                while (iterator.hasNext()) {
                    Score temp = iterator.next();
                    if (temp.name.equals(name)) {
                        score = temp;
                        break;
                    }
                }
                
                if (score == null) {
                    System.out.printf("'%s'의 성적 정보가 없습니다.\n", name);
                } else {
                    if (confirm2("정말 삭제하시겠습니까?(y/N) ")) {
                        list.remove(score);
                        System.out.println("삭제하였습니다.");
                    } else {
                        System.out.println("삭제를 취소하였습니다.");
                    }
                }
                break;
            case "quit":
                System.out.println("프로그램을 종료합니다.");
                break loop;
            default:
                System.out.println("실행할 수 없는 명령입니다.");
            }
            
            System.out.println();
        }
        
    }
}




