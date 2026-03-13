class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        answer[0] = 51;
        answer[1] = 51;
        int startx = 51;
        int starty = 51;
        int endx = -1;
        int endy = -1;
        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[0].length(); j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    if (i <= answer[0]) {
                        answer[0] = i;
                    }
                    
                    if (i >= answer[2]) {
                        answer[2] = i + 1;
                    }
                    
                    if (j <= answer[1]) {
                        answer[1] = j;
                    }
                    
                    if (j >= answer[3]) {
                        answer[3] = j + 1;
                    }
                }
            }
        }
        return answer;
    }
}