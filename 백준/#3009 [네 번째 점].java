import java.util.*;
public class Baekjoon_3009 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int[] x = new int[3];
        int[] y = new int[3];
        int i,cntx=0,cnty=0,x_index,y_index,x1=0,y1=0;
        for(i=0;i<3;i++)
        {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
            if((x[i]>=1 && x[i]<=1000)==false || (y[i]>=1 && y[i]<=1000)==false) return;
        }
        for(i=1;i<3;i++)
        {
            if(x[0] == x[i]) cntx++;
            else x1 = i;
            if(y[0] == y[i]) cnty++;
            else y1 = i;
        }
        x_index = x[x1];
        y_index = y[y1];
        if(cntx == 0) x_index = x[0];
        if(cnty == 0) y_index = y[0];
        System.out.println(x_index+" "+y_index);
    }
}
