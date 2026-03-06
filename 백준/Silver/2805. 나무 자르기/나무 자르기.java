import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        long least = 0;
        long highest = 0;
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        long[] arr = new long[n];

        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(st2.nextToken());
            arr[i] = a;
            if (a > highest) {
                highest = a;
            }
        }
        highest++;
        while (least < highest) {
            long mid = (least + highest) / 2;
            long sum = getTree(arr, mid);

            if (sum < m) {
                highest = mid;
            } else {
                least = mid + 1;
            }
        }
        System.out.println(least - 1);

        br.close();
    }

    public static long getTree(long[] arr, long h) {
        long sum = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > h) {
                sum += arr[i] - h;
            }
        }

        return sum;
    }
}

