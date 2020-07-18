import java.util.Scanner;

public class Baekjoon_2908 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int i,j,num1,num2;
        String s1 = sc.next();
        String s2 = sc.next();
        String[] st1 = s1.split("");
        String[] st2 = s2.split("");
        String t1 = "";
        String t2 = "";
        if(st1.length != 3 && st2.length != 3) return ;
        for(i=0;i<st1.length;i++)
        {
            if(st1[i].equals("0") || st2[i].equals("0")) return ;
        }
        //System.out.println(st1.length);
        for(i=st1.length;i>0;i--)
        {
            //System.out.println("Come");
            t1 += st1[i-1];
            t2 += st2[i-1];
        }
        num1 = Integer.parseInt(t1);
        num2 = Integer.parseInt(t2);
        if(num1>num2) System.out.println(num1);
        else if (num1<num2) System.out.println(num2);
        else return;
    }
}
