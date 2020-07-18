import java.util.Scanner;
public class Baekjoon_1316 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if(num>100 || num<0) return ;
        int i,j,k,h,count=0,sum=0,index=0;
        String s;
        String[] st;
        sum = num;
        for(i=0;i<num;i++)
        {
            s = sc.next();
            st = s.split("");
            count = 0;
            for(j=0;j<st.length;j++)
            {
                for(h=j;h<st.length;h++)
                {
                    if(st[j].equals(st[h]) == false)
                    {
                        index = h;
                        break;
                    } else if (h == st.length-1) index = h;
                }
           //     System.out.println("index >> "+index+" j >> "+j);
                for(k=index;k<st.length;k++)
                {
                    if(index == st.length-1) break;
                    if(st[j].equals(st[k]))
                    {
                      //  System.out.println("st[j] >> "+ st[j] + " st[k] >> "+st[k]);
                        count++;
                        break;
                    }
                }
                if(count == 1) break;
            }
            sum = sum-count;
        }
        System.out.println(sum);
    }
}
