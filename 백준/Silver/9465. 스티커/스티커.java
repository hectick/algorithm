import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] result = new int[T];
        for(int i = 0; i < T; i++) {
            final int n = Integer.parseInt(br.readLine());
            int[][] dp = new int[3][n]; //위 선택, 아래 선택, 선택x
            dp[0] = Arrays.stream(br.readLine().split(" ")).mapToInt(each -> Integer.parseInt(each)).toArray();
            dp[1] = Arrays.stream(br.readLine().split(" ")).mapToInt(each -> Integer.parseInt(each)).toArray();

            for(int k = 1; k < n; k++) {
                dp[0][k] = dp[0][k] + Math.max(dp[1][k-1], dp[2][k-1]);
                dp[1][k] = dp[1][k] + Math.max(dp[0][k-1], dp[2][k-1]);
                dp[2][k] = Math.max(dp[0][k-1], dp[1][k-1]);
            }

            result[i] = Math.max(Math.max(dp[0][n-1], dp[1][n-1]), dp[2][n-1]);
        }

        StringBuilder sb = new StringBuilder();
        for(int each: result) {
            sb.append(each).append("\n");
        }

        System.out.println(sb);
    }

}
