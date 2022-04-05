//구조체 배열에서 검색하기 - ppt 3장 47p
//전제조건 : 이름이 알파벳순으로 sorting되어 있어야 한다.
//동명이인이 있을 경우엔 결과가 어떻게? -> 어떤 경우는 첫번째사람이 나왔다 두번째 사람 나왔다가...? - 문제있음

#include <stdio.h>
#include <stdlib.h> //bsearch()
#include <string.h> //strcmp함수가 선언된 헤더파일

typedef struct {
    char name[10];
    int height;
    int weight;
} Person;

// Person형의 비교 함수(오름차순으로 이름 정렬
int npcmp(const Person *x, const Person *y)
{
    return strcmp(x->name, y->name); //두 문자열이 같은지 
}

int main(void)
{
    Person x[] = {
        {"강민주", 154, 40},
        {"강영현", 180, 68},
        {"김원필", 176, 60},
        {"박성진", 178, 70}
    };

    int nx = sizeof(x) / sizeof(x[0]);
    int retry;
    puts("이름으로 검색합니다.");
    do{
        Person temp, *p;
        printf("이름 : ");
        scanf("%s", temp.name);
        p = bsearch(&temp, x, nx, sizeof(Person),
        (int(*)(const void *, const void *)) npcmp);
        if(p==NULL)
            puts("검색에 실패했습니다.");
        else {
            puts("검색 성공!! 아래 요소를 찾았습니다.");
            printf("x[%d] : %s %dcm %dkg\n",
                (int)(p-x), p->name, p->height, p->weight);
        }
        printf("다시 검색할까요? (1)예 /(0) 아니오 : ");
        scanf("%d", &retry);
    } while(retry == 1);

    return 0;
}

/*
bsearch()
    &temp : 찾으려는 자료의 포인터 주소
    x : 찾는 대상이 되는 테이블 포인터 주소
    nx : 테이블의 요소 개수
    sizeof(Person) : 한 개 요소의 크기
    int(*)(const void *, const void *)) npcmp : 두 요소를 비교하기 위한 함수 포인터
*/