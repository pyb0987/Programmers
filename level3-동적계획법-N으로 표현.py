
def solution(N, number):
    if number==N:
        return 1
    answerList = [{0},{N},{N*11}, {N*111},{N*1111},{N*11111},{N*111111},{N*1111111},{N*11111111}]
    numnum = 1
    while(numnum<8):
        numnum+=1
        for x in range(1,numnum):
            appendset = [j+k for j in answerList[x] for k in answerList[numnum-x]]
            +[j-k for j in answerList[x] for k in answerList[numnum-x]]
            +[j*k for j in answerList[x] for k in answerList[numnum-x]]
            +[j//k for j in answerList[x] for k in answerList[numnum-x] if k!=0]
            answerList[numnum].update(appendset)
        if number in answerList[numnum]:
            return numnum
    return -1
    




print(solution(2, 486))