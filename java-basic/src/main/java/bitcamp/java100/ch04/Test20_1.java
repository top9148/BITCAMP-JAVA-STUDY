// ## 래퍼(wrapper) 클래스 사용법 - 래퍼 클래스의 소개
// - 래퍼 클래스가 무엇인지, 어떤 경우에 사용하는지 알아보자!
//

package bitcamp.java100.ch04;

public class Test20_1 {
    public static void main(String[] args) {
        // primitive type 변수
        int i = 10;
        
        // int 래퍼 클래스 사용
        Integer i2 = new Integer(10);
        
        // 래퍼(wrapper) 클래스?
        // - primitive 값을 객체로 다루기 위해 제공되는 클래스이다.
        // - 각각의 primitive 타입에 대한 클래스가 있다.
        //   byte       => java.lang.Byte
        //   short      => java.lang.Short
        //   int        => java.lang.Integer
        //   long       => java.lang.Long
        //   float      => java.lang.Float
        //   double     => java.lang.Double
        //   boolean    => java.lang.Boolean
        //   char       => java.lang.Character
        //
        // primitive 값을 객체로 다루는 이유?
        // - 클래스에서 제공하는 다양한 메서드를 이용할 수 있다.
        //   좀 더 정교하게 값을 다룰 수 있다.
        // - 값이나 객체의 주소를 구분하지 않고 주고 받고 싶을 때 사용한다. 
        
        // intValue()
        // > 객체에 저장된 int 값을 뽑아서 리턴해준다.
        int i3 = i2.intValue();
        
        // floatValue()
        // > 객체에 저장된 int 값을 float으로 만들어 리턴한다.
        float f1 = i2.floatValue();
        
        // Integer 클래스에는 int로 저장할 수 있는 최소/최대 값을 알려주는 변수가 있다.
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
        
        // Integer 클래스에는 문자열을 해석하여 int로 변환해주는 메서드도 있다.
        int value = Integer.parseInt("2345");
        System.out.println(value + 100);
        
        // 또한 int 값을 2진수, 8진수, 16진수로 표현된 문자열로 바꾸는 메서드도 있다.
        System.out.println(Integer.toBinaryString(44032));
        System.out.println(Integer.toOctalString(44032));
        System.out.println(Integer.toHexString(44032));
        
        
    }
}











