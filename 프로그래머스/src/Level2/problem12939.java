package Level2;

public class problem12939 {

    public static void main(String[] args) {

    }

    public String solution(String s) {
        String answer = "";
        int num = 0;
        int max = -1000000;
        int min = 1000000;
        for(String word: s.split(" ")) {
            num = Integer.parseInt(word);
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        answer = min + " " + max;
        return answer;
    }
}
