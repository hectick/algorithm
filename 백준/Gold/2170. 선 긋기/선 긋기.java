import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] xy = new int[N][2];
        for(int i = 0; i < N; i++) {
            final String[] split = br.readLine().split(" ");
            xy[i][0] = Integer.parseInt(split[0]);
            xy[i][1] = Integer.parseInt(split[1]);
        }

        Arrays.sort(xy, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);

        int sum = 0;
        int start = xy[0][0];
        int end = xy[0][1];
        for(int i = 1; i < N; i++) {
            if(xy[i][0] <= end) {
                if(end < xy[i][1]) end = xy[i][1];
            }else {
                sum += (end - start);
                start = xy[i][0];
                end = xy[i][1];
            }
        }
        sum += end - start;
        System.out.println(sum);

    }

}
