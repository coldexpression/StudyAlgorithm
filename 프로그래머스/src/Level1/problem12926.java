package Level1;

public class problem12926 {

    public static void main(String[] args) {
        // 공백 : 32
        // a
        System.out.println('Z'-'A');
        System.out.println((int)('Z'));
        System.out.println((int)'A');
        System.out.println((char)('a' + 1));
        System.out.println((int)'z');
    }

    public String solution(String s, int n) {
        String answer = "";
        char[] store = s.toCharArray();
        for(char word : store) {

            if (word == ' ') {
                answer += ' ';
            } else if (word >= 'A' && word <= 'Z') {
                if (word + n > 'Z') {
                    answer += (char)('A' + (word + n) % 90 - 1);
                } else {
                    answer += (char)(word + n);
                }
            } else if (word >= 'a' && word <= 'z') {
                if (word + n > 'z') {
                    answer += (char)('a' + (word + n) % 122 - 1);
                } else {
                    answer += (char)(word + n);
                }
            }
//            if (word == ' ') {
//                answer += ' ';
//            } else if (word == 'Z') {
//                answer += (char)('A' + (n-1));
//            } else if (word == 'z') {
//                answer += (char)('a' + (n-1));
//            } else if ((char)(word + n) > 'Z' && (char)(word + n) < 'a') {
//                answer += (char)('A' + ((word + n) - 'Z' - 1));
//            } else if ((char)(word + n) > 'z'){
//                answer += (char)('a' + ((word + n) - 'z' - 1));
//            } else {
//                answer += (char)(word + n);
//            }
        }
        return answer;
    }
}
