
def solution(money):
    if len(money)==3:
        return max(money)

    rests = [[0,0]+money[3:], [0,0]+money[4:]+[money[0]]]
    if len(money)>4:
        rests.append([0,0]+money[5:]+money[:2])
    dp = [[0 for _ in range(len(money)-1)] for _ in range(2)]
    answer=0

    for k in range(len(rests)):
        for i in range(2, len(money)-1):
            for j in range(2):
                if j==0:
                    dp[j][i]=rests[k][i]+max(dp[0][i-2],dp[1][i-2])
                else:
                    dp[j][i]=max(dp[0][i-1],dp[1][i-1])
        answer = max((money[1+k]+max(dp[0][-1],dp[1][-1])), answer)

    return answer



print(solution([1,0,2,3,0,4,0,5,6,0]))