def solution(triangle):
    n = len(triangle)
    dp=[[0 for i in range(j+1)] for j in range(n)]
    for j in range(n):
        for i in range(j+1):
            if j==0:
                dp[j][i] = triangle[j][i]
            elif i==0:
                dp[j][i]= triangle[j][i]+dp[j-1][i]
            elif i==j:
                dp[j][i]= triangle[j][i]+dp[j-1][i-1]
            else:
                dp[j][i]= triangle[j][i]+max(dp[j-1][i-1],dp[j-1][i])
    answer = max(dp[-1])
    return answer

solution([[7], [3, 8], [8, 1, 0], [2, 7, 4, 4], [4, 5, 2, 6, 5]])