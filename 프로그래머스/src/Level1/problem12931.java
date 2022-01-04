package Level1;

public class problem12931 {

    public static void main(String[] args) {

    }

    public int solution(int n) {
        int answer = 0;
        String[] store = String.valueOf(n).split("");
        for (String word : store) {
            answer += Integer.parseInt(word);
        }
        return answer;
    }
}
