import java.io.*;
import java.util.*;

public class Main {

    static Set<Integer> clockNumbers = new HashSet<>();
    static int[] numbers = new int[4];
    static int count = 0;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final String[] inputs = br.readLine().split(" ");

        int[] arr = new int[4];
        arr[0] = Integer.parseInt(inputs[0] + inputs[1] + inputs[2] + inputs[3]);
        arr[1] = Integer.parseInt(inputs[1] + inputs[2] + inputs[3] + inputs[0]);
        arr[2] = Integer.parseInt(inputs[2] + inputs[3] + inputs[0] + inputs[1]);
        arr[3] = Integer.parseInt(inputs[3] + inputs[0] + inputs[1] + inputs[2]);

        Arrays.sort(arr);
        N = arr[0]; //시계수


        // 1 ~ 9 중 중복으로 4개 뽑아서 시계수 만들기
        func(1, 0);

    }

    public static void func(int start, int index) {
        if(index == 4) {
            int[] arr = new int[4];
            arr[0] = numbers[0]*1000+numbers[1]*100+numbers[2]*10+numbers[3];
            arr[1] = numbers[1]*1000+numbers[2]*100+numbers[3]*10+numbers[0];
            arr[2] = numbers[2]*1000+numbers[3]*100+numbers[0]*10+numbers[1];
            arr[3] = numbers[3]*1000+numbers[0]*100+numbers[1]*10+numbers[2];
            Arrays.sort(arr);
            int number = arr[0]; //시계수

            if(clockNumbers.contains(number)) return;
            if(number == N) {
                System.out.println(count+1);
                System.exit(0);
            }
            clockNumbers.add(number);
            count++;
            return;
        }

        for(int i = 1; i <= 9; i++) {
            numbers[index] = i;
            func(i, index+1);
        }
    }
}
