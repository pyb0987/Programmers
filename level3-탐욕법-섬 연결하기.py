def solution(n, costs):
    from itertools import combinations
    Tcost = 0
    costs = sorted(costs, key=lambda x : x[2])
    island = [set([costs[0][0]])]
    for bridge in costs:
        for group in island:
            if (bridge[0] not in group) ^ (bridge[1] not in group):
                Tcost += bridge[2]
                group.add(bridge[0])
                group.add(bridge[1])
                break
            elif (bridge[0] in group) and (bridge[1] in group):
                break
        else:
            island.append(set([bridge[0],bridge[1]]))
            Tcost += bridge[2]
        if len(island)>1:
            for i,j in (combinations(island, 2)):
                if i&j:
                    island.append(i | j)
                    island.remove(i)
                    island.remove(j)
                    break
    return


    


print(solution(4, [[0,1,1],[0,2,2],[1,2,5],[1,3,1],[2,3,8]]))
print(solution(5, [[0,1,1],[1,2,2],[3,2,3],[4,3,1],[4,0,8]]))