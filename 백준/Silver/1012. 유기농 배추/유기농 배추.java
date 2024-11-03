import java.io.*;
import java.util.*;

public class Main {

    static int[][] map;
    static int M;
    static int N;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int T = Integer.parseInt(br.readLine());
        int[] result = new int[T];

        for(int a = 0; a < T; a++) {
            final String[] split = br.readLine().split(" ");
            M = Integer.parseInt(split[0]); //가로길이
            N = Integer.parseInt(split[1]); //세로길이
            final int K = Integer.parseInt(split[2]); //배추 개수
            map = new int[M][N];
            //배추 위치
            for(int i = 0; i < K; i++) {
                final String[] tmp = br.readLine().split(" ");
                int x = Integer.parseInt(tmp[0]);
                int y = Integer.parseInt(tmp[1]);
                map[x][y] = 1;
            }

            int count = 0;
            for(int i = 0; i < M; i++) {
                for(int j = 0; j < N; j++) {
                    if(map[i][j] == 1){
                        count++;
                        bfs(i, j);
                    }
                }
            }

            result[a] = count;
        }

        for(int res : result) {
            System.out.println(res);
        }
    }

    public static void bfs(int a, int b) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{a, b});
        map[a][b] = 0;

        while(!q.isEmpty()) {
            final int[] current = q.poll();
            for(int i = 0; i < dx.length; i++) {
                int nextX = current[0] + dx[i];
                int nextY = current[1] + dy[i];
                if(nextX < 0 || nextY < 0 || nextX >= M || nextY >= N) continue;
                if(map[nextX][nextY] != 1) continue;
                q.add(new int[]{nextX, nextY});
                map[nextX][nextY] = 0;
            }
        }
    }

}
