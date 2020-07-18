import java.util.Scanner;
public class Baekjoon_5622 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        if(s.length()<2 && s.length()>15) return;
        int i,sum =0;
        String[] st = s.split("");
        for(i=0;i<s.length();i++) {
            if((st[i].charAt(0) >= 'A' && st[i].charAt(0) <= 'Z') == false) return;
            sum += find_dial(st[i]);
        }
        System.out.println(sum);

    }
    public static int find_dial(String input)
    {
        int num=0;
        switch(input)
        {
            case "A": num=2; break;
            case "B": num=2; break;
            case "C": num=2; break;
            case "D": num=3; break;
            case "E": num=3; break;
            case "F": num=3; break;
            case "G": num=4; break;
            case "H": num=4; break;
            case "I": num=4; break;
            case "J": num=5; break;
            case "K": num=5; break;
            case "L": num=5; break;
            case "M": num=6; break;
            case "N": num=6; break;
            case "O": num=6; break;
            case "P": num=7; break;
            case "Q": num=7; break;
            case "R": num=7; break;
            case "S": num=7; break;
            case "T": num=8; break;
            case "U": num=8; break;
            case "V": num=8; break;
            case "W": num=9; break;
            case "X": num=9; break;
            case "Y": num=9; break;
            case "Z": num=9; break;
        }
        return num+1;
    }
}
