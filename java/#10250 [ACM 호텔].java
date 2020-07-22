import java.util.*;
public class Baekjoon_10250 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int i, j, k, cnt;
        for (i = 0; i < t; i++) {
            int h = sc.nextInt();
            int w = sc.nextInt();
            int n = sc.nextInt();
            cnt=1;
            if (h >= 1 && h <= 99 && w >= 1 && w <= 99 && n >= 1 && n <= h * w) {
                if (n <= h)
                    System.out.println(n + "01");
                else if (n > h) {
                    while (h < n) {
                        if(cnt>w) return;
                      //  System.out.println("[계산전]n >> "+n);
                        n = n - h;
                        cnt++;
                      //  System.out.println("[계산후]n >> "+n);
                    }
                    if(cnt<10)
                    System.out.println(n + "0" + cnt);
                    else if(cnt>=10)
                        System.out.println(n+""+cnt);
                }
            } else return;

        }
    }
}
