// 성적 관리 시스템을 사용하는 클라이언트 프로그램
package java100.app;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

// 서버의 요청 처리 정책이 Stateful에서 Stateless로 변경되었다.
// 따라서 클라이언트도 요청할 때마다 서버에 연결하는 방식으로 변경해야 한다.
public class Client {
    public static void main(String[] args) throws Exception {

        Scanner keyboard = new Scanner(System.in);

        System.out.print("서버주소?");
        String serverAddr = keyboard.nextLine();

        while (true) {
            //=> 사용자로부터 명령어를 한 줄 입력 받는다.
            System.out.print("명령>");
            String command = keyboard.nextLine();
            
            //=> quit 명령어를 입력 받았으면 프로그램을 종료한다.
            if (command.equals("quit")) {
                break;
            }
            
            try (
                Socket socket = new Socket(serverAddr, 9999);
                PrintStream out = new PrintStream(
                        new BufferedOutputStream(socket.getOutputStream()));
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                ) {

                //=> 서버에 입력한 명령을 보낸다.
                out.println(command);
                out.flush();

                //=> 서버에서 받은 문자열을 출력한다.
                while (true) {
                    String line = in.readLine();

                    //=> 만약 서버에서 빈 줄을 보내면 출력의 끝으로 판단하고,
                    //   읽기를 멈춘다.
                    if (line.isEmpty())
                        break;

                    //=> 일반적인 내용은 그대로 화면에 출력한다.
                    System.out.println(line);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        keyboard.close();
    }
}
