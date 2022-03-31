def solution(clothes):
    result=1
    dic = {}
    for i in clothes:
        dic[i[1]]=dic.get(i[1],0)+1
    for i in dic.values():
        result*=i+1
    return result-1