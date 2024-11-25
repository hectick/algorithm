import java.io.*;
import java.util.*;

public class Main {

    static int[] result = new int[2];
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for(int i = 0; i < N; i++) {
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(each -> Integer.parseInt(each)).toArray();
        }

        count(0, 0, N, N);

        System.out.println(result[0]);
        System.out.println(result[1]);
    }

    public static void count(int startX, int startY, int endX, int endY) {
        int color = board[startX][startY];
        boolean split = false;
        for(int x = startX; x < endX; x++) {
            for(int y = startY; y < endY; y++) {
                if(color != board[x][y]) {
                    split = true;
                    break;
                }
            }
            if(split) {
                break;
            }
        }
        if(split) {
            int midX = (startX + endX) / 2;
            int midY = (startY + endY) / 2;
            count(startX, startY, midX, midY);
            count(startX, midY, midX, endY);
            count(midX, startY, endX, midY);
            count(midX, midY, endX, endY);
        }
        if(!split) {
            result[color]++;
        }
    }
}
