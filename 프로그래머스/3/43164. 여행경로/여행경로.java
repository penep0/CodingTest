import java.util.*;

class Solution {
    static boolean[] check;
    static ArrayList<String> list = new ArrayList<>();
    static  String[] answer;
    public String[] solution(String[][] tickets) {
        check = new boolean[tickets.length];
        Arrays.sort(tickets, (a, b) -> {
                         if (a[0].equals(b[0])) return a[1].compareTo(b[1]);
                         return a[0].compareTo(b[0]);
        });
        
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i][0].equals("ICN")) {
                check = new boolean[tickets.length]; 
                list.clear();
                check[i] = true;
                list.add("ICN");
                list.add(tickets[i][1]);
                if(back(1, tickets)) return answer;
            }
        }
        
        return answer;
    }
    
    public boolean back(int count, String[][] tickets) {
        if (count == tickets.length) {
            answer = new String[list.size()];
        
            for (int i = 0; i < list.size(); i++) {
                answer[i] = list.get(i);
            }
            return true;
        }
        
        for (int i = 0; i < tickets.length; i++) {
            if (check[i]) continue;
            if (list.get(count).equals(tickets[i][0])) {
                check[i] = true;
                list.add(tickets[i][1]);
                if(back(count + 1, tickets)) return true;
                list.remove(list.size() - 1);
                check[i] = false;
            }
        }
        return false;
    }
}