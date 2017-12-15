// ## 연산자 - 비트 연산자 (&, |, ~, ^) 응용
// - 비트 연산자의 활용 예
//

package bitcamp.java100.ch02;

public class Test15_11_1 {

    public static void main(String[] args) {
// 임무: 파일의 정보를 저장하라!
// - 디렉토리여부, 소유주/그룹/기타 사용자의 읽기, 쓰기, 실행 권한 정보
//
// 방법1: 클래스를 이용하여 처리        
        // => 메모리 설계
        class Privilege {
            boolean isDirectory;
            boolean ownerRead;
            boolean ownerWrite;
            boolean ownerExe;
            boolean groupRead;
            boolean groupWrite;
            boolean groupExe;
            boolean otherRead;
            boolean otherWrite;
            boolean otherExe;
        }
        
        // => Privilege 설계도에 따라 메모리를 준비하고 그 메모리의 주소를 저장한다.
        Privilege p1 = new Privilege();
        
        // => 메모리 주소(레퍼런스)를 가지고 해당 메모리의 각 항목에 값을 넣는다.
        p1.isDirectory = false;
        p1.ownerRead = true;
        p1.ownerWrite = true;
        p1.ownerExe = true;
        p1.groupRead = true;
        p1.groupWrite = false;
        p1.groupExe = true;
        p1.otherRead = true;
        p1.otherWrite = false;
        p1.otherExe = true;
        
        // => 사용 권한 검사
        System.out.print(p1.isDirectory ? "d" : "-");
        System.out.print(p1.ownerRead ? "r" : "-");
        System.out.print(p1.ownerWrite ? "w" : "-");
        System.out.print(p1.ownerExe ? "x" : "-");
        System.out.print(p1.groupRead ? "r" : "-");
        System.out.print(p1.groupWrite ? "w" : "-");
        System.out.print(p1.groupExe ? "x" : "-");
        System.out.print(p1.otherRead ? "r" : "-");
        System.out.print(p1.otherWrite ? "w" : "-");
        System.out.print(p1.otherExe ? "x" : "-");
        System.out.println();
        
    }
}




















