import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int count = 0;
        String ioString = br.readLine();
        StringBuilder sb = new StringBuilder();
        boolean ioTurn = true;

        for (int i = 0; i < N + N + 1; i++) {
            if (ioTurn) {
                sb.append("I");
            } else {
                sb.append("O");
            }
            ioTurn = !ioTurn;
        }

        String s = sb.toString();

        for (int i = 0; i < M - N - N; i++) {
            String sub = ioString.substring(i, i + N + N + 1);
            if (sub.equals(s)) {
                count++;
            }
        }

        System.out.println(count);
    }
}