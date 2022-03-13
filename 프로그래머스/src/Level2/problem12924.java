package Level2;

public class problem12924 {

    public static void main(String[] args) {

    }

    public int solution(int n) {
        int answer = 0;
        int temp = 0;
        for(int i=1;i<=n;i++) {
            for(int j=i;j<=n;j++) {
                temp += j;
                if (temp == n) {
                    answer++;
                    break;
                } else if (temp > n) break;
            }
            temp = 0;
        }
        return answer;
    }
}
