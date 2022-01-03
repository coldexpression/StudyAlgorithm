package Level1;

public class problem12930 {

    public static void main(String[] args) {
        System.out.println('A'-'a');
    }

    public String solution(String s) {
        String answer = "";
        int count = 1;
        String[] wordStore = s.split(" ", -1);
        boolean check;
        for(String word : wordStore) {
            check = true;
            String[] array = word.split("");
            for (int i=0;i<array.length;i++) {
                answer += check ? array[i].toUpperCase() : array[i].toLowerCase();
                check = !check;
            }
            if (count != wordStore.length) {
                answer += " ";
                count++;
            }
        }



        return answer;
    }
}
