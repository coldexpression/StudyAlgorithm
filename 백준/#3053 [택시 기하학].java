import java.util.*;
public class Baekjoon_3053 {
    public static void main(String[] args)
    {
        double uclid_cycle,unuclid_cycle;
        Scanner sc = new Scanner(System.in);
        double r = sc.nextDouble();
        if((r>0 && r<=10000)==false) return ;
        uclid_cycle = Math.PI*r*r;
        unuclid_cycle = ((r*r)/2)*4;
        System.out.printf("%5f\n",uclid_cycle);
        System.out.printf("%5f",unuclid_cycle);
    }
}
