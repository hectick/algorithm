import java.io.*;
import java.util.*;

public class Main {

    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(each -> Integer.parseInt(each))
                    .toArray();
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                int result = dfs(i, j, N);
                sb.append(result).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static int dfs(int from, int to, int N) {
        Stack<Integer> s = new Stack<>();
        boolean[] visit = new boolean[N];
        s.push(from);
        visit[from] = true;

        while(!s.isEmpty()) {
            final Integer pop = s.pop();
            for(int i = 0; i < map.length; i++) {
                if(!visit[i] && map[pop][i] == 1) {
                    s.push(i);
                    visit[i] = true;
                    if(i == to) {
                        return 1;
                    }
                }
                if(i == to && map[pop][i] == 1) {
                    return 1;
                }
            }
        }

        return 0;
    }
}
