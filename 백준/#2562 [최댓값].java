import java.util.Scanner;
public class Main{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int[] n = new int[9];
        int i,max,maxindex;
        max = 0;
        maxindex = 0;
        for(i=0;i<9;i++)
        {
            n[i] = sc.nextInt();
            if(n[i] > 100) return;
            if(max<=n[i])
            {
                max = n[i];
                maxindex = i;
            }
        }
        System.out.println(max);
        System.out.println(maxindex+1);
    }
}