#include <stdio.h>

int pos[8]; //각 열에서의 퀸의 위치

void print(void)
{
    int i;
    for(i = 0; i< 8; i++)
        printf("%2d", pos[i]);
    putchar('\n');
}

/*--- i열에 퀸을 배치 ---*/
void set(int i) // branching(가지 뻗기)
{
	// i : 열, j : 행
	int j;
	for (j = 0; j < 8; j++) { // 8행 까지
		pos[i] = j; // 퀸 i열 j행에 배치
		if (i == 7)// 모든 열에 배치를 마침
			print();
		else
			set(i + 1); // 다음 열
	}
}
int main(void)
{
	set(0); // 0열부터 배치 

	return 0;
}