package Level1;

public class problem12912 {

    public static void main(String[] args) {

    }

    public long solution(int a, int b) {
        long answer = 0;
        int tmp = 0;
        if (a == b) {
            answer = a;
            return answer;
        } else if (a < b) {
            tmp = a;
            a = b;
            b = tmp;
        }

        for (int i=b;i <= a;i++) {
            answer += (long)i;
        }


        return answer;
    }
}
