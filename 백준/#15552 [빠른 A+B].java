import java.util.StringTokenizer;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = bf.readLine();
        StringTokenizer st = new StringTokenizer(s);
        int t = Integer.parseInt(st.nextToken());
        int[] a;
        int[] b;
        if(t<=1000000)
        {
            a = new int[t];
            b = new int[t];
            for(int i=0;i<t;i++)
            {
                StringTokenizer sv = new StringTokenizer(bf.readLine());
                a[i] = Integer.parseInt(sv.nextToken());
                b[i] = Integer.parseInt(sv.nextToken());
            }
            bf.close();
            for(int j=0;j<t;j++)
            {
                bw.write(a[j]+b[j]+"\n");
            }
        }
        bw.flush();
        bw.close();
    }
}