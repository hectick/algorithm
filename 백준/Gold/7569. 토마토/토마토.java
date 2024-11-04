import java.io.*;
import java.util.*;

public class Main {

    static int[] dx = new int[]{-1, 0, 1, 0, 0, 0};
    static int[] dy = new int[]{0, -1, 0, 1, 0, 0};
    static int[] dz = new int[]{0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String[] split = br.readLine().split(" ");
        final int M = Integer.parseInt(split[0]); //가로칸 수
        final int N = Integer.parseInt(split[1]); //세로칸 수
        final int H = Integer.parseInt(split[2]); //높이

        int[][][] box = new int[H][N][M];
        Queue<int[]> q = new LinkedList<>(); //h, n, m

        int todo = 0; //익지 않은 토마토 수
        for(int i = 0; i < H; i++) {
            for(int j = 0; j < N; j++) {
                final int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                for(int k = 0; k < M; k++) {
                    box[i][j][k] = array[k];
                    if (array[k] == 0) {
                        todo++;
                    }else if(array[k] == 1) {
                        q.add(new int[]{i, j, k, 0});
                    }
                }
            }
        }

        if(todo == 0) {
            System.out.println(0);
            return;
        }

        int day = -1;
        while(!q.isEmpty()) {
            final int[] current = q.poll();
            day = Math.max(day, current[3]);
            for(int i = 0; i < dx.length; i++) {
                int nextX = current[0] + dx[i];
                int nextY = current[1] + dy[i];
                int nextZ = current[2] + dz[i];
                if(nextX <0 || nextY <0 || nextZ <0 || nextX >= H || nextY >= N || nextZ >= M) {
                    continue;
                }
                if(box[nextX][nextY][nextZ] != 0) {
                    continue;
                }
                q.add(new int[]{nextX, nextY, nextZ, current[3]+1});
                box[nextX][nextY][nextZ] = 1;
            }
        }

        for(int i = 0; i < H; i++) {
            for(int j = 0; j < N; j++) {
                for(int k = 0; k < M; k++) {
                    if(box[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }

        System.out.println(day);
    }

}
