import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,m;
        int tmp = 0;
        int cycle = 0;
        n = sc.nextInt();
        m = n;
        do {
            if (n >= 0 && n <= 99) {
                tmp = n;
                if(n<10)
                {
                    n = (n*10) + n;
                }
                else {
                    n = ((n / 10) + (n % 10));
                    n = ((tmp % 10) * 10) + (n % 10);
                }
                cycle++;
            }
        } while (n != m);
        System.out.println(cycle);
    }
}