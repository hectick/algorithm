import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int result = 0;
        for (int i = 0; i < 3; i++) {
            final String input = br.readLine();
            final boolean isNumber = input.chars().allMatch(each -> Character.isDigit(each));
            if (isNumber) {
                result = Integer.parseInt(input) + (3 - i);
            }
        }

        if (result % 3 == 0 && result % 5 == 0) {
            System.out.println("FizzBuzz");
        } else if (result % 3 == 0) {
            System.out.println("Fizz");
        } else if (result % 5 == 0) {
            System.out.println("Buzz");
        } else {
            System.out.println(result);
        }
    }
}
