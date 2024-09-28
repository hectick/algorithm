import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        
        long res = (long) times[times.length-1] * n;
        long left = times[0];
        long right = res;
        while(left <= right) {
            long mid = (left + right)/2;
            
            long sum = 0;
            for(int i = 0; i < times.length; i++) {
                sum += mid / times[i];
                if(sum >= n) {
                    break;
                }
            }
            
            if(sum >= n) {
                right = mid - 1;
                res = mid;
            }
            
            if(sum < n) {
                left = mid + 1;
            }
        }
        return res;
    }
}