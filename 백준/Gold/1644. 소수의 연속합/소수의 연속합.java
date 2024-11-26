import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int N = Integer.parseInt(br.readLine());

        List<Integer> sosu = findSosu(N);
        if(sosu.isEmpty()) {
            System.out.println(0);
            return;
        }
        
        int[] dp = new int[sosu.size() + 1];
        for(int i = 0; i < sosu.size(); i++) {
            dp[i+1] = dp[i] + sosu.get(i);
        }

        int left = 0;
        int right = 1;
        int result = 0;
        while(left < right && left < dp.length && right < dp.length) {
            final int value = dp[right] - dp[left];
            if(value == N) {
                left++;
                result++;
            }else if(value < N) {
                right ++;
            }else {
                left ++;
            }
        }

        System.out.println(result);
    }

    public static List<Integer> findSosu(int under) {
        List<Integer> sosu = new ArrayList<>();
        for(int i = 2; i <= under; i++) {
            boolean notSosu = false;
            for(int k = 2; k <= Math.sqrt(i); k++) {
                if(i % k == 0) {
                    notSosu = true;
                    break;
                }
            }
            if(!notSosu) {
                sosu.add(i);
            }
        }
        return sosu;
    }

}
