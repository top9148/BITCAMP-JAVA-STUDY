package bitcamp.java100.ch21.ex5.proxy2.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import bitcamp.java100.ch21.ex5.proxy2.Calculator;

// 서버쪽에서 실제로 작업을 수행하는 객체를 대신하여 
// 클라이언트쪽 요청을 받는 객체를 "Stub"이라 한다.
// Stub 역할을 수행하는 객체는 서버의 작업 객체(CalculatorObject)인양 보이기 위하여
// 서버의 작업 객체와 동일 인터페이스(Calculator)를 구현한다.
//
public class CalculatorStub implements Calculator {

    @Override
    public int plus(int a, int b) {
        return request("plus", a, b);
    }

    @Override
    public int minus(int a, int b) {
        return request("minus", a, b);
    }
    
    private int request(String methodName, int a, int b) {
        try (Socket s = new Socket("localhost", 9999);
             DataInputStream in = new DataInputStream(s.getInputStream());
             DataOutputStream out = new DataOutputStream(s.getOutputStream());) {
            
            out.writeUTF(methodName);
            out.writeInt(a);
            out.writeInt(b);
            
            if (in.readInt() == 200) {
                return in.readInt();
            } else {
                throw new Exception(in.readUTF());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}










