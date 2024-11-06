import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final String str = br.readLine();

        Map<Character, Integer> charToIndex = new HashMap();
        charToIndex.put('a', 1);
        charToIndex.put('b', 2);
        charToIndex.put('c', 3);
        charToIndex.put('d', 4);
        charToIndex.put('e', 5);
        charToIndex.put('f', 6);
        charToIndex.put('g', 7);
        charToIndex.put('h', 8);
        charToIndex.put('i', 9);
        charToIndex.put('j', 10);
        charToIndex.put('k', 11);
        charToIndex.put('l', 12);
        charToIndex.put('m', 13);
        charToIndex.put('n', 14);
        charToIndex.put('o', 15);
        charToIndex.put('p', 16);
        charToIndex.put('q', 17);
        charToIndex.put('r', 18);
        charToIndex.put('s', 19);
        charToIndex.put('t', 20);
        charToIndex.put('u', 21);
        charToIndex.put('v', 22);
        charToIndex.put('w', 23);
        charToIndex.put('x', 24);
        charToIndex.put('y', 25);
        charToIndex.put('z', 26);

        int[][] map = new int[26+1][str.length()+1];
        for(int i = 1; i <= str.length(); i++) {
            int index = charToIndex.get(str.charAt(i - 1));
            map[index][i] = map[index][i-1] + 1;
            for(int k = 1; k <= 26; k++) {
                if(k != index) map[k][i] = map[k][i-1];
            }
        }

        final int Q = Integer.parseInt(br.readLine());
        int[] result = new int[Q];

        for(int i = 0; i < Q; i++) {
            final String[] line = br.readLine().split(" ");
            char alphabet = line[0].charAt(0);
            final int start = Integer.parseInt(line[1]);
            final int end = Integer.parseInt(line[2]);
            int index = charToIndex.get(alphabet);
            result[i] = map[index][end+1] - map[index][start];
        }

        StringBuilder sb = new StringBuilder();
        for(int res : result) {
            sb.append(res).append("\n");
        }
        System.out.println(sb);
    }

}
