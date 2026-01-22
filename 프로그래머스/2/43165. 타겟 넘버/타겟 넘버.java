class Solution {
    int answer = 0;
    
    public int solution(int[] numbers, int target) {
        dfs(0, numbers, target, 0);
        return answer;
    }
    
    public void dfs(int num, int[] numbers, int target, int sum) {
        if (num == numbers.length) {
            if (sum == target) answer++;
            return;
        }
        dfs(num + 1, numbers, target, sum + numbers[num]);
        dfs(num + 1, numbers, target, sum - numbers[num]);
    }
}