package Level1;

public class problem12922 {

    public static void main(String[] args) {

    }

    public String solution(int n) {
        String answer = "";
        for (int i=1;i<=n;i++) {
            if (i % 2 == 1) {
                answer = answer.concat("수");
            }
            else {
                answer = answer.concat("박");
            }
        }
        return answer;
    }
}
