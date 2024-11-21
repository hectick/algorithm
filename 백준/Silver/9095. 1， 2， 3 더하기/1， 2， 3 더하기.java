import java.io.*;

public class Main {
    
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            final int N = Integer.parseInt(br.readLine());
            count = 0;
            countWay(N, 0);
            System.out.println(count);
        }

    }
    
    public static void countWay(int N, int sum) {
        if(sum == N) {
            count++;
            return;
        }
        if(sum > N) {
            return;
        }
        
        for(int i = 1; i <= 3; i++) {
            countWay(N, sum + i);
        }
    }

}
