package Level1;

public class problem12954 {

    public static void main(String[] args) {

    }

    public long[] solution(int x,int n) {
        long[] answer = new long[n];
        for (int i=1;i<=n;i++) {
            answer[i - 1] = x * i;
        }
        return answer;
    }
}
