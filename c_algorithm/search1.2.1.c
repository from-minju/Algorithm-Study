//선형 검색 알고리즘 - ppt 3장 13p 
//while문보다 짧고 간결한 for문

#include <stdio.h>
#include <stdlib.h>

int search(const int a[], int n, int key)
{
    int i;
    for(i=0; i<n; i++)
        if(a[i] == key) //검색 성공
            return i;
    return -1; //검색 실패
}

int main(void)
{
    int i, nx, ky, idx;
    int *x;

    puts("선형 검색");
    printf("요소 개수 : ");
    scanf("%d", &nx);
    x = calloc(nx, sizeof(int));
    for(i=0; i<nx; i++)
    {
        printf("x[%d] : ", i);
        scanf("%d", &x[i]);
    }
    printf("검색값 : ");
    scanf("%d", &ky);
    idx = search(x, nx, ky); //배열x의 값이 ky인 요소를 선형 검색
    if(idx == -1) //검색에 실패한 경우
        puts("검색에 실패하였습니다.");
    else //검색에 성공한 경우
        printf("%d는 x[%d]에 있습니다.", ky, idx);
    free(x); // 배열 해제

    return 0;
}