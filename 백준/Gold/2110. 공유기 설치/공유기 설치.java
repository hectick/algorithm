import java.io.*;
import java.util.*;

public class Main {

    static int[] house;
    static int N;
    static int C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final String[] first = br.readLine().split(" ");
        N = Integer.parseInt(first[0]); // 집 개수
        C = Integer.parseInt(first[1]); // 공유기 개수

        house = new int[N];
        for(int i = 0; i < N; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(house);

        // 양 끝에 설치
        if(C == 2) {
            System.out.println(house[N-1] - house[0]);
            return;
        }

        int right = (house[N-1] - house[0]); // 최대 폭
        int left = 1; //최소 폭
        int result = 0;
        while(left <= right) {
            int mid = (left + right) / 2;
            int value = putCount(mid);
            if(value >= C) {
                result = mid;
                left = mid + 1;
            }else { // value < C, 폭을 더 좁혀야 함
                right = mid - 1;
            }
        }

        System.out.println(result);
    }

    public static int putCount(int pok) {
        int count = 1;
        int beforeIndex = 0;
        for(int i = 1; i < N; i++) {
            if(house[i] - house[beforeIndex] >= pok) {
                beforeIndex = i;
                count++;
            }
            if(count >= N) {
                break;
            }
        }
        return count;
    }

}
