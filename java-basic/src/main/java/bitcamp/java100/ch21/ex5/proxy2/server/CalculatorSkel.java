package bitcamp.java100.ch21.ex5.proxy2.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class CalculatorSkel {
    public static void main(String[] args) throws Exception {
        CalculatorObject remoteObj = new CalculatorObject();
        
        ServerSocket ss = new ServerSocket(9999);
        System.out.println("서버 시작됨...");
        
        while (true) {
            Socket s = ss.accept();
            DataInputStream in = new DataInputStream(s.getInputStream());
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            
            String methodName = in.readUTF();
            int a = in.readInt();
            int b = in.readInt();
            
            switch (methodName) {
            case "plus":
                out.writeInt(200);
                out.writeInt(remoteObj.plus(a, b));
                break;
            case "minus":
                out.writeInt(200);
                out.writeInt(remoteObj.minus(a, b));
                break;
            default:
                out.writeInt(400);
                out.writeUTF("해당 메서드가 없습니다.");
            }
            in.close();
            out.close();
            s.close();
        }
    }
}











