import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int N = Integer.parseInt(br.readLine());
        final int[] result = new int[N];

        final int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(each -> Integer.parseInt(each)).toArray();
        Stack<Integer> s = new Stack<>();
        s.push(input[N-1]);
        result[N-1] = -1;

        for(int i = N-2; i >= 0; i--) {
            while(!s.isEmpty() && s.peek() <= input[i]) { // 스택의 젤 위에가 현재 수보다 클때까지
                s.pop();
            }
            int 오큰수 = -1;
            if(!s.isEmpty() && s.peek() > input[i]) 오큰수 = s.peek();
            result[i] = 오큰수;
            s.push(input[i]);
        }

        StringBuilder sb = new StringBuilder();

        for (int i : result) {
            sb.append(i).append(" ");
        }

        System.out.println(sb);
    }

}
