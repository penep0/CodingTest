class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = -1;
        for (int mat : mats) {
            for (int i = 0; i <= park.length - mat; i++) {
                for (int j = 0; j <= park[0].length - mat; j++) {
                    if (checkMat(mat, new int[]{i, j}, park)) answer = Math.max(answer, mat);
                }
            }
            
        }
        
        return answer;
    }
    
    public boolean checkMat(int size, int[] point, String[][] park) {
        for (int i = point[0]; i < point[0] + size; i++) {
            for (int j = point[1]; j < point[1] + size; j++) {
                if (!("-1".equals(park[i][j]))) return false;
            }
        }
        return true;
    }
}