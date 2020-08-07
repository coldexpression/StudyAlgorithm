
import java.io.*;
public class Baekjoon_11729 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());;
        if ((n >= 1 && n <= 20) == false) return;
        String s = Integer.toString((int)(Math.pow(2,n)-1));
        bw.write(s+"\n");
        hanoi(n,1,3,2);
        bw.flush();
        bw.close();
    }
    public static void hanoi(int n,int start,int last,int middle) throws IOException {
        if(n == 1)
        {
                bw.write(start+" "+last+"\n");
        }
        else
        {
            hanoi(n-1,start,middle,last);
            bw.write(start+" "+last+"\n");
            hanoi(n-1,middle,last,start);
        }

    }
}
