package Backjoon;

public class problem1011 {

    static boolean[] visited;

    public static void main(String[] args) {
        problem1011 problem1011 = new problem1011();
        problem1011.solution(5, new int[]{0,4});
    }

    public double solution(int n, int[] pos) {
        double dst = pos[1] - pos[0];
        double max = (double)Math.round(Math.sqrt(dst));
        double answer = 0;
        if ((double)Math.pow(max, 2) < dst) {
            answer = max * 2;
        } else {
            answer = max * 2 - 1;
        }

        System.out.println((int)answer);
        return answer;
    }


}
