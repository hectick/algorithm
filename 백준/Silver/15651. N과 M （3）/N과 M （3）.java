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
        for(int i = 1; i <= N; i++) {
            arr[toInsert] = i;
            func(toInsert+1);
        }
    }


}
