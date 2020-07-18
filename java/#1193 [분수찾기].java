import java.util.*;
public class Baekjoon_1193 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int i,up=1,down=1,count=1,realdown=0,realup=0;
        int x = sc.nextInt();
        if(x<1 && x>10000000) return;
        if(x == count)
        {
            System.out.println(up+"/"+down);
            return ;
        }
        down += 1;
        count++;
        while(true)
        {
            if(down>up)
            {
                realdown = down;
                for(i=1;i<realdown;i++)
                {
                    if(count==x)
                    {
                        System.out.println(up+"/"+down);
                        return ;
                    }

                    up++;
                    down--;
                    count++;

                    if(count==x)
                    {
                        System.out.println(up+"/"+down);
                        return ;
                    }
                   // System.out.println("[down>up] count >> "+count+" up >> "+up+" down >> "+down);

                }
                up++;
                count++;
            } else if(up>down)
            {
                realup = up;
                for(i=1;i<realup;i++)
                {
                    if(count == x)
                    {
                        System.out.println(up+"/"+down);
                        return ;
                    }

                    up--;
                    down++;
                    count++;

                    if(count==x)
                    {
                        System.out.println(up+"/"+down);
                        return ;
                    }
                  //  System.out.println("[up>down] count >> "+count+" up >> "+up+" down >> "+down);

                }
                down++;
                count++;
            }
        }
    }
}
