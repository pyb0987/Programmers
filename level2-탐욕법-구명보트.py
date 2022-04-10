def solution(people, limit):
    people.sort()
    answer = 0
    bp = len(people)-1
    fp = 0
    while(bp>=fp):
        if (people[bp]+people[fp]<=limit):
            fp +=1
        bp -= 1
        answer+=1
        
    return answer