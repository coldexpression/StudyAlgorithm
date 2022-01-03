package Level1;

public class problem12948 {

    public static void main(String[] args) {

    }

    public String solution(String phone_number) {
        String answer = "";
        for(int i=0;i<phone_number.length() - 4;i++) {
            phone_number = phone_number.replace(phone_number.charAt(i), '*');
        }
        answer = phone_number;
        return answer;
    }
}
