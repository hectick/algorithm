import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String[] split = br.readLine().split(" ");
        final int N = Integer.parseInt(split[0]);
        final int K = Integer.parseInt(split[1]);

        int[][] input = new int[N][2]; // 무게W, 가치V
        for(int i = 0; i < N; i++) {
            final String[] split1 = br.readLine().split(" ");
            input[i][0] = Integer.parseInt(split1[0]);
            input[i][1] = Integer.parseInt(split1[1]);
        }

        int[][] dp = new int[K+1][N+1];

        for(int i = 0; i < N; i++) {
            int w = input[i][0];
            int v = input[i][1];
            for (int j = 0; j <= K; j++) {
                if(j+w <= K) dp[j+w][i + 1] = Math.max(dp[j+w][i], dp[j][i] + v);
            }
            for (int j = 1; j <= K; j++) {
                if(dp[j][i+1] != 0) continue;
                dp[j][i+1] = dp[j][i];
            }
        }

        int max = 0;
        for(int i = 0; i < dp.length; i++)  {
            max = Math.max(dp[i][N], max);
        }

        System.out.println(max);
    }

}
