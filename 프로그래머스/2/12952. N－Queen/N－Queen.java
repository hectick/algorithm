import java.util.*;

class Solution {
    int answer = 0;
    int N;
    int[] visit;
    
    public int solution(int n) {
        N = n;
        visit = new int[n];
        func(0, new int[n]);
        return answer;
    }
    
    public void func(int count, int[] arr) {
        if(count == N) {
            answer++;
            return;
        }
        
        for(int i = 0; i < N; i++) {
            if(visit[i] == 1) continue;
            boolean continueFlag = false;
            for(int k = 0; k < count; k++) {
                int compareX = arr[k];
                int compareY = k;
                if(Math.abs(compareX - i) == Math.abs(compareY - count)) {
                    continueFlag = true;
                    break;
                }
            }
            if(continueFlag) continue;
            arr[count] = i;
            visit[i] = 1;
            func(count+1, arr);
            visit[i] = 0;
        }
    }
}