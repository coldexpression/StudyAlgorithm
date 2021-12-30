package Level1;

public class problem77884 {

    public static void main(String[] args) {
        problem77884 problem77884 = new problem77884();
        problem77884.solution(13,17);
    }

    public int solution(int left, int right) {
        int answer = 0;
        int count;
        for(int i=left;i<=right;i++) {
            count = 0;
            for(int j=1;j<= i;j++) {
                count = i % j == 0 ? count+1 : count;
            }
            answer = count % 2 == 0 ? answer+i : answer-i;
        }
        System.out.println(answer);
        return answer;
    }
}
