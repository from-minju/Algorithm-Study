//메모리 할당 기간과 동적 객체 생성

#include <stdio.h>
#include <stdlib.h>

int main(void) {
    int * x;
    //calloc(개수, 자료형 크기)
    x = calloc(1, sizeof(int)); //int형 포인터에 메모리 할당
    
    if(x == NULL){
        puts("메모리 할당에 실패했습니다.");
    }
    else {
        *x = 57;
        printf("*x = %d\n", *x);

        free(x);
    }

    return 0;
}