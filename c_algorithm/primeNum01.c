//소수1
//1000: 78021, 10000: 5775223
//0.596 0.579
#include <stdio.h>
#include <time.h>

int main(){
    clock_t start, end;
    start = clock();

    int n, i;
    
    int isPrime; //0이면 소수가 아님, 1이면 소수
    unsigned long counter = 0; //실행 횟수

    for(n=2; n<=10000; n++){
        isPrime = 1;
        for(i=2; i<n; i++){
            counter++;
            if (n%i == 0){ //나누어 떨어짐.
                isPrime = 0; //소수가 아니다.
                break;
            }  
        }

        if(isPrime){ //소수이면
            printf("%d ", n);
        }

    }
    
    printf("\n실행횟수 : %lu\n", counter);

    end = clock();
    printf("ms : %lf\n", (double)(end-start));
    printf("s : %lf\n", (double)(end-start)/CLOCKS_PER_SEC);

    return 0;
}