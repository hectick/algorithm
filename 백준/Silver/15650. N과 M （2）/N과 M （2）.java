import java.io.*;

public class Main {

    static boolean[] visit;
    static int N;
    static int M;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        visit = new boolean[N+1];
        arr = new int[M];

        func(0, 1);
    }

    public static void func(int toInsert, int start) {
        if(toInsert == M) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < M; i++) {
                if(i == M-1) sb.append(arr[i]);
                else sb.append(arr[i]).append(" ");
            }
            System.out.println(sb);
            return;
        }
        for(int i = start; i <= N; i++) {
            if(visit[i]) continue;
            arr[toInsert] = i;
            visit[i] = true;
            func(toInsert+1, i+1);
            visit[i] = false;
        }
    }


}
