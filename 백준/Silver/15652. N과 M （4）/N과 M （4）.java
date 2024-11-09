import java.io.*;

public class Main {

    static int N;
    static int M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        arr = new int[M];

        func(0, 1);
        System.out.println(sb);
    }

    public static void func(int toInsert, int start) {
        if(toInsert == M) {
            for(int i = 0; i < M; i++) {
                if(i == M-1) sb.append(arr[i]);
                else sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i = start; i <= N; i++) {
            arr[toInsert] = i;
            func(toInsert+1, i);
        }
    }


}
