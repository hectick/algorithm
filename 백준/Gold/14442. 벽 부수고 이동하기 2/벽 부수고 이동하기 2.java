import java.io.*;
import java.util.*;

public class Main {
    
    static int N;
    static int M;
    static int K;
    static int[][] map;
    static boolean[][][] visit; // 마지막은 벽을 N개 부순거
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        K = Integer.parseInt(split[2]);
        map = new int[N][M];
        visit = new boolean[N][M][K+1];

        for(int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split("")).mapToInt(each -> Integer.parseInt(each)).toArray();
        }

        int result = bfs(0,0, N-1, M-1);
        System.out.println(result);
    }

    public static int bfs(int startX, int startY, int endX, int endY) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startX, startY, 1, map[startX][startY]}); //x, y, 칸수, 장애물
        visit[startX][startY][map[startX][startY]] = true;

        while(!q.isEmpty()) {
            final int[] current = q.poll();
            if(current[0] == endX && current[1] == endY) {
                return current[2];
            }

            for(int i = 0; i < dx.length; i++) {
                int nextX = current[0] + dx[i];
                int nextY = current[1] + dy[i];
                if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
                    continue;
                }
                int currentObstacle = map[nextX][nextY];
                final int totalObstacle = currentObstacle + current[3];
                if(totalObstacle > K) { //이전에 장애물 K개 부셨는데 또 부셔야 하는 경우
                    continue;
                }
                if(!visit[nextX][nextY][totalObstacle]) {
                    q.add(new int[]{nextX, nextY, current[2]+1, totalObstacle});
                    visit[nextX][nextY][totalObstacle] = true;
                }
            }
        }
        return -1;
    }


}
