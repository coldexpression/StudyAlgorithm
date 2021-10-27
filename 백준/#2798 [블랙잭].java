import java.util.*;
import java.io.*;
public class Baekjoon_2798 {
    //static int[] card;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
         int i,maxindex;
         int[] card; int output=0; String data; String[] st_input;
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        if((n>=3 && n<=100) ==false || (m>=10 && m<=300000) == false) return ;
        card = new int[n];
        st = new StringTokenizer(br.readLine());
        for(i=0;i<n;i++)
        {
            card[i] = Integer.parseInt(st.nextToken());
        }
        data = Max(card,m);
        st_input = data.split(" ");
        for(i=0;i< st_input.length;i++)
        {
            output += Integer.parseInt(st_input[i]);
        }
        bw.write(output+"\n");
        bw.flush();
        bw.close();
    }
    public static String Max(int[] card,int m)
    {
        int i,j,k,data,max,gap=300000;
        String token="";
        String last = "not found";
        for(i=0;i<card.length;i++)
        {
            for(j=i+1;j<card.length;j++)
            {
                data = card[i]+card[j];
                if(data < m) {
                    for (k = j + 1; k < card.length; k++) {
                        max = data+card[k];
                        if(max == m)
                        {
                            token = Integer.toString(card[i]) +  " " + Integer.toString(card[j]) + " " + Integer.toString(card[k]);
                           // System.out.println(token);
                            return token;
                        }
                        else if((max < m) && (m-max<gap))
                        {
                            gap = m-max;
                            token = Integer.toString(card[i]) +  " " + Integer.toString(card[j]) + " " + Integer.toString(card[k]);
                            //System.out.println(token);
                        }
                    }
                }
            }
        }
        //System.out.println(token);
        return token;
    }

}
