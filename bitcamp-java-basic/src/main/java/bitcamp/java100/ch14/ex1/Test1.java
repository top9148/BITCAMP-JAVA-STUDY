// File System 다루기 : File 클래스
// => OS의 File System이 관리하는 파일 정보를 다룰 때 사용하는 클래스이다.
// => 디렉토리 정보도 이 클래스로 다룬다.
package bitcamp.java100.ch14.ex1;

import java.io.File;
import java.sql.Date;

public class Test1 {

    public static void main(String[] args) throws Exception {
        // 1) 프로그램을 실행하는 현재 폴더에 대한 정보를 가져온다.
        // => Eclipse에서 실행한다면, 현재 폴더는 프로젝트 폴더가 된다.
        //File file = new File(".");
        //File file = new File("../..");
        File file = new File("../bitcamp-java-project/build.gradle");
        
        // File 객체를 생성할 때 넘겨준 경로 중에서 
        // 마지막 파일명(디렉토리라면 마지막 디렉토리명)
        System.out.printf("파일명=%s\n", file.getName());
        
        // File 객체를 생성할 때 넘겨준 경로 모두
        System.out.printf("파일객체를 생성할 때 넘겨준 경로=%s\n", file.getPath());

        System.out.printf("절대경로=%s\n", file.getAbsolutePath());
        
        // . 또는 ..을 계산하여 최종 경로를 리턴한다.
        // 계산하다가 실제 그런 경로를 찾지 못했을 때는 예외를 던진다.
        System.out.printf("계산된경로=%s\n", file.getCanonicalPath());
        

        // File 객체를 생성할 때 생성자에 넘겨준 기준 디렉토리 정보
        // => 기준 디렉토리를 넘겨주지 않았으면 null
        System.out.printf("기준디렉토리=%s\n", file.getParent());
        
        // 파일 경로가 존재하지 않을 경우 용량을 계산할 수 없어 0을 리턴한다.
        System.out.printf("전체용량=%s\n", file.getTotalSpace());
        System.out.printf("남은용량=%s\n", file.getFreeSpace());
        System.out.printf("사용가능한용량=%s\n", file.getUsableSpace());
        
        System.out.printf("존재여부=%s\n", file.exists());
        System.out.printf("파일여부=%s\n", file.isFile());
        System.out.printf("디렉토리여부=%s\n", file.isDirectory());
        
        System.out.printf("파일이나 디렉토리 크기=%s\n", file.length());
        
        System.out.printf("읽기=%s\n", file.canRead());
        System.out.printf("쓰기=%s\n", file.canWrite());
        System.out.printf("실행=%s\n", file.canExecute());
        
        System.out.printf("마지막 변경일=%s\n", file.lastModified());
        System.out.printf("마지막 변경일=%s\n", 
                new Date(file.lastModified()).toString());
        System.out.printf("마지막 변경일2=%s\n", 
                new Date(file.lastModified()).toLocaleString());
        
    }

}









