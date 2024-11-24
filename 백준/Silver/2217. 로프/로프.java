import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] inputs = new int[N];
        
        for(int i = 0; i < N; i++) {
            inputs[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(inputs);

        int max = 0;
        for(int i = 0; i < N; i++) {
            final int maxWeight = inputs[i] * (N - i);
            max = Math.max(maxWeight, max);
        }

        System.out.println(max);
    }

}
