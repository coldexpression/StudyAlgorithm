package Level1;

public class problem12903 {

    public static void main(String[] args) {

    }

    public String solution(String s) {
        String answer = "";
        String[] split = s.split("");
        int length = split.length;
        answer = length % 2 == 0 ? split[(length-1)/2] + split[(length-1)/2 + 1] : split[length/2];
        return answer;
    }
}
