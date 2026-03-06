class Solution {
    int[][] newBoard;
    public int solution(int[][] board) {
        int answer = 0;
        newBoard = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 1) {
                    newBoard[i][j] = 1;
                    makeBoard(i, j);
                }
            }
        }
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (newBoard[i][j] == 0) {
                    answer++;
                }
            }
        }
        return answer;
    }
    
    public void makeBoard(int x, int y) {
        int[] dx = {-1, 1, 0, 0, -1, 1, -1, 1};
        int[] dy = {0, 0, -1, 1, -1, 1, 1, -1};
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0) continue;
            if (nx >= newBoard.length || ny >= newBoard[0].length) continue;
            newBoard[nx][ny] = 1;
        }
    }
}