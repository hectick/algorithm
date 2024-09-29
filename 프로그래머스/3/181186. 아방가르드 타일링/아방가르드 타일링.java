import java.util.*;

class Solution {
    long C = 1000000007;
    
    public int solution(int n) {
        long[] dp = new long[n+1];
        long[] sum = new long[n+1];
        dp[1] = 1; //1개짜리 1개
        if(n >= 2) dp[2] = 3; //2개짜리 2개
        if(n >= 3) dp[3] = 5 + dp[2]  + dp[1]*2; // 10
        if(n >= 4) dp[4] = 2 + dp[3] + dp[2]*2 + dp[1]*5; //4개짜리 2개 + 먼가
        if(n >= 5) dp[5] = 2 + dp[4] + dp[3]*2 + dp[2]*5 + dp[1] * 2;

        if(n >= 6) {
            sum[1] = dp[1];
            sum[2] = dp[2];
            sum[3] = dp[3];
            sum[4] = dp[1] + dp[4];
            sum[5] = dp[2] + dp[5];
        }else{
            return (int)dp[n];
        }

        for(int i = 6; i <= n; i++) {
            dp[i] = (dp[i-3]*5%C + dp[i-2]*2%C + dp[i-1]%C)%C;
            dp[i] = (dp[i]%C + sum[i-4]*2%C)%C;
            dp[i] = (dp[i]%C + sum[i-5]*2%C)%C;
            dp[i] = (dp[i]%C + sum[i-6]*4%C)%C;
            if((i - 4)%3 == 0) {
                dp[i] = (dp[i] + 2)%C;
            }
            if((i - 5)%3 == 0) {
                dp[i] = (dp[i] + 2)%C;
            }
            if((i - 6)%3 == 0) {
                dp[i] = (dp[i] + 4)%C;
            }
            sum[i] = (sum[i-3]%C + dp[i]%C)%C;
        }
        return (int)dp[n];
    }
}