import java.io.*;
import java.util.*;

public class Main {

    static int[][] map;
    static int[] dx = {0, -1, 1, 0};
    static int[] dy = {1, 0, 0, -1};
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String[] firstLine = br.readLine().split(" ");
        N = Integer.parseInt(firstLine[0]);
        M = Integer.parseInt(firstLine[1]);
        map = new int[N][M];
        for(int i = 0; i < N; i++) {
            final int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(each -> Integer.parseInt(each))
                    .toArray();
            for(int k = 0; k < M; k++) {
                if(array[k] == 1) array[k] = 2;
            }
            map[i] = array;
        }

        final int time = dfs();
        System.out.println(time);
    }

    public static int dfs() {
        int time = 0;
        Queue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(q2 -> q2[2]));
        q.add(new int[]{0, 0, 0});
        map[0][0]--;

        while(!q.isEmpty()) {
            final int[] current = q.poll(); // 이건 공기임
            time = Math.max(time, current[2]);

            for(int i = 0; i < 4; i++) {
                final int nextX = current[0] + dx[i];
                final int nextY = current[1] + dy[i];
                if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
                    continue;
                }
                if(map[nextX][nextY] < 0) continue;
                if(map[nextX][nextY] == 2) {
                    map[nextX][nextY]--; // 부식만 시킨다
                    continue;
                }

                if(map[nextX][nextY] == 1) {
                    map[nextX][nextY] = -1;
                    q.add(new int[]{nextX, nextY, current[2] + 1}); //녹아서 공기가 된다
                }else {
                    map[nextX][nextY] = -1;
                    q.add(new int[]{nextX, nextY, current[2]}); //공기임
                }
            }
        }

        return time;
    }
}
