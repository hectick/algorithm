import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            final int N = Integer.parseInt(br.readLine());
            Map<String, List<String>> map = new HashMap<>();

            for (int j = 0; j < N; j++) {
                final String[] split = br.readLine().split(" ");
                final List<String> list = map.getOrDefault(split[1], new ArrayList<>());
                list.add(split[0]);
                map.put(split[1], list);
            }

            int tmp = 1;
            List<String> keyList = new ArrayList<>(map.keySet());
            for (int l = 0; l < keyList.size(); l++) {
                final List<String> clothes = map.getOrDefault(keyList.get(l), new ArrayList<>());
                tmp *= (clothes.size() + 1);
            }

            System.out.println(tmp - 1);
        }
    }
}
