import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final String input = br.readLine();
        final String boom = br.readLine();
        final int boomLength = boom.length();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            sb.append(input.charAt(i));

            final int sbLength = sb.length();
            if (sbLength >= boomLength) {
                if (sb.substring(sbLength - boomLength, sbLength).equals(boom)) {
                    sb.delete(sbLength - boomLength, sbLength);
                }
            }
        }

        if(sb.length() == 0) {
            System.out.println("FRULA");
        }else {
            System.out.println(sb);   
        }
    }
}
