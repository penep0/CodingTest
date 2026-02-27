class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        if (s.length() != 4 && s.length() != 6) return false;
        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - '0';
            System.out.println(num);
            if (num < 0 || num > 9) {
                answer = false;
                break;
            }
        }
        return answer;
    }
}