# Programmers - 정수 내림차순으로 배치하기
def solution(n):
    answer = ''
    n = list(map(int, str(n)))  # 리스트로 만들어준다.
    n.sort(reverse=True)  # 리스트를 내림차순으로 정렬해준다.

    for i in n:  # 리스트를 문자열로 바꿔준다
        answer += str(i)

    answer = int(answer)  # 정수형으로 바꿔준다.

    return answer

# 다른 사람의 풀이
def solution(n):
    ls = list(str(n))
    ls.sort(reverse = True)
    return int("".join(ls))