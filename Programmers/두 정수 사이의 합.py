# 프로그래머스
# 두 정수 사이의 합
def solution(a, b):
    answer = 0
    if a > b:
        temp = a
        a = b
        b = temp

    for i in range(a, b + 1):
        answer += i

    return answer

#for문 쓸 필요없이 sum()사용하면 됨!

# 다른 사람의 풀이
def adder(a,b):
    if a > b: a, b = b, a
    return sum(range(a, b+1))

def adder(a, b):
    return (abs(a-b)+1)*(a+b)//2
#등차수열 공식 이용
#(항의 개수) * (a+b) / 2

def adder(a, b):
    return sum(range(min(a,b),max(a,b)+1))

def solution(a, b):
    return sum(range(a,b+1) if a <= b else range(b,a+1))