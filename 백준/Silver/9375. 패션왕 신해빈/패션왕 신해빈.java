import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            Map<String, Integer> map = new HashMap<>();
            int m = Integer.parseInt(br.readLine());
            int result = 1;
            for(int j = 0; j < m; j++){
                String key = br.readLine();
                String[] split = key.split(" ");
                String name = split[0];
                String wear = split[1];
                map.put(wear, map.getOrDefault(wear, 0) + 1);
            }
            for(Integer integer : map.values()){
                result *= integer + 1;
            }
            bw.write((result - 1) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}