import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1316 그룹 단어 체커
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = 0;
        int N = Integer.parseInt(st.nextToken());
        for(int i = 0; i < N; i++) {
            String word = br.readLine();
            boolean[] visited = new boolean[26];
            char prev = ' ';
            boolean isGroupWord = true;
            for(int j = 0; j < word.length(); j++) {
                char current = word.charAt(j);
                if(current != prev) {
                    if(visited[current - 'a']) {
                        isGroupWord = false;
                        break;
                    }
                    visited[current - 'a'] = true;
                    prev = current;
                }
            }
            if(isGroupWord) count++;
        }

        System.out.println(count);
    }
}
