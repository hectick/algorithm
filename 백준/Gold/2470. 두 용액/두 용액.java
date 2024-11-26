import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int N = Integer.parseInt(br.readLine());

        final int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(each -> Integer.parseInt(each)).toArray();

        Arrays.sort(input);

        // 양 끝에서 시작
        int left = 0;
        int right = N - 1;

        int min = Integer.MAX_VALUE;
        int minLeft = left, minRight = right;

        while (left < right) {
            int sum = input[left] + input[right];

            if (Math.abs(sum) < Math.abs(min)) {
                min = sum;
                minLeft = left;
                minRight = right;
            }

            if (sum <= 0) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println(input[minLeft] + " " + input[minRight]);
    }
}
