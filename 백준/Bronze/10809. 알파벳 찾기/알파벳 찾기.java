import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int[] alphabet = new int[26];
        for (int i = 0; i < alphabet.length; i++) {
            alphabet[i] = -1;
        }
        for (int i = 0; i < input.length(); i++) {
            if (alphabet[input.charAt(i) - 'a'] == -1) alphabet[input.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < alphabet.length; i++) {
            System.out.print(alphabet[i] + " ");
        }
    }
}