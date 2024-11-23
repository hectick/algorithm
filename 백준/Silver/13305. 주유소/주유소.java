import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int N = Integer.parseInt(br.readLine());
        final long[] length = Arrays.stream(br.readLine().split(" "))
                .mapToLong(each -> Long.parseLong(each))
                .toArray();//도로의 길이가 N-1개
        final long[] price = Arrays.stream(br.readLine().split(" "))
                .mapToLong(each -> Long.parseLong(each))
                .toArray();//리터당 가격이 N개

        //length[i] => price[i]와 price[i+1] 사이  (i < N-1)

        long leftLength = 0;
        for (long l : length) {
            leftLength += l;
        }
        long result = price[0] * leftLength;
        long minPrice = price[0];
        leftLength -= length[0];
        for(int i = 1; i < N-1; i++) {
            if(minPrice > price[i]) {
                result -= leftLength * minPrice; //이전 가격 빼고
                result += leftLength * price[i]; // 현재 가격으로 다시 계산
                minPrice = price[i];
            }
            leftLength -= length[i];
        }

        System.out.println(result);
    }
}
