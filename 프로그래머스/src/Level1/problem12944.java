package Level1;

public class problem12944 {

    public static void main(String[] args) {

    }

    public double solution(int[] arr) {
        double answer = 0;
        for(int i=0;i<arr.length;i++) {
            answer += arr[i];
        }
        answer /= arr.length;
        return answer;
    }
}
