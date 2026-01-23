import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            long a = Long.parseLong(br.readLine());
            if(a == 0) {
                if(pq.isEmpty()) {
                    System.out.println("0");
                }else {
                    System.out.println(pq.poll());
                }
            }else {
                pq.add(a);
            }
        }
        br.close();
    }
}

