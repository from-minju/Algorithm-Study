//소수3 : 교재 버전2
//0.517(0.31)
#include <stdio.h>

int main(void){
    int i, n;
    int prime[500]; //소수를 저장하는 배열
    int ptr = 0; //이미 얻은 소수의 개수
    unsigned long counter = 0; //나눗셈 횟수

    prime[ptr++] = 2; //2는 소수
    for (n = 3; n <= 1000; n += 2){ //홀수만을 대상으로 한다.
        for(i = 1; i < ptr; i++) { //이미 얻은 소수로 나눈다.
            counter ++;
            if(n % prime[i] == 0)
                break;
        }

        if(ptr == i) //마지막까지 나누어떨어지지 않았다면
            prime[ptr++] = n; // 소수를 배열에 저장한다.
    }

    for (i = 0; i < ptr; i++)
        printf("%d ", prime[i]);
    
    printf("나눗셈을 실행한 횟수 : %lu\n", counter);

    return 0;
}