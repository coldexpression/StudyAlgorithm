package Level2;

public class problem12899 {

    public static void main(String[] args) {
        System.out.println(4 % 3);
    }


    // 1 => 1
    // 2 => 2
    // 3 => 4
    // 4 => 11
    // 5 => 12
    // 6 => 14
    // 7 => 21
    // 8 => 22
    // 9 => 24
    // 10 => 41
    // 11 => 42
    // 12 => 44
    // 13 => 111
    // 14 => 112
    // 15 => 114 16 => 121 17 => 122 18 => 124 19 => 141 20=> 142 21 => 144
    // 2자리 : 9개 3*3
    // 3자리 : 27개 3*3*3
    // 4자리 : 81개 3*3*3*3
    public String solution(int n) {
        int[] store = new int[]{1, 2, 4};
        String answer = "";
        int a = n / 3;
        int b = n  % 3;

        if (b == 0) {

        }

        return answer;
    }
}
