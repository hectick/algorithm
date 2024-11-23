import java.io.*;
import java.util.*;

public class Main {

    static Map<Integer, Integer> monthDay = new HashMap<>();

    public static void main(String[] args) throws IOException {
        monthDay.put(1, 31);
        monthDay.put(2, 28);
        monthDay.put(3, 31);
        monthDay.put(4, 30);
        monthDay.put(5, 31);
        monthDay.put(6, 30);
        monthDay.put(7, 31);
        monthDay.put(8, 31);
        monthDay.put(9, 30);
        monthDay.put(10, 31);
        monthDay.put(11, 30);
        monthDay.put(12, 31);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int N = Integer.parseInt(br.readLine());
        int[][] range = new int[N][2]; //인덱스 0은 포함, 1은 미포함
        for(int i = 0; i < N; i++) {
            final int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(each -> Integer.parseInt(each))
                    .toArray();
            range[i][0] = toNumber(array[0], array[1]);
            range[i][1] = toNumber(array[2], array[3]);
        }

        //range 정렬
        Arrays.sort(range, (o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1]: o1[0] - o2[0]);
        if(range[0][0] > toNumber(3, 1)) {
            System.out.println(0);
            return;
        }
        int index = 0;
        int start = toNumber(3, 1);
        while(range[index][1] < start) {
            index++;
        }
        int end = range[index][1];
        int result = 1;

        for(int i = index; i < N; i++) {
            if(end >= toNumber(12, 1)) {
                break;
            }
            if (range[i][0] <= start && end < range[i][1]) {
                end = range[i][1];
                continue;
            }
            if (range[i][0] <= end && end < range[i][1]){ // 새로운 꽃!
                start = end;
                end = range[i][1];
                result ++;
                continue;
            }
            if(end < range[i][0]) {
                result = 0;
                break;
            }
        }
        if(end >= toNumber(12, 1)) {
            System.out.println(result);
            return;
        }
        System.out.println(0);
    }
    private static int toNumber(final int month, final int day) {
        int number = 0;
        for(int m = 1; m <= 12; m++) {
            if(m == month) {
                number += day;
                break;
            }
            number += monthDay.get(m);
        }

        return number;
    }
}
