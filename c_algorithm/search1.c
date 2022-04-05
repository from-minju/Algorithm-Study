//선형 검색 알고리즘 - 내가 한 거
 
#include <stdio.h>

int main(void) {
    int i, num, searchNum;

    printf("선형 검색\n요소 개수 : ");
    scanf("%d", &num);

    int x[num]; //요소를 저장할 배열

    for(i=0; i<num; i++){
        printf("x[%d] : ", i);
        scanf("%d", &x[i]);
    }

    printf("검색값 : ");
    scanf("%d", &searchNum);

    for(i=0; i<num; i++){
        if(x[i] == searchNum){
            printf("%d는 x[%d]에 있습니다.\n", searchNum, i);
            break;
        }
    }

    if(i == num){
        printf("검색에 실패했습니다.\n");
    }
    return 0;
}