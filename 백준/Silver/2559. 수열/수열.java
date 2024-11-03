import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int K = Integer.parseInt(split[1]);

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(each -> Integer.parseInt(each)).toArray();

        for(int i = 1; i < arr.length; i++) {
            arr[i] = arr[i-1] + arr[i];
        }

        int result = arr[K-1];
        for(int i = K; i < arr.length; i++) {
            result = Math.max(arr[i] - arr[i-K], result);
        }
        System.out.println(result);
    }

}
