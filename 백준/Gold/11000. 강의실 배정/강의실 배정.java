import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int N = Integer.parseInt(br.readLine());

        int[][] time = new int[N][2];
        for(int i = 0; i < N; i++) {
            time[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        Arrays.sort(time, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);

        int roomSize = 0;
        PriorityQueue<Integer> room = new PriorityQueue<>();
        for(int i = 0; i < N; i++) {
            if(room.isEmpty()) {
                room.add(time[i][1]);
            }else if(time[i][0] < room.peek()) {
                room.add(time[i][1]);
            }else {
                room.poll();
                room.add(time[i][1]);
            }
            roomSize = Math.max(roomSize, room.size());
        }

        System.out.println(roomSize);


    }

}
