package Level1;

public class problem76501 {
    public static void main(String[] args) {
        problem76501 problem76501 = new problem76501();
    }

    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for(int i=0;i<absolutes.length;i++) {
            absolutes[i] = signs[i] ? absolutes[i] : 0-absolutes[i];
            answer += absolutes[i];
        }
        return answer;
    }
}
