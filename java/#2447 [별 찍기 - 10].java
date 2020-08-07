import java.util.*;
public class Baekjoon_2447 {
    static char [][] star;
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i,j;
        if((n>=Math.pow(3,1) && n<Math.pow(3,8)) == false) return ;
        star = new char[n][n];
        make_star(n,0,0,false);
        StringBuilder sb = new StringBuilder();
        for(i=0;i<n;i++)
        {
            for(j=0;j<n;j++)
            {
                sb.append(star[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
    public static void make_star(int n,int x,int y,boolean check)
    {
        int i,j,k,count=0;
        if(check == true)
        {
            for(i=x;i<n+x;i++)
            {
                for(j=y;j<n+y;j++)
                {
                    star[i][j] = ' ';
                }
            }
            return ;
        }
        if(n==1)
        {
            star[x][y] = '*';
            return ;
        }
        for(i=x;i<x+n;i=i+n/3)
        {
            for(j=y;j<y+n;j=j+n/3)
            {
                count++;
                if(count == 5)
                {
                    make_star(n/3,i,j,true);
                }
                else
                {
                    make_star(n/3,i,j,false);
                }
            }
        }

    }
}
