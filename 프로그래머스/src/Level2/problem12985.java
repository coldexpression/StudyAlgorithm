package Level2;

public class problem12985 {

    public static void main(String[] args) {

    }

    public int solution(int n, int a, int b)
    {
        int answer = 1;
        double first = Math.min((double)a,(double)b);
        double second = Math.max((double)a,(double)b);


        while(Math.round(first / 2) != second / 2) {
            first = Math.round((first / 2));
            second = Math.round((second / 2));
            answer++;
        }

        return answer;
    }

}
