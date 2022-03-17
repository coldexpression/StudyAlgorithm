package Level2;

public class problem12980 {

    public static void main(String[] args) {

    }

    public int solution(int n) {
        int ans = 0;
        while(n != 0) {
            if (n%2 != 0) ans++;
            n = n / 2;
        }

        return ans;
    }
}
