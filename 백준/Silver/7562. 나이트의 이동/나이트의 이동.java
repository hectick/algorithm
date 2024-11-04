import java.io.*;
import java.util.*;

public class Main {

    static int[] dx = new int[]{-1, -1, 1, 1, 2, 2, -2, -2};
    static int[] dy = new int[]{2, -2, 2, -2, 1, -1, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int T = Integer.parseInt(br.readLine());

        int[] result = new int[T];
        for(int i = 0; i < T; i++) {
            final int I = Integer.parseInt(br.readLine());
            int[] start = Arrays.stream(br.readLine().split(" ")).mapToInt(each -> Integer.parseInt(each)).toArray();
            int[] end = Arrays.stream(br.readLine().split(" ")).mapToInt(each -> Integer.parseInt(each)).toArray();
            int count = bfs(I, start, end);
            result[i] = count;
        }

        for(int res: result) {
            System.out.println(res);
        }
    }

    public static int bfs(int I, int[] start, int[] end) {
        boolean[][] visit = new boolean[I][I];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start[0], start[1], 0}); //x, y, count

        while(!q.isEmpty()) {
            final int[] current = q.poll();
            if(current[0] == end[0] && current[1] == end[1]) {
                return current[2];
            }
            for(int i = 0; i < dx.length; i++) {
                int nextX = current[0] + dx[i];
                int nextY = current[1] + dy[i];
                if(nextX < 0 || nextY < 0 || nextX >= I || nextY >= I) {
                    continue;
                }
                if(visit[nextX][nextY]) continue;
                q.add(new int[]{nextX, nextY, current[2]+1});
                visit[nextX][nextY] = true;
            }
        }

        return -1;
    }

}
