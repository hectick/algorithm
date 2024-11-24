import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int T = Integer.parseInt(br.readLine());
        String[] result = new String[T];

        for (int i = 0; i < T; i++) {
            final String[] split = br.readLine().split(" ");
            int V = Integer.parseInt(split[0]); //정점 개수
            int E = Integer.parseInt(split[1]); //간선 개수
            int[] tag = new int[V + 1]; // 0, 1, 2
            List<List<Integer>> graph = new ArrayList<>();
            for (int t = 0; t <= V; t++) {
                graph.add(new ArrayList<>());
            }

            for (int t = 0; t < E; t++) {
                final String[] tmp = br.readLine().split(" ");
                int a = Integer.parseInt(tmp[0]);
                int b = Integer.parseInt(tmp[1]);
                graph.get(a).add(b);
                graph.get(b).add(a);
            }
            Queue<int[]> q = new LinkedList<>();
            boolean noFlag = false;

            for (int t = 1; t <= V; t++) {
                if (tag[t] != 0) {
                    continue;
                }

                q.add(new int[]{t, 1});
                tag[t] = 1;

                while (!q.isEmpty()) {
                    final int[] current = q.poll();

                    final List<Integer> related = graph.get(current[0]);
                    final int nextTag = getNextTag(current[1]);
                    for (int j = 0; j < related.size(); j++) {
                        final int nextNode = related.get(j);
                        if (tag[nextNode] != 0) {
                            if (tag[nextNode] != nextTag) {
                                noFlag = true;
                                break;
                            } else {
                                continue;
                            }
                        }
                        tag[nextNode] = nextTag;
                        q.add(new int[]{nextNode, nextTag});
                    }
                    if (noFlag) {
                        break;
                    }
                }
                if (noFlag) {
                    break;
                }
            }
            if (noFlag) {
                result[i] = "NO";
            } else {
                result[i] = "YES";
            }
        }

        for (String res : result) {
            System.out.println(res);
        }
    }

    public static int getNextTag(int current) {
        if (current == 1) {
            return 2;
        }
        return 1;
    }
}
