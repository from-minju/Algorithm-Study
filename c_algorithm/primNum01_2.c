//소수1
//10000: 5775223
#include <stdio.h>

int main(void){
    int i, n;
    unsigned long counter = 0;

    for(n=2; n<=10000; n++){
        for(i=2; i<n; i++){
            counter++;
            if(n%i ==0)
                break;
        }

        if(n==i)
            printf("%d ", n);
    }

    printf("\n실행횟수 : %lu\n", counter);

    return 0;

}