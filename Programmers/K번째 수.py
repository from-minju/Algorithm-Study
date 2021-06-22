# 프로그래머스
# K번째 수
def solution(array, commands):
    answer = []

    for element in commands:
        a = element[0] - 1
        b = element[1]
        li = array[a:b]
        li.sort
        answer.append(li[element[2] - 1])

    return answer

#다른 사람의 풀이
def solution(array, commands):
    return list(map(lambda x:sorted(array[x[0]-1:x[1]])[x[2]-1], commands))