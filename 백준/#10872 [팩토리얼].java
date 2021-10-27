import java.util.*;
public class Baekjoon_10872 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int data;
        if((n>=0 && n<=12)==false) return ;
        data = fact(n);
        System.out.println(data);
    }
    public static int fact(int input)
    {
        if(input ==0) return 1;
        return input*fact(input-1);
    }
}
