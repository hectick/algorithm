import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int N = Integer.parseInt(br.readLine());

        final int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(each -> Integer.parseInt(each)).toArray();

        final int[] fromLeft = new int[input.length];
        final int[] fromRight = new int[input.length];

        fromLeft[0] = 0;
        for(int i = 1; i < N; i++){
            for(int k = 0; k < i; k++) {
                if(input[i] > input[k]) {
                    fromLeft[i] = Math.max(fromLeft[k] + 1, fromLeft[i]);
                }
            }
        }

        fromRight[N-1] = 0;
        for(int i = N-2; i >= 0; i--){
            for(int k = N-1; k > i; k--) {
                if(input[i] > input[k]) {
                    fromRight[i] = Math.max(fromRight[k] + 1, fromRight[i]);
                }
            }
        }

        int max = 0;
        for(int i = 0; i < N; i++) {
            max = Math.max(max, fromLeft[i] + fromRight[i] + 1);
        }

        System.out.println(max);

    }

}
