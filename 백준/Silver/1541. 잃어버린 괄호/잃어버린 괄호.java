import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        int sum = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final String[] split = br.readLine().split("-");
        for(int i = 0; i < split.length; i++) {
            int tmp = 0;
            final String[] split1 = split[i].split("\\+");
            for (String s : split1) {
                tmp += Integer.parseInt(s);
            }
            if(i == 0) {
                sum += tmp;
            }else {
                sum -= tmp;
            }
        }
        System.out.println(sum);
    }

}
