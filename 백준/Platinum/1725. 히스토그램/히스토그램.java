import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int N = Integer.parseInt(br.readLine());
        Stack<long[]> s = new Stack<>();
        long max = 0;
        for(int i = 0; i <= N; i++) {
            long h = 0;
            if(i != N) h = Long.parseLong(br.readLine());
            long tmp = i; // tmp는 나의 idx or 내 이전 중 나보다 큰 젤 왼쪽놈 idx
            while(!s.isEmpty() && s.peek()[0] > h) { //나보다 큰놈 다 pop
                final long[] pop = s.pop();
                final long x = pop[0] * (i - pop[1]);
                max = Math.max(max, x);
                tmp = pop[1];
            }
            s.push(new long[]{h, tmp});
        }

        System.out.println(max);
    }

}
