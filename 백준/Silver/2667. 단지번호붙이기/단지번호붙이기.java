import java.io.*;
import java.util.*;

public class Main {

    static int[][] map;
    static Map<Integer, Integer> tagToCount = new HashMap<>();
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for(int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split("")).mapToInt(each -> Integer.parseInt(each)).toArray();
        }

        int tag = 1;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] == 1) {
                    tag++;
                    bfs(i, j, tag);
                }
            }
        }

        System.out.println(tag-1);
        int[] result = new int[tag-1];
        for(int i = 2; i <= tag; i++) {
            result[i-2] = tagToCount.get(i);
        }
        Arrays.sort(result);
        for(int each: result) {
            System.out.println(each);
        }
    }

    public static void bfs(int a, int b, int tag) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{a, b});
        map[a][b] = tag;
        int count = 1;

        while(!q.isEmpty()) {
            final int[] current = q.poll();
            for(int i = 0; i < dx.length; i++) {
                int nextX = current[0] + dx[i];
                int nextY = current[1] + dy[i];
                if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) continue;
                if(map[nextX][nextY] != 1) continue;
                q.add(new int[]{nextX, nextY});
                map[nextX][nextY] = tag;
                count++;
            }
        }
        tagToCount.put(tag, count);
    }

}
