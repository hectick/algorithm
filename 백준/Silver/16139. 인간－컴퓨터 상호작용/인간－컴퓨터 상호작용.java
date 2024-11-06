import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final String str = br.readLine();

        int[][] map = new int[26+1][str.length()+1];
        for(int i = 1; i <= str.length(); i++) {
            final int index = str.charAt(i - 1) - 'a' + 1;
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

            result[i] = map[alphabet - 'a' + 1][end+1] - map[alphabet - 'a' + 1][start];
        }

        for(int res : result) {
            System.out.println(res);
        }
    }

}
