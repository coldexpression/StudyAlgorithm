package Level1;

public class problem12982 {

    public static void main(String[] args) {
        problem12982 problem12982 = new problem12982();
        int answer = problem12982.solution(new int[]{3,2,1,8,4}, 3);
    }

    public int solution(int[] d, int budget) {
        int answer = 0;
        int min = 0;
        int min_index = 0;
        int temp = 0;



        for(int i=0; i<d.length-1;i++) {
            min = d[i];
            min_index = i;
           for(int j=i;j<d.length;j++) {
                if (min > d[j]) {
                    min = d[j];
                    min_index = j;
                }
           }
           temp = d[i];
           d[i] = d[min_index];
           d[min_index] = temp;
            for (int k : d) {
                System.out.print(k + " ");
            }
            System.out.println();
        }

        for(int i=0;i<d.length;i++) {
            if (budget >= d[i]) {
                budget = budget - d[i];
                answer++;
            }
        }

        return answer;
    }
}
