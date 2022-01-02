package Level1;

public class problem82612 {

    public static void main(String[] args) {

    }

    public long solution(int price, int money, int count) {
        long answer = -1;
        long temp = 0;
        for (long i=1; i<=count; i++) {
            temp += price * i;
        }

        answer = temp > money ? temp-money : 0;

        return answer;
    }
}
