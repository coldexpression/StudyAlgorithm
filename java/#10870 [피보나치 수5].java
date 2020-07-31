import java.util.*;
public class Baekjoon_10870 {
    public static void main(String[] args)
    {
        int data;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if((n>=0 && n<=20) == false) return ;
        data = fib(n);
        System.out.println(data);
    }
    public static int fib(int input)
    {
        if(input>=2)
        {
            return fib(input-1)+fib(input-2);
        }
        else if(input == 1)
        {
            return 1;
        }
        return 0;
    }
}
