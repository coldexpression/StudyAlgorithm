import java.util.Scanner;
public class Baekjoon_1157 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
      //  System.out.println((int)'b');
        String s = sc.nextLine();
        int i,j=0,max=0,maxindex=0,sig=0;
        int[] number = new int[26];
        for(i=0;i<number.length;i++) number[i] = 0;
        if(s.length()>1000000) return;
        for(char c = 'a';c<='z';c++)
        {
            for(i=0;i<s.length();i++)
            {
                if(s.charAt(i) == c || s.charAt(i) == (char)(c-32))
                {
                    number[j]++;
                }
            }
          //  System.out.print(number[j]+" ");
            j++;
        }
        for(i=0;i<j;i++)
        {
            if(max<number[i]) {
                max=number[i];
                sig = i;
            }
        }
        for(i=0;i<j;i++)
        {
            if(max == number[i]) maxindex++;
        }
        if(maxindex>1)
            System.out.println("?");
        else if(maxindex == 1)
            System.out.println((char)((96+sig+1)-32));
       /* else if(maxindex == 1 && s.charAt(sig) >= 'A' && s.charAt(sig) <= 'Z')
            System.out.println((char)(96+sig));*/
    }
}
