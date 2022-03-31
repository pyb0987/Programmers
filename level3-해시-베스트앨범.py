def solution(genres, plays):
    from collections import defaultdict
    a = sorted(zip(genres, plays, range(len(genres))), key =lambda x : -x[1])
    d = defaultdict(lambda:[0,[]])
    for i in a:
        d[i[0]][0]+=i[1]
        d[i[0]][1].append(i[2])
    answer=[]
    for i in sorted(d.values(), reverse=True):
        answer.extend(i[1][:min(2, len(i[1]))])
    return answer


solution(["A", "B", "A", "B", "A", "C"] ,[500, 600, 150, 800, 2500, 5000] )
