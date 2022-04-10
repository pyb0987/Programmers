def solution(number, k):
    answer = [number[0]]
    pointer = 1
    while(pointer<len(number)):
        while(answer and k>0 and answer[-1]<number[pointer]):
            k-=1
            answer.pop()
        answer.append(number[pointer])
        pointer +=1
    if (k>0):
        answer=answer[:-k]
    answer = ''.join(answer)
    return answer


    


print(solution("2111",3))
