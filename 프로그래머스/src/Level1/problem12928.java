package Level1;

public class problem12928 {

    public static void main(String[] args) {

    }

    public int solution(int n) {
        int answer = 0;
        for(int i=1; i<=n;i++){
            answer = n % i == 0 ? answer + i : answer;
        }
        return answer;
    }
}
