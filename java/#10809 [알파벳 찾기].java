import java.util.Scanner;
public class Baekjoon_10809 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int i;
        if(s.length()>100) return;

        for(i=0;i<s.length();i++)
        {
            if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') return;
        }
        find(s);
    }

    public static void find(String s)
    {
        int check,i;
        for(char c = 'a';c<='z';c++)
        {
            check = 0;
            for(i=0;i<s.length();i++)
            {
                if(s.charAt(i) == c)
                {
                    check++;
                    System.out.print(i+" ");
                    break;
                }
            }
            if(check == 0) System.out.print("-1 ");
        }
    }
}
