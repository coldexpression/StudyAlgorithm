import java.util.Scanner;
public class Baekjoon_1065 {
    public static void main(String[] args)
    {
        int count=0;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n>1000 && n<0) return;
        count = find(n);
        System.out.println(count);

    }
    public static int find(int n)
    {
        int i,j,k,count=0,check=0;
        String st;
        String[] num;
        for(i=1;i<=n;i++)
        {
            if(i<=99) count++;
            else if(i>=100 && i<=n) {
                st = Integer.toString(i);
                num = st.split("");
                if (num[1].equals("0") == false) {
                    for(k=-(Integer.parseInt(num[0])-1);k<=10-(Integer.parseInt(num[0]));k++) {
                        for (j = 0; j < num.length-1; j++) {
                            if(Integer.parseInt(num[j+1])-Integer.parseInt(num[j]) == k)
                            {
                              //  System.out.println("Check!");
                                check++;
                            }
                            else check=0;
                        }
                        if(check == num.length-1)
                        {
                          //  System.out.println("Come in!");
                            check=0;
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
}
