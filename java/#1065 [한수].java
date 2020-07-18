
public class Baekjoon_4673 {
    public static void main(String[] args)
    {
        int i;
        int[] maker = new int[10001];
        for(i=0;i<=10000;i++)
        {
            maker[i] = dn(i);
        }
        find_selfnum(maker);
    }
    public static int dn(int n)
    {
        int i,realnum=0,sum=0;
        String st = Integer.toString(n);
        String[] stnum = st.split("");
        sum = n;
        for(i=0;i<stnum.length;i++)
        {
            realnum = Integer.parseInt(stnum[i]);
            sum += realnum;
        }
        return sum;
    }
    public static void find_selfnum(int[] maker)
    {
        int i,j,k=0;
        int[] selfnum= new int[maker.length];
        for(i=0;i<selfnum.length;i++)
            selfnum[i] = -1;
        for(i=0;i<selfnum.length;i++)
            for(j=0;j<selfnum.length;j++)
            {
                if(i == maker[j]) break;
                else if(j == selfnum.length-1){
                    selfnum[k] = i;
                    k++;
                }
            }
        for(i=0;i<selfnum.length;i++)
        {
            if(selfnum[i] == -1)
                break;
            System.out.println(selfnum[i]);
        }
    }
}
