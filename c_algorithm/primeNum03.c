//소수 - 홀수만 대상으로
//실행횟수 : 766633
//메모리 측면에서 비효율적이다.
//0.355
#include <stdio.h>
#include <time.h>

int main(void){
    clock_t start, end;
    start = clock();
    
    int i, n;
    int prime[5000]; //소수를 저장하는 배열
    int ptr = 0; //이미 얻은 소수의 개수
    unsigned long counter = 0; //나눗셈 횟수

    prime[ptr++] = 2; //2는 소수
    for (n = 3; n <= 10000; n += 2){ //홀수만을 대상으로 한다.
        for(i = 1; i < ptr; i++) { 
            counter ++;
            if(n % prime[i] == 0) //이미 얻은 소수로 나눈다.
                break;
        }

        if(ptr == i) //마지막까지 나누어떨어지지 않았다면
            prime[ptr++] = n; // 소수를 배열에 저장한다.
    }

    for (i = 0; i < ptr; i++)
        printf("%d ", prime[i]);
    
    printf("\n실행횟수 : %lu\n", counter);

    end = clock();
    printf("ms : %lf\n", (double)(end-start));
    printf("s : %lf\n", (double)(end-start)/CLOCKS_PER_SEC);

    return 0;
}