// ## 연산자 - 연산자 우선순위
// - 연산자 우선 순위를 알아보자!
//

package bitcamp.java100.ch02;

public class Test15_6 {

    public static void main(String[] args) {
// 여러 개의 연산자가 한 식(express)에 있을 때는 연산자 우선 순위에 따라 계산을 수행한다.
// => *, / 가 +, - 보다 우선으로 실행한다.
        int r = 2 + 3 * 4;
        System.out.println(r);

        r = 2 + 3 * 4 - 6 / 3 + 7;
        //= 2 + 12 - 6 / 3 + 7
        //= 2 + 12 - 2 + 7
        //= 14 - 2 + 7
        //= 12 + 7
        //= 19
        System.out.println(r);

// 괄호()는 *, / 보다 우선한다.
        r = (2 + 3) * 4;
        System.out.println(r);
    }
}

// ### 연산자 우선 수위
// 괄호                         ()
// postfix	                expr++ expr--
// unary	                ++expr --expr +expr -expr ~ !
// multiplicative	        * / %
// additive	                + -
// shift	                << >> >>>
// relational	                < > <= >= instanceof
// equality	                == !=
// bitwise AND	                &
// bitwise exclusive OR	        ^
// bitwise inclusive OR	        |
// logical AND	                &&
// logical OR	                ||
// ternary	                ? :
// assignment	                = += -= *= /= %= &= ^= |= <<= >>= >>>=