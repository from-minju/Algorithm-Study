// 에라토스테네스의 체
// 실행횟수 : 36007
//0.363
#include <stdio.h>
#include <math.h>
#include <time.h>
 
#define MAX 10000
 
int main()
{
    clock_t start, end;
    start = clock();

	char isPrime[MAX+1]; //소수를 체크하기 위한 배열, 0번째 건너띄고 1번째 인덱스부터 사용
	isPrime[1] = 0; //1은 소수가 아니라고 가정
    unsigned long counter = 0; //실행 횟수

	//1외에는 모두 소수라고 가정
	for (int i = 2; i < MAX+1; i++)
	{
		isPrime[i] = 1;
	}
 
	//에라토스테네스의 체
	for (int n = 2; n <= floor(sqrt(MAX)); n++)
	{
		if (!isPrime[n]) //n이 소수가 아닌 경우
		{
			continue;
		}

		//소수인 n의 배수들 모두 제거
		for (int mult = 2; counter++, n * mult <= MAX; mult++) {
            counter++;
			isPrime[n*mult] = 0;
		}
	}
 
	//에라토스테네스의 체를 이용하여 남은 소수들 출력
	for (int i = 1; i < MAX+1; i++)
	{
		if (isPrime[i]) 
		{
			printf("%d ", i);
		}
	}
    printf("\n실행횟수 : %lu\n", counter);

    end = clock();
    printf("ms : %lf\n", (double)(end-start));
    printf("s : %lf\n", (double)(end-start)/CLOCKS_PER_SEC);
 
	return 0;
}