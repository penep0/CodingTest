import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < n; i++) {
            String line = sc.nextLine();
            Stack<Character> stack = new Stack<>();
            boolean flag = true;
            for(int j = 0; j < line.length(); j++) {
                if(line.charAt(j) == '(') {
                    stack.push(line.charAt(j));
                } else if(!stack.isEmpty() && line.charAt(j) == ')') {
                    stack.pop();
                } else {
                    flag = false;
                    break;
                }
            }
            if(!stack.isEmpty()) flag = false;
            System.out.println(flag ? "YES" : "NO");
        }
    }
}