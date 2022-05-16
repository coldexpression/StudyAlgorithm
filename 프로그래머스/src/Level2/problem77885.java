package Level2;

public class problem77885 {

    public static void main(String[] args) {
        problem77885 problem77885 = new problem77885();
        problem77885.solution(new long[]{121});
    }

    public long[] solution(long[] numbers) {
        long[] answer = numbers.clone();
        for(int i=0;i<answer.length;i++) {
            if (numbers[i] % 2 == 0) {
                answer[i] = numbers[i] + 1;
            }
            else {
                answer[i]++;
                answer[i] += (answer[i]^numbers[i]) >> 2;
            }
        }
        return answer;
    }


}
