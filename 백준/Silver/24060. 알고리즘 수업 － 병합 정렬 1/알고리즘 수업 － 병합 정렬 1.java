import java.io.*;
import java.util.*;

public class Main {

    static long[] arr;
    static int N;
    static int K;
    static int count = 0;
    static long answer = -1;
    static long[] tmp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        K = Integer.parseInt(split[1]);

        arr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        tmp = new long[arr.length];
        //arr을 오름차순 정렬했을 때, K번째 저장되는 수, K는 1부터 시작

        mergeSort(0, N-1);

        System.out.println(answer);
    }

    public static void mergeSort(int start, int end) { // start, end 포함
        if(start < end) {
            int tmp = (start + end) / 2;
            mergeSort(start, tmp);
            mergeSort(tmp + 1, end);
            merge(start, tmp, end);
        }
    }

    public static void merge(int start, int mid, int end) {
        int i = start;
        int j = mid + 1;
        int t = 0;

        while (i <= mid && j <= end) {
            if(arr[i] <= arr[j]) {
                tmp[t++] = arr[i++];
            }else {
                tmp[t++] = arr[j++];
            }
        }

        while(i <= mid) {
            tmp[t++] = arr[i++];
        }

        while(j <= end) {
            tmp[t++] = arr[j++];
        }
        i = start;
        t = 0;
        while(i <= end) {
            arr[i++] = tmp[t++];
            count++;
            if(count == K) {
                answer = arr[i-1];
                System.out.println(answer);
                System.exit(0);
            }
        }
    }

}
