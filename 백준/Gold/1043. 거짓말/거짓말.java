import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static List<List<Integer>> graph;
    static List<Set<Integer>> parties;
    static Set<Integer> mustTrue;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]); // 사람 수
        M = Integer.parseInt(split[1]); //파티 수

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // 거짓말쟁이
        final int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(each -> Integer.parseInt(each)).toArray();
        int liarCount = array[0];

        // 그래프 만들기
        parties = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            int[] party = Arrays.stream(br.readLine().split(" ")).mapToInt(each -> Integer.parseInt(each)).toArray();
            int partyPeople = party[0];
            Set<Integer> ppl = new HashSet<>();
            for (int k = 1; k <= partyPeople; k++) {
                ppl.add(party[k]);
                for (int l = k + 1; l <= partyPeople; l++) {
                    graph.get(party[k]).add(party[l]);
                    graph.get(party[l]).add(party[k]);
                }
            }
            parties.add(ppl);
        }

        mustTrue = new HashSet<>();
        visited = new boolean[N + 1];
        for (int i = 1; i <= liarCount; i++) {
            dfs(array[i]);
        }

        int result = 0;
        for (Set<Integer> party : parties) {
            party.retainAll(mustTrue);
            if(party.isEmpty()) {
                result++;
            }
        }
        System.out.println(result);
    }

    public static void dfs(int start) {
        Stack<Integer> s = new Stack<>();
        s.push(start);
        mustTrue.add(start);

        while(!s.isEmpty()) {
            final Integer pop = s.pop();

            final List<Integer> relation = graph.get(pop);
            for(int i = 0; i < relation.size(); i++) {
                final Integer next = relation.get(i);
                if(mustTrue.contains(next)) continue;
                s.push(next);
                mustTrue.add(next);
            }
        }
    }
}
