package Level1;

public class problem12943 {

    public static void main(String[] args) {

    }

    public int solution(long num) {
        int answer = 0;
        int tmp = 0;
        while(num != 1) {
            if (answer >= 500) return -1;
            num = num % 2 == 0 ? num / 2 : (num*3)+1;
            answer++;
        }
        return answer;
    }
}
