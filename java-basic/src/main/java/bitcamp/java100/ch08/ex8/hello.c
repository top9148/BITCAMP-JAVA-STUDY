#include <stdio.h>

int plus(int a, int b) {
    return a + b;
}

int divide(int a, int b) {
    return a / b;
}

/* C언어는 타입이 다르더라도 같은 이름을 가진 메서드를 여러 개 만들 수 없다.*/
/* 
float divide(float a, float b) {
    return a / b;
}
*/

/* 해결 책! =>
비록 같은 기능을 수행하더라도 같은 이름의 함수를 만들 수 없기 때문에 
함수 이름을 바꿔야 한다. */
float dividef(float a, float b) {
    return a / b;
}

/* 그리고, C는 패키지라는 개념이 없다.
그래서 함수 이름에 접두어나 접미사를 붙여 
다른 사람이 만든 함수와 구별한다. */
int eom_plus(int a, int b) {
    return a + b;
}


int main() {
    printf("Hello, %s!\n", "홍길동");
    printf("10 + 20 = %d\n", plus(10, 20));
    printf("7 / 2 = %d\n", divide(7, 2));
    printf("7 / 2 = %f\n", dividef(7, 2));
    printf("7 + 2 = %d\n", eom_plus(7, 2));
    return 0;
}








