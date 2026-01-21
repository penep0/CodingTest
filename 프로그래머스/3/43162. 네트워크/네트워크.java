class Solution {
    boolean[] check;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        check = new boolean[n];
        for (int i = 0; i < computers.length; i++) {
            if (!check[i]) {
                answer++;
                check[i] = true;
                dfs(computers, i);
            }
        }
        return answer;
    }
    
    public void dfs(int[][] computers, int pc) {
        for (int i = 0; i < computers.length; i++) {
            if (computers[pc][i] == 1 && !check[i]) {
                check[i] = true;
                dfs(computers, i);
            } 
        }
    }
}