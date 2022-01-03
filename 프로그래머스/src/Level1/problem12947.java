package Level1;

public class problem12947 {

    public static void main(String[] args) {

    }

    public boolean solution(int x) {
        boolean answer = true;
        int sum = 0;
        String[] s = String.valueOf(x).split("");
        for (int i=0; i<s.length; i++) {
            sum += Integer.parseInt(s[i]);
        }
        answer = x % sum == 0;
        return answer;
    }
}
