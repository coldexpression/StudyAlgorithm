import java.util.*;
public class Baekjoon_9020 {
    static ArrayList<Integer> minor = new ArrayList<Integer>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i, j,k,n,mini,n1=0,n2=0;
        int t = sc.nextInt();

        for (i = 0; i < t; i++) {
            mini = 2147483647;
            minor = new ArrayList();
            n = sc.nextInt();
            if ((n % 2 != 0) || (n < 4) || (n > 10000)) return;
            minor_num(n);
         //   System.out.println(minor);
            for(j=0;j<minor.size();j++)
            {
                for(k=j;k<minor.size();k++)
                {
                    if((minor.get(j)+minor.get(k) >n)) break;
                    if((minor.get(j)+minor.get(k)) == n && (minor.get(k)-minor.get(j) < mini))
                    {
                        mini = minor.get(k)-minor.get(j);
                        n1 = minor.get(j);
                        n2 = minor.get(k);
                        if(mini == 0) break;
                    }
                }
            }
            System.out.println(n1+" "+n2);
        }
    }

    public static void minor_num(int input) {
        int i, j,cnt=0;
        boolean check;
        for (i = 2; i <= input; i++) {
            check = false;
            //  System.out.println("come in");
            for (j = 2; j <= Math.round(Math.sqrt(i)); j++) {
                if (i % j == 0) {
                    check = false;
                    break;
                } else if (i % j != 0) {
                    check = true;
                    cnt++;
                }
            }
            if(i==2) minor.add(2);
            if(check == true) {
                minor.add(i);
            }
        }
    }
}
