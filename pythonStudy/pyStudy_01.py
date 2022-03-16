#리스트 컴프리헨션 1
#0부터 19까지의 수 중에서 홀수만 포함하는 리스트
array = []
for i in range(20):
    if i%2 == 1:
        array.append(i)
print(array)

#리스트 컴프리헨션 1-1 (위와 동일한 코드임)
array = [i for i in range(20) if i%2==1]
print(array)

#리스트 컴프리헨션 2
#1부터 9까지의 수의 제곱 값을 포함하는 리스트
array = [i*i for i in range(1, 10)]
print(array)

#리스트 컴프리헨션 3
#N x M 크기의 2차원 리스트 초기화
n = 3
m = 4
array = [ [0] * m for _ in range(n) ]
print(array)



