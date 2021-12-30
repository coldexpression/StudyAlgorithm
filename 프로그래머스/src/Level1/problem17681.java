package Level1;

public class problem17681 {

    public static void main(String[] args) {
        problem17681 problem17681 = new problem17681();
        problem17681.solution(6, new int[]{46, 33, 33 ,22, 31, 50}, new int[]{27 ,56, 19, 14, 14, 10});
    }

    // 011111
    //
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int i=0;i<answer.length;i++) {
            answer[i] = "";
        }
        int[] store = new int[n];
        int temp = 0;
        int div = 0;
        int mod = 0;
        for (int i=0;i<n;i++) {
            temp = arr1[i] | arr2[i];
            System.out.println("temp : " + temp);
            while(temp != 0 || answer[i].length() != n) {
                div = temp / 2;
                mod = temp % 2;
                System.out.println("div : " + div);
                System.out.println("mod : " + mod);

                if (mod == 1) {
                    answer[i] = "#" + answer[i];
                } else if(mod == 0) {
                    answer[i] = " " + answer[i];
                }
                System.out.println(answer[i]);
                temp = div;

            }
        }

        for (String s: answer) {
            System.out.println(s);
        }

        return answer;
    }
}
