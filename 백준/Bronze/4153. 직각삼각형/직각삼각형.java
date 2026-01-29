import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        while (a != 0 || b != 0 || c != 0) {
            if (a > b && a > c ) {
                if (a * a == b * b + c * c) {
                    System.out.println("right");
                } else {
                    System.out.println("wrong");
                }
            } else if (b > a && b > c) {
                if (b * b == a * a + c * c) {
                    System.out.println("right");
                } else {
                    System.out.println("wrong");
                }
            } else if (c > a && c > b) {
                if (c * c == b * b + a * a) {
                    System.out.println("right");
                } else {
                    System.out.println("wrong");
                }
            }
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
        }
    }
}