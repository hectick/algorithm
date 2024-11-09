import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int[] arr;
    static int[] input;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        arr = new int[M];
        visit = new boolean[N];
        input = Arrays.stream(br.readLine().split(" ")).mapToInt(each->Integer.parseInt(each)).toArray();
        Arrays.sort(input);

        func(0);
        System.out.println(sb);
    }

    public static void func(int toInsert) {
        if(toInsert == M) {
            for(int i = 0; i < M; i++) {
                if(i == M-1) sb.append(arr[i]);
                else sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i = 0; i < N; i++) {
            if(visit[i]) continue;
            visit[i] = true;
            arr[toInsert] = input[i];
            func(toInsert+1);
            visit[i] = false;
        }
    }


}
