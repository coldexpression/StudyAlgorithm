package Level1;

public class problem70128 {

    public static void main(String[] args) {

    }

    public int solution(int[] a, int[] b) {
        int answer=0;
        for (int i=0;i<a.length;i++) {
            answer += a[i] * b[i];
        }
        return answer;
    }
}
