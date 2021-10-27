import java.util.Scanner;
public class Baekjoon_2675 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int r,i,j,k;
        String s;
        int t = sc.nextInt();
        if(t<1 && t>1000) return;
        for(i=0;i<t;i++) {
            r = sc.nextInt();
            if (r < 1 && r > 8) return;
            s = sc.next();
            if(s.length()<1 && s.length()>20) return;
            for(j=0;j<s.length();j++)
            {
                for(k=0;k<r;k++)
                    System.out.print(s.charAt(j));
            }
            System.out.println();
        }

    }
}
