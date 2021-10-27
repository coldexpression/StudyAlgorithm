import java.util.*;
public class Baekjoon_1085 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int x,y,w,h,i,min;
        int[] dist = new int[4];
        x = sc.nextInt();
        y = sc.nextInt();
        w = sc.nextInt();
        h = sc.nextInt();
        if((w>=0 && w<=1000)==false || (h>=0 && h<=1000)==false) return;
        if((x>=0 && x>=1 && x<=(w-1))==false || (y>=0 && y>=1 && y<=(h-1))==false) return;
        dist[0] = x;
        dist[1] = y;
        dist[2] = w-x;
        dist[3] = h-y;
        min = 1001;
        for(i=0;i<dist.length;i++)
        {
            if(min>dist[i])
                min = dist[i];
        }
        System.out.println(min);
    }
}
