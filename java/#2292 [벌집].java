import java.util.*;
public class Baekjoon_2292 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 2, i = 6, def_num = 1;
        int num_first = 2, num_last = 7;
        int n = sc.nextInt();
        if (n < 1 && n > 1000000000) return;
        if (n == def_num) {
            System.out.println(def_num);
            return ;
        }
        while (true){
            if(n>= num_first && n<= num_last)
                break;
            else
            {
                i += 6;
                num_first = num_last + 1;
                num_last = num_last + i;
                count++;
            }
        }
        System.out.println(count);
    }
}
