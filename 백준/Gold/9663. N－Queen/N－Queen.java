import java.io.*;

public class Main {

    static int result = 0;
    static int n;
    static int[][] index;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        index = new int[n][2];

        func(0);
        System.out.println(result);
    }

    public static void func(int todo) { //(todo, i)
        if (todo == n) {
            result++;
            return;
        }

        for (int i = 0; i < n; i++) {
            boolean next = false;
            for (int k = 0; k < todo; k++) {
                if (index[k][1] == i || Math.abs(index[k][0] - todo) == Math.abs(index[k][1] - i)) {
                    next = true;
                    break;
                }
            }
            if (next) {
                continue;
            }
            index[todo][0] = todo;
            index[todo][1] = i;
            func(todo + 1);
        }
    }
}
