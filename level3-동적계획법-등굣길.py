def solution(m, n, puddles):
    dp = [[-1 if [i+1,j+1] in puddles else 0 for i in range(m)] for j in range(n)]
    for j in range(n):
        for i in range(m):
            if dp[j][i]==-1:
                dp[j][i]=0
            elif i==0 and j==0:
                dp[i][j]=1
            elif i ==0:
                dp[j][i]=dp[j-1][i]
            elif j==0:
                dp[j][i]=dp[j][i-1]
            else:
                dp[j][i]=dp[j][i-1]+dp[j-1][i]
    return dp[-1][-1]%1000000007

solution(4,3, [[2, 2]])