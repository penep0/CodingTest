class Solution {
    public int solution(String[] spell, String[] dic) {
        int answer = 2;
        for (String d : dic) {
            boolean isDic = false;
            for (String s : spell) {
                if (d.contains(s)) isDic = true;
                else {
                    isDic = false;
                    break;
                };
            }
            if (isDic) return 1;
        }
        return answer;
    }
}