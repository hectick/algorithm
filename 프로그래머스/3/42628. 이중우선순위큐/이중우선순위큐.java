import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
        boolean maxFlag = true;
        
        for(int i = 0; i < operations.length; i++) {
            String[] split = operations[i].split(" ");
            int number = Integer.parseInt(split[1]);
            if(split[0].equals("I")) {
                if(maxFlag) {
                    maxQ.add(number);
                }else {
                    minQ.add(number);
                }
            }else if(split[0].equals("D") && number == -1) {
                if(maxFlag) {
                    maxFlag = false;
                    while(!maxQ.isEmpty()){
                        int tmp = maxQ.poll();
                        minQ.add(tmp);
                    }
                    minQ.poll();
                }else {
                    minQ.poll();
                }
            }else if(split[0].equals("D") && number == 1) {
                if(maxFlag) {
                    maxQ.poll();
                }else {
                    maxFlag = true;
                    while(!minQ.isEmpty()){
                        int tmp = minQ.poll();
                        maxQ.add(tmp);
                    }
                    maxQ.poll();
                }
            }
        }
        
        
        if(maxFlag && maxQ.isEmpty()) {
            return new int[]{0, 0};
        }
        if(!maxFlag && minQ.isEmpty()) {
            return new int[]{0, 0};
        }
        int max = -1;
        int min = -1;
        if(maxFlag) {
            max = maxQ.poll();
            min = max;
            while(!maxQ.isEmpty()) {
                min = maxQ.poll();
            }
        }else {
            max = minQ.poll();
            min = max;
            while(!minQ.isEmpty()) {
                max = minQ.poll();
            }
        }
        return new int[]{max, min};
    }
}