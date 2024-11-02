import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int[][] map;
    static boolean[][][] visit; // 마지막은 벽안부순거, 부순거
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        map = new int[N][M];
        visit = new boolean[N][M][2];

        for(int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split("")).mapToInt(each -> Integer.parseInt(each)).toArray();
        }

        int result = bfs(0,0, N-1, M-1);
        System.out.println(result);
    }

    public static int bfs(int startX, int startY, int endX, int endY) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startX, startY, 1, map[startX][startY]}); //x, y, 칸수, 장애물
        if(map[startX][startY] == 0) {
            visit[startX][startY][0] = true;
        }else {
            visit[startX][startY][1] = true;
        }
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
                int obstacle = map[nextX][nextY];
                if(obstacle + current[3] > 1) { //이전에 장애물 부셨는데 또 부셔야 하는 경우
                    continue;
                }
                if(obstacle == 1) { //이번에 장애물 부셔야 하는 경우
                    if(!visit[nextX][nextY][1]) {
                        q.add(new int[]{nextX, nextY, current[2]+1, 1});
                        visit[nextX][nextY][1] = true;
                    }
                }else { //이번에 장애물 안부시는 경우
                    if(current[3] == 1 && !visit[nextX][nextY][1]) {//이전에 장애물 부신 경우
                        q.add(new int[]{nextX, nextY, current[2]+1, 1});
                        visit[nextX][nextY][1] = true;
                    }else if(current[3] == 0 && !visit[nextX][nextY][0]){ //장애물 안부신 경우
                        q.add(new int[]{nextX, nextY, current[2]+1, 0});
                        visit[nextX][nextY][0] = true;
                    }
                }
            }
        }
        return -1;
    }

}
