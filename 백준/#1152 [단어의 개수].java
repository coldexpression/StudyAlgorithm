import java.util.Scanner;
public class Baekjoon_1152{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String st = sc.nextLine();
        int length=0;
        if(st.length() >1000000) return ;
        String[] real = st.split(" ");
        length = real.length;
        for(int i=0;i<real.length;i++)
        {
            if(real[i].equals(""))
                length--;
        }
        System.out.println(length);
    }
}