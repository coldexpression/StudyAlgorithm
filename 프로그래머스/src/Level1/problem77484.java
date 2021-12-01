package Level1;

public class problem77484 {
    public static void main(String[] args) {

        problem77484 problem77484 = new problem77484();

        int [] lottos = {44, 1, 0, 0, 31, 25};
        int [] win_nums = {31,10,45,1,6,19};
        int[] result = problem77484.solution(lottos, win_nums);
    }

    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int count = 0;
        int zero_count = 0;
        int worst = 0;
        int best = 0;
        for (int number : lottos) {
            if (number != 0) {
                for (int lotto_num : win_nums) {
                    if (number == lotto_num) {
                        count++;
                    }
                }
            } else if (number == 0) {
                zero_count++;
            }
        }
        best = count == 0 && zero_count == 0 ? 6 : 7 - (count + zero_count);
        worst = count <= 1 ?  6 : 7-count;
        answer[0] = best;
        answer[1] = worst;
        return answer;
    }
}
