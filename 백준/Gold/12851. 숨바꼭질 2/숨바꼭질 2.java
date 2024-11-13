import java.io.*;
import java.util.*;

public class Main {

    static long[] mark = new long[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String[] split = br.readLine().split(" ");
        final int N = Integer.parseInt(split[0]);
        final int K = Integer.parseInt(split[1]);

        Arrays.fill(mark, Long.MAX_VALUE);
        if(N == K) {
            System.out.println(0);
            System.out.println(1);
            return;
        }

        Queue<long[]> q = new LinkedList<>();
        q.add(new long[]{N, 0}); //(n번째 칸, n번째 시간)
        long min = Long.MAX_VALUE;
        long count = 0;
        mark[N] = 0;
        while(!q.isEmpty()) {
            final long[] current = q.poll();
            if (current[1] > mark[(int) current[0]]) {
                continue;
            }
            mark[(int) current[0]] = current[1];
            if(current[0] == K) {
                if(current[1] < min) {
                    min = current[1];
                    count = 1;
                }else if(current[1] == min) {
                    count++;
                }else {
                    break;
                }
                continue;
            }

            if(current[0]*2 <= 100000 && mark[(int) current[0]*2] > current[1]+1) {
                q.add(new long[]{current[0]*2, current[1]+1});
            }
            if(current[0]-1 >= 0 && mark[(int) current[0]-1] > current[1]+1) {
                q.add(new long[]{current[0]-1, current[1]+1});
            }
            if(current[0]+1 <= 100000 && mark[(int) current[0]+1] > current[1]+1) {
                q.add(new long[]{current[0]+1, current[1]+1});
            }
        }

        System.out.println(min);
        System.out.println(count);
    }

}
