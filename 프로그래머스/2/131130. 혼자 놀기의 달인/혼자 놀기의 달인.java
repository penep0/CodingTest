class Solution {
    public int solution(int[] cards) {
        int answer = 0;

        for (int i = 0; i < cards.length; i++) {
            int group1 = 0;
            int box = i;
            boolean[] open = new boolean[cards.length];

            while (!open[box]) {
                open[box] = true;
                int card = cards[box];
                box = card - 1;
                group1++;
            }

            int group2 = 0;

            for (int j = 0; j < cards.length; j++) {
                int box2 = j;
                int group22 = 0;
                boolean[] open2 = open.clone();

                while (!open2[box2]) {
                    open2[box2] = true;
                    int card2 = cards[box2];
                    box2 = card2 - 1;
                    group22++;
                }

                group2 = Math.max(group2, group22);
            }

            answer = Math.max(answer, group1 * group2);
        }

        return answer;
    }
}