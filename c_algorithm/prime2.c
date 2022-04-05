//소수2 : 교재 버전1
// 0.384sec
#include <stdio.h>
int main(void){
    int i, n;
    unsigned long counter = 0;

    for (n=2; n<=1000; n++){
        for(i=2; i<n; i++){
            counter++;
            if(n % i == 0)
                break;
        }

        if (n==i){ // 두번째 for문이 중간에 break되지 않고 끝까지 간 경우 ->소수인 경우
            printf("%d ", n);
        }
    }

    return 0;

}

