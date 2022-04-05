//소수1
// 0.579sec
#include <stdio.h>

int main(){
    int n, i;
    int prime; //0이면 소수가 아님, 1이면 소수임.

    for(n=2; n<1000; n++){
        prime = 1;
        for(i=2; i<n; i++){
            if (n%i == 0){
                prime = 0; //소수가 아니다.
                break;
            }  
        }

        if(prime == 1){
            printf("%d ", n);
        }

    }

    return 0;
}