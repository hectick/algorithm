import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        final int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            final int K = Integer.parseInt(br.readLine());
            TreeMap<Long, Integer> map = new TreeMap<>();
            
            for (int j = 0; j < K; j++) {
                final String[] input = br.readLine().split(" ");
                long number = Long.parseLong(input[1]);
                
                if (input[0].equals("I")) {
                    final Integer count = map.getOrDefault(number, 0);
                    map.put(number, count + 1);
                } else {
                    if (map.isEmpty()) {
                        continue;
                    }
                    if (number < 0) {
                        final Long key = map.firstKey();
                        final Integer count = map.get(key);
                        if (count - 1 == 0) {
                            map.pollFirstEntry();
                        } else {
                            map.put(key, count - 1);
                        }
                    } else {
                        final Long key = map.lastKey();
                        final Integer count = map.get(key);
                        if (count - 1 == 0) {
                            map.pollLastEntry();
                        } else {
                            map.put(key, count - 1);
                        }
                    }
                }
            }
            if (map.isEmpty()) {
                sb.append("EMPTY").append("\n");
            } else {
                sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
            }
        }

        System.out.println(sb);
    }
}
