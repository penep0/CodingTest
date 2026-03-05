class Solution {
    public String solution(String[] id_pw, String[][] db) {
        String answer = "fail";
        for (String[] input : db) {
            if (id_pw[0].equals(input[0]) && id_pw[1].equals(input[1])) {
                return "login";
            } 
            
            if (id_pw[0].equals(input[0])) {
                return "wrong pw";
            } 
        }
        return answer;
    }
}