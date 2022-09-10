package Level2;

public class problem118667 {

    public static void main(String[] args) {
        problem118667 problem118667 = new problem118667();
        problem118667.solution(new int[]{1,2,1,2}, new int[]{1,10,1,2});
//        problem118667.solution(new int[]{3,2,7,2}, new int[]{4,6,5,1});
//        problem118667.solution(new int[]{1,1}, new int[]{1,5});
    }

    public long solution(int[] queue1, int[] queue2) {
        long answer = -2;
        long a1 = excute(queue1, queue2);
        long a2 = excute(queue2, queue1);
        System.out.println(a1);
        System.out.println(a2);

        if (a1 == -1 && a2 == -1) {
            answer = -1;
        } else if (a1 != -1 && a2 != -1){
            answer = Math.min(a1, a2);
        } else {
            answer = Math.max(a1, a2);
        }

        return answer;
    }

    public long excute(int[] num1, int[] num2) {
        int answer = 0;
        long pivot = 0;
        int front = 0;
        int rear = num1.length - 1;
        long sum = 0;
        int count = 0;
        int[] board = new int[num1.length + num2.length];
        for(int i=0;i<num1.length;i++) {
            pivot += num1[i] + num2[i];
            board[i] = num1[i];
            board[i+num1.length] = num2[i];
        }

        pivot /= 2;

        for(int i=0;i<num1.length;i++) {
            sum += num1[i];
        }
//        if (sum < pivot) {
//            rear++;
//        } else if (sum > pivot) {
//            front++;
//        }

        for (int i : board) {
            System.out.print(i+" ");
        }
        System.out.println();

        System.out.println("pivot : " + pivot);

        while(true) {
            System.out.println("front : " + front);
            System.out.println("rear : " + rear);
            System.out.println("sum : " + sum);
            if (rear == board.length- 1 || front == rear + 1) {
                answer = -1;
                break;
            } else if (sum == pivot) {
                answer = count;
                break;
            } else if (sum < pivot) {
                sum += board[++rear];
            } else {
                sum -= board[front++];
            }
            count++;
        }

        return answer;
    }
}
