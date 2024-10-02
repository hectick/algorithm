import java.util.*;

class Solution {
    
    Map<Integer, List<Integer>> map = new HashMap<>();
    int[] nodes;
    public int solution(int n, int[][] edge) {
        for(int i = 1; i <= n ; i++) {
            map.put(i, new ArrayList());
        }
        nodes = new int[n+1];
        
        for(int i = 0; i < edge.length; i++) { 
            int a = edge[i][0];
            int b = edge[i][1];
            
            List<Integer> list1 = map.get(a);
            list1.add(b);
            map.put(a, list1);
            
            List<Integer> list2 = map.get(b);
            list2.add(a);
            map.put(b, list2);
        }
        
        dfs(1);
        
        Arrays.sort(nodes);
        int max = nodes[nodes.length-1];
        int answer = 0;
        for(int i = nodes.length-1; i >= 2; i--) {
            if(nodes[i] == max) {
                answer++;
            }
        }
        return answer;
    }
    
    public void dfs(int start) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start, 1});
        
        while(!q.isEmpty()) {
            int[] current = q.poll();
            int index = current[0];
            int distance = current[1];
            if(nodes[index] == 0) {
                nodes[index] = distance; //방문처리
            }else {
                continue;
            }
            List<Integer> list = map.get(index);
            for(int i = 0; i < list.size(); i++) {
                int next = list.get(i);
                if(nodes[next] == 0) {
                    q.add(new int[]{next, distance+1});
                }
            }
            
        }
    }
    
//     int[][] map;
//     int[] nodes;
//     public int solution(int n, int[][] edge) {
//         map = new int[n+1][n+1];
//         nodes = new int[n+1];
        
//         for(int i = 0; i < edge.length; i++) {        
//             map[edge[i][0]][edge[i][1]] = 1;
//             map[edge[i][1]][edge[i][0]] = 1;
//         }
        
//         dfs(1);
        
//         Arrays.sort(nodes);
//         int max = nodes[nodes.length-1];
//         int answer = 0;
//         for(int i = nodes.length-1; i >= 2; i--) {
//             if(nodes[i] == max) {
//                 answer++;
//             }
//         }
//         return answer;
//     }
    
//     public void dfs(int start) {
//         Queue<int[]> q = new LinkedList<>();
//         q.add(new int[]{start, 1});
        
//         while(!q.isEmpty()) {
//             int[] current = q.poll();
//             int index = current[0];
//             int distance = current[1];
//             if(nodes[index] == 0) {
//                 nodes[index] = distance; //방문처리
//             }else {
//                 continue;
//             }
//             for(int i = 1; i < map.length; i++) {
//                 if(i == index) continue;
//                 if(map[i][index] == 1 && nodes[i] == 0) {
//                     q.add(new int[]{i, distance+1});
//                 }
//             }
            
//         }
//     }
}