// ## 연산자 - 비트 연산자 (&, |, ~, ^) 응용
// - 비트 연산자의 활용 예
//

package bitcamp.java100.ch02;
 
public class Test15_11_3 {

    public static void main(String[] args) {
// 임무: 파일의 정보를 저장하라!
// - 디렉토리여부, 소유주/그룹/기타 사용자의 읽기, 쓰기, 실행 권한 정보
//
// 방법3: int 메모리와 비트 연산자를 이용하여 처리        
        
        // => 사용자 권한 정보를 담을 int 메모리를 한 개 만든다.
        int p1 = 0;
        
        // => 비트에 사용자 권한을 저장한다.
        p1 = 0b0_111_101_101;
        
        // => 권한 검사에 사용할 필터를 준비한다.
        final int DIRECTORY     = 0x0200; //0b0010_0000_0000;
        final int OWNER_READ    = 0x0100; //0b0001_0000_0000;
        final int OWNER_WRITE   = 0x0080; //0b0000_1000_0000;
        final int OWNER_EXE     = 0x0040; //0b0000_0100_0000;
        final int GROUP_READ    = 0x0020; //0b0000_0010_0000;
        final int GROUP_WRITE   = 0x0010; //0b0000_0001_0000;
        final int GROUP_EXE     = 0x0008; //0b0000_0000_1000;
        final int OTHER_READ    = 0x0004; //0b0000_0000_0100;
        final int OTHER_WRITE   = 0x0002; //0b0000_0000_0010;
        final int OTHER_EXE     = 0x0001; //0b0000_0000_0001;
        
        
        // => 사용 권한 검사
        System.out.print((p1 & DIRECTORY) == DIRECTORY ? "d" : "-");
        System.out.print((p1 & OWNER_READ) == OWNER_READ ? "r" : "-");
        System.out.print((p1 & OWNER_WRITE) == OWNER_WRITE ? "w" : "-");
        System.out.print((p1 & OWNER_EXE) == OWNER_EXE ? "x" : "-");
        System.out.print((p1 & GROUP_READ) == GROUP_READ ? "r" : "-");
        System.out.print((p1 & GROUP_WRITE) == GROUP_WRITE ? "w" : "-");
        System.out.print((p1 & GROUP_EXE) == GROUP_EXE ? "x" : "-");
        System.out.print((p1 & OTHER_READ) == OTHER_READ ? "r" : "-");
        System.out.print((p1 & OTHER_WRITE) == OTHER_WRITE ? "w" : "-");
        System.out.print((p1 & OTHER_EXE) == OTHER_EXE ? "x" : "-");
        System.out.println();
        
    }
}




















