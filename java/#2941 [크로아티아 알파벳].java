import java.util.Scanner;
public class Baekjoon_2941 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int i,j=0,count=0;
        String s = sc.nextLine();
        String merge = "";
        if(s.length()>100 && s.length()<0) return;
        String[] st = s.split("");
        String[] croatia= new String[st.length+1];
        for(i=0;i<croatia.length;i++)
            croatia[i] = "no";
        for(i=0;i<s.length();i++)
        {
          //  if((st[i].charAt(0) >= 'a' && st[i].charAt(0) <= 'z')==false)
               // return ;
            if(i< st.length-2 &&st[i].equals("d") && st[i+1].equals("z") && st[i+2].equals("=")) {
                croatia[j] = st[i] + st[i + 1] + st[i + 2];
               // System.out.println("come in! >> "+croatia[j]);
                i = i+2;
            }
            else if(i<st.length-1) {
                if(st[i+1].equals("=") || st[i+1].equals("-")) {
                croatia[j] = st[i] + st[i + 1];
                i++;
                }
                else if(st[i].equals("l") && st[i+1].equals("j")) {
                croatia[j] = st[i] + st[i + 1];
                i++;
                }
                else if(st[i].equals("n") && st[i+1].equals("j")) {
                croatia[j] = st[i] + st[i + 1];
                i++;
                }
                else
                croatia[j] = st[i];
            }
            else {
                croatia[j] = st[i];
            //    System.out.println("come in >> "+croatia[j]);
            }
           /* else if(i>= 1 && ((st[i].equals("j")==true && (st[i-1].equals("l") && st[i-1].equals("n"))==false)) || ((st[i].equals("=")==false && st[i].equals("-")==false))) {
                System.out.println("come");
                croatia[j] = st[i];
            }*/
           /* else if(i>=1 && (st[i].equals("j")==true && (st[i-1].equals("l") && st[i-1].equals("n"))==false))
                croatia[j] = st[i];*/


           // System.out.println(croatia[j]);
            j++;
        }
        for(i=0;i<croatia.length;i++)
        {
          //  System.out.println(croatia[i]);
            if(croatia[i].equals("no"))
            {
                System.out.println(i);
                break;
            }
        }

    }
}
