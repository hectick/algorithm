import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        if (s / n == 0) {
            return new int[]{-1};
        }
        
        int[] answer = new int[n];
        if (s % n == 0) {
            for(int i = 0; i < n; i++) {
                answer[i] = s/n;
            }
            return answer;
        }
        // 2 2 2 3 / 1 2 3 3
        int a = s / n;
        int b = s % n;
        for(int i = n-1; i >= 0 ; i--) {
            if(b != 0) {
                answer[i]++;
                b--;
            }
            answer[i] += a;
        }
        return answer;
    }
}