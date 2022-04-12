def solution(n, computers):
    dp = [i for i in range(n)]
    for j in range(n):
        for i in range(n):
            if computers[i][j]==1:
                dp = [min(dp[i],dp[j]) if k==max(dp[i],dp[j]) else k for k in dp]

    return len(set(dp))


        
