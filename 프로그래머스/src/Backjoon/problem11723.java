package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class problem11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        HashSet<Integer> s = new HashSet<>();
        int m = Integer.parseInt(bf.readLine());
        for(int i=0;i<m;i++) {
            String input = bf.readLine();
            String[] commands = input.split(" ");
            String command = commands[0];
            if (command.equals("empty")) s.clear();
             else if (command.equals("all")) for(int j=1;j<=20;j++) s.add(j);
             else {
                 int number = Integer.parseInt(commands[1]);
                switch (command) {
                    case "add":
                        s.add(number);
                        break;
                    case "remove":
                        s.remove(number);
                        break;
                    case "check":
                        sb.append(s.contains(number) ? 1 : 0).append("\n");
                        break;
                    case "toggle":
                        if (s.contains(number)) s.remove(number);
                        else s.add(number);
                        break;
                }
            }
        }
        System.out.print(sb);
    }
}
