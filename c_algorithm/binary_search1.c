//이진 검색 알고리즘 - ppt 3장 29p

#include <stdio.h>

int bin_search(int arr[], int n, int key){
    int front = 0;
    int end = n-1;
    int center = end / 2;

    printf("%d  %d  %d", front, end, center);
}

int main(void){
    int num;
    int search;
    printf("이진 검색\n요소 개수 : ");
    scanf("%d", &num);
    printf("오름차순으로 입력하세요\n");

    int arr[num];

    for(int i=0; i<num; i++){
        printf("x[%d] : ", i);
        scanf("%d", &arr[i]);
    }

    printf("검색값 : ");
    scanf("%d", &search);

    bin_search(arr, num, search);

}