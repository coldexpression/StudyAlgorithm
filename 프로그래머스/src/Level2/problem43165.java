package Level2;

public class problem43165 {

    static char[] exp = {'+','-'};
    static int count = 0;
    static int result = 0;
    static int index = 0;

    public static void main(String[] args) {
        problem43165 problem43165 = new problem43165();
        problem43165.solution(new int[]{1, 2, 3}, 3);
    }

    // 1+2+3 = 6
    // 1+2-3 = 0
    // 1-2+3 = 2
    // 1-2-3 = -4
    // -1+2+3 = 4
    // -1+2-3 = -2
    // -1-2+3 = 0
    // -1-2-3 = -6


    public int solution(int[] numbers, int target) {
        count = 0;
        result = 0;
        index = 0;
        dfs(0, numbers, target);
        return count;
    }

    static void dfs(int n, int[] numbers, int target) {
        if (index == numbers.length ) {
            System.out.println("여기서 n => " + n);
            System.out.println("결과 : " + result);
            count = result == target ? count + 1 : count;
        } else {
//            for(int i=n;i<numbers.length;i++) {
                for(char ex: exp) {
                    if (ex == '+') {
                        System.out.println("n => " + n);
                        System.out.println("ex["+ex+"] => "+"result : " + result + " numbers : " + numbers[n]);
                        result += numbers[n];
                        index++;
                        dfs(n+1,numbers,target);
                        index--;
                        result -= numbers[n];
                    } else if (ex == '-') {
                        System.out.println("n => " + n);
                        System.out.println("ex["+ex+"] => "+"result : " + result + " numbers : " + numbers[n]);
                        result -= numbers[n];
                        index++;
                        dfs(n+1, numbers, target);
                        index--;
                        result += numbers[n];
                    }
                }
//            }
        }
    }
}
