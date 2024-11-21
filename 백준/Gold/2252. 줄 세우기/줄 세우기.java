import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        int[] degree = new int[N+1];
        for(int i = 0; i < M; i++) {
            final String[] input = br.readLine().split(" ");
            int first = Integer.parseInt(input[0]);
            int second = Integer.parseInt(input[1]);
            degree[second]++;
            graph.get(first).add(second);
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            if(degree[i] == 0) q.add(i);
        }
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()) {
            final Integer current = q.poll();
            sb.append(current).append(" ");

            final List<Integer> next = graph.get(current);
            for(int each : next) {
                degree[each]--;
                if(degree[each] == 0)q.add(each);
            }
        }
        System.out.println(sb);
    }

}
