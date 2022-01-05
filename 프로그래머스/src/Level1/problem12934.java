package Level1;

public class problem12934 {

    public static void main(String[] args) {
        System.out.println(0.5%1);
    }

    public long solution(long n) {
        long answer = 0;
        double result = Math.sqrt(n);

        answer = result % 1 == 0 ? (long)Math.pow(result + 1, 2) : (long)-1;
        return answer;
    }
}
