import java.util.Scanner;
public class Main{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int i,j,sum,count;
        int n = sc.nextInt();
        for(i=0;i<n;i++){
            String word = sc.next();
            String[] senten = word.split("");
            sum = 0;
            count = 0;
            if(senten.length <0 && senten.length>80) return;
            for(j=0;j<senten.length;j++)
            {
                if(senten[j].equals("O")) {
                    count++;
                    sum = sum+count;
                }
                else if(senten[j].equals("X")) {
               //     sum = sum+count;
                    count = 0;
                }
 
            }
            System.out.println(sum);
        }
    }
}