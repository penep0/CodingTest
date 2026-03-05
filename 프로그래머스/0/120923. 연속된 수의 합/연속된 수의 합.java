class Solution {
    public int[] solution(int num, int total) {
        int sum=0;
        int x;
        for(int i=1;i<=num;i++){
            sum+=i;
        }
        x=(total-sum)/num;
        int[] answer = new int[num];
        for(int i=0;i<num;i++){
            answer[i]=x+(i+1);
        }
        return answer;
    }
}