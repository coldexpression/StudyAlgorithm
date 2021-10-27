import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] food = new int[3];
        int[] drink = new int[2];
        int[] set = new int[6];
        int i,j,mini,setnum=0;
        for(i=0;i<3;i++){
            food[i] = sc.nextInt();
            if ((food[i] < 100 && food[i] > 2000))
                return;
        }
        for(i=0;i<2;i++) {

            drink[i] = sc.nextInt();
            if ((drink[i] < 100 && drink[i] > 2000))
                return;
        }
        for(i=0;i<3;i++) {
            for (j = 0; j < 2; j++)
            {
                set[setnum] = food[i] + drink[j] -50;
                setnum++;
            }
        }
        mini = set[0];
        for(i=0;i<6;i++)
        {
            if(mini>set[i])
                mini = set[i];
        }
        System.out.println(mini);
    }
}