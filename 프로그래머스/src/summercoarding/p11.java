package summercoarding;

public class p11 {

    public static void main(String[] args) {
        p11 p11 = new p11();
        p11.solution(1);
    }

    public int solution(int n) {
        int answer = 0;
        int box = 0;

        do {
            box = 0;
            String board = String.valueOf(n);
            String[] split = board.split("");

            for (String s : split) {
                box += Integer.parseInt(s);
            }

            n = box;
        } while (n >= 10);

        answer = n;
        return answer;
    }
}
