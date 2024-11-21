import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int N = Integer.parseInt(br.readLine());

        int total = 180 * (N-1);

        final int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(each -> Integer.parseInt(each)).toArray();

        for(int i = 0; i < arr.length; i++) {
            total -= arr[i]*2;
        }

        System.out.println(total);
    }

}
