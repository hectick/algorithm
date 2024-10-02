import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        //현재까지중 소요되는 시간이 가장 작업을 한다.
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        
        int before = -1;
        int now = 0;
        int timeSum = 0;
        int done = 0;
        while(done < jobs.length) {
            for(int i = 0; i < jobs.length; i++) {
                if(jobs[i][0] > before && jobs[i][0] <= now) {
                    pq.add(jobs[i]);
                }
            }
            if(pq.isEmpty()) {
                before = now;
                now++;
                continue;
            }
            //작업한다.
            int[] poll = pq.poll();
            before = now;
            now += poll[1];
            timeSum += now - poll[0];
            done++;
        }
    
        return timeSum/jobs.length;
    }
}