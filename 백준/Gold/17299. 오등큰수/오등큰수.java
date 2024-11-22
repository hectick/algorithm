import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int N = Integer.parseInt(br.readLine());
        final int[] result = new int[N];
        Map<Integer, Integer> numberCount = new HashMap<>();

        final int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(each -> Integer.parseInt(each)).toArray();
        for (int number : input) {
            final Integer count = numberCount.getOrDefault(number, 0);
            numberCount.put(number, count+1);
        }
        
        Stack<int[]> s = new Stack<>();
        s.push(new int[]{input[N-1], numberCount.getOrDefault(input[N-1], 0)});
        result[N-1] = -1;

        for(int i = N-2; i >= 0; i--){
            final Integer currentCount = numberCount.getOrDefault(input[i], 0);
            while(!s.isEmpty() && s.peek()[1] <= currentCount) {
                s.pop();
            }
            int 오등큰수 = -1;
            if(!s.isEmpty() && s.peek()[1] > currentCount) {
                오등큰수 = s.peek()[0];
            }
            result[i] = 오등큰수;
            s.push(new int[]{input[i], currentCount});
        }

        StringBuilder sb = new StringBuilder();
        for (int i : result) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }

}
