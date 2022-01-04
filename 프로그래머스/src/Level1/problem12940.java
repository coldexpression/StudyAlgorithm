package Level1;

public class problem12940 {

    public static void main(String[] args) {

    }

    public int[] solution(int n,int m) {
        int[] answer = new int[2];
        answer[0] = gcd(n,m);
        answer[1] = (n*m)/ answer[0];
        return answer;
    }

    static int gcd(int a, int b) {
        while(b != 0) {
            int r = a%b;
            a = b;
            b = r;
        }
        return b;
    }
}
