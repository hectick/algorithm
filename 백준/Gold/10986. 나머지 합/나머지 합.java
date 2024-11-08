import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String[] split = br.readLine().split(" ");
        final int N = Integer.parseInt(split[0]);
        final int M = Integer.parseInt(split[1]);

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(each->Integer.parseInt(each)).toArray();

        for(int i = 0; i < N; i++) {
            arr[i] = arr[i] % M;
        }

        int[] 나머지 = new int[M];
        int 누적합 = 0;

        for(int i = 0; i < N; i++) {
            누적합 += arr[i];
            누적합 %= M;
            나머지[누적합]++;
        }

        long count = 나머지[0];
        for(int i = 0; i < M; i++) {
            int k = 나머지[i];
            count += ((long)k*k - k)/2;
        }

        System.out.println(count);

    }

}
