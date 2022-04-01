def solution(priorities, location):
    levelN = priorities[location]
    follow = location
    N =len(priorities)
    answer=0
    for i in range(9,levelN,-1):
        if (i in priorities):
            answer+=priorities.count(i)
            last_indexM = N-1-priorities[::-1].index(i)
            priorities=priorities[(last_indexM+1):]+priorities[:(last_indexM+1)]
            follow=(follow-1+N-last_indexM)%N
    answer+=priorities[:follow+1].count(levelN)

    return answer
