import java.util.*;

class Solution {
    Map<Integer, Integer> dp;
    public int solution(int N, int number) {
        dp = new HashMap<>();
        
        int turn = 1;
        dp.put(N, 1);
        dp.put(N + 10*N, 2);
        dp.put(N + 10*N + 100*N, 3);
        dp.put(N + 10*N + 100*N + 1000*N, 4);
        dp.put(N + 10*N + 100*N + 1000*N + 10000*N, 5);
        dp.put(N + 10*N + 100*N + 1000*N + 10000*N + 100000*N, 6);
        dp.put(N + 10*N + 100*N + 1000*N + 10000*N + 100000*N + 1000000*N, 7);
        dp.put(N + 10*N + 100*N + 1000*N + 10000*N + 100000*N + 1000000*N + 10000000*N, 8);
        
        for(turn = 2; turn <= 9; turn++) {
            if(turn == 9) return -1;
            
            int size = dp.size();
            List<Integer> list = new ArrayList<>(dp.keySet());
            for(int i = 0; i < size; i++) {
                int n1 = list.get(i);
                
                for(int j = 0; j < size; j++) {
                    int n2 = list.get(j);
                    
                    int t = dp.get(n1) + dp.get(n2);
                    if(t > 8) continue;

                    int minus = n1 - n2;
                    int plus = n1 + n2;
                    int multiple = n1 * n2;
                    int divide = n1 / n2;
                    if(minus > 0) {
                        dp.put(minus, Math.min(t, dp.getOrDefault(minus, Integer.MAX_VALUE)));
                    }
                    if(plus > 0){
                        dp.put(plus, Math.min(t, dp.getOrDefault(plus, Integer.MAX_VALUE)));
                    }
                    if(multiple > 0){
                        dp.put(multiple, Math.min(t, dp.getOrDefault(multiple, Integer.MAX_VALUE)));
                    }
                    if(divide > 0){
                        dp.put(divide, Math.min(t, dp.getOrDefault(divide, Integer.MAX_VALUE)));
                    }
                }
            }
            
            if(dp.getOrDefault(number, Integer.MAX_VALUE) <= 8) {
                break;
            }
        }
        return dp.getOrDefault(number, Integer.MAX_VALUE) > 8 ? -1 : dp.getOrDefault(number, Integer.MAX_VALUE);
    }
}