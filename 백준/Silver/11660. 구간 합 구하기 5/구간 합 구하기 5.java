import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String[] split = br.readLine().split(" ");
        final int N = Integer.parseInt(split[0]);
        final int M = Integer.parseInt(split[1]);

        int[][] map = new int[N+1][N+1];
        for(int i = 0; i < N;i ++) {
            final int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(each -> Integer.parseInt(each))
                    .toArray();
            for(int j = 1; j <= N; j++) {
                map[i+1][j] = arr[j-1];
            }
        }

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                map[i][j] = map[i][j] + map[i-1][j] + map[i][j-1] - map[i-1][j-1];
            }
        }

        int[] result = new int[M];
        for(int i = 0; i < M; i++){
            final String[] tmp = br.readLine().split(" ");
            int x1 = Integer.parseInt(tmp[0]);
            int y1 = Integer.parseInt(tmp[1]);
            int x2 = Integer.parseInt(tmp[2]);
            int y2 = Integer.parseInt(tmp[3]);

            result[i] = map[x2][y2] - map[x2][y1-1] - map[x1-1][y2] + map[x1-1][y1-1];
        }

        for(int res : result) {
            System.out.println(res);
        }
    }

}
