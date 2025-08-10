import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int div = 15746;

        int[] arr = new int[N+1];
        arr[1] = 1;
        if(N == 1) {
            System.out.println(arr[1]);
            return;
        }
        arr[2] = 2;

        for(int i = 3; i <= N; i++) {
            arr[i] = (arr[i-2] + arr[i-1]) % div ;
        }

        System.out.println(arr[N]);
    }

}