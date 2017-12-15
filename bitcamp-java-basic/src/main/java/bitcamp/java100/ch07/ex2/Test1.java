// 상속(inheritance)
//
package bitcamp.java100.ch07.ex2;

public class Test1 {

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        calc.result = 10;
        calc.multiple(2);
        calc.multiple(3);
        calc.divide(10);
        
        System.out.println(calc.result);
        
    }

}
