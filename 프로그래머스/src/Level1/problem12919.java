package Level1;

public class problem12919 {

    public static void main(String[] args) {

    }

    public String solution(String[] seoul) {
        String answer = "";
        for(int i=0;i<seoul.length;i++) {
            if (seoul[i].equals("Kim")) {
                answer = "김서방은 " + i + "에 있다";
                break;
            }
        }
        return answer;
    }
}
