package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class problem11655 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();
        HashMap<Character, Integer> map = new HashMap<>();
        List<Character> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        list.add('0');
        int index = 1;
        for(char c = 'a';c<='z';c++) {
            map.put(c, index++);
            list.add(c);
        }
        for(char c = 'a';c<='z';c++) list.add(c);
        for(int i=0;i<input.length();i++) {
            char word = input.charAt(i);
            if (word >= 'a' && word <= 'z') {
                sb.append(list.get(map.get(word)+13));
            } else if (word >= 'A' && word <= 'Z'){
                System.out.println(word);
                word += 32;
                System.out.println(map);
                System.out.println(map.get(word)+13);
                System.out.println(list.get(map.get(word)+13));
                word = list.get(map.get(word)+13);
                System.out.println((char)(word-32));
                sb.append((char)(word - 32));
            } else {
                sb.append(word);
            }
        }
        System.out.println(sb);
    }
}
