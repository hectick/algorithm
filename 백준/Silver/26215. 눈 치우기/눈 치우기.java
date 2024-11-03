import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());

        final int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(each -> Integer.parseInt(each)).toArray();

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int each : arr) {
            pq.add(each);
        }
        int result = 0;
        while(pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            a -= 1;
            b -= 1;
            result ++;
            if(a != 0) {
                pq.add(a);
            }
            if(b != 0) {
                pq.add(b);
            }
        }
        if(!pq.isEmpty()) {
            int extra = pq.poll();
            result += extra;
        }
        if(result > 1440) {
            System.out.println(-1);
        }else {
            System.out.println(result);
        }

    }

}
