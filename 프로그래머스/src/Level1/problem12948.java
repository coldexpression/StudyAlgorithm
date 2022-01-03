package Level1;

public class problem12948 {

    public static void main(String[] args) {

    }

    public String solution(String phone_number) {
        String answer = "";
        for(int i=0;i<phone_number.length();i++) {
            answer += i >= phone_number.length() - 4 ? phone_number.charAt(i) : '*';
        }
        return answer;
    }
}
