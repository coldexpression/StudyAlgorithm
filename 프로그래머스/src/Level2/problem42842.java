package Level2;

public class problem42842 {

    public static void main(String[] args) {
        problem42842 problem42842 = new problem42842();
        problem42842.solution(50, 22);
    }

    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        int yellowHeight = 1;
        int brownCol = 0;
        int brownRow = 0;
        int brownBlock = 0;
        int yellowBlock = 0;
        while(true) {
            if ((yellow / yellowHeight) + 2 >= yellowHeight + 2) {
                brownCol = (yellow / yellowHeight) + 2;
                brownRow = yellowHeight + 2;
                brownBlock = 2 * brownCol + 2 * brownRow - 4;
                yellowBlock = (brownCol * brownRow) - brownBlock;
                if (brownBlock == brown && yellowBlock == yellow) break;
                yellowHeight++;
            } else break;
        }
        return new int[]{brownCol, brownRow};
    }
}
