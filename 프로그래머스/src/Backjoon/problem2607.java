package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problem2607 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        HashSet<Character> set = new HashSet<>();
        HashMap<Character, Integer> map = new HashMap<>();

        int n = Integer.parseInt(bf.readLine());
        int ans = 0;

        String pivotWord = bf.readLine();
        int pivotLength = pivotWord.length();

        for (int i = 0; i < pivotWord.length(); i++) {
            set.add(pivotWord.charAt(i));
            map.put(pivotWord.charAt(i), map.getOrDefault(pivotWord.charAt(i), 0) + 1);
        }

        int pivotCnt = set.size();

        for (int i = 1; i < n; i++) {
            String word = bf.readLine();
            int wordLength = word.length();
            HashSet<Character> miniSet = new HashSet<>();
            HashMap<Character, Integer> miniMap = new HashMap<>();
            int cnt = 0;

            for (int j = 0; j < word.length(); j++) {
                miniSet.add(word.charAt(j));
                miniMap.put(word.charAt(j), miniMap.getOrDefault(word.charAt(j), 0) + 1);
            }

//            for (Character c : miniSet)
//                cnt = set.contains(c) ? cnt + 1 : cnt;

            if (wordLength == pivotLength || wordLength -1 == pivotLength || wordLength + 1 == pivotLength) {
                ans = isOK(new HashMap<>(map), miniMap) ? ans + 1 : ans;
            }
            System.out.println(ans);

//            if (pivotWord.length() == word.length()) {
//                if (isSameType(set, miniSet)) {
//
//                } else {
//
//                }
//            } else if (pivotWord.length() -1 == word.length()) {
//
//            } else if (pivotWord.length() +1 == word.length()) {
//
//            }
        }

        System.out.println(ans);

    }

    public static boolean isOK(HashMap<Character, Integer> map, HashMap<Character, Integer> compMap) {
        List<Character> list = new ArrayList<>();

        System.out.println("map : " + map);
        System.out.println("compMap : " + compMap);
        for (char c : compMap.keySet()) {
            if(map.containsKey(c)) {
                map.replace(c, map.get(c) - compMap.get(c));
            } else {
                map.put(c, compMap.get(c) * -1);
            }
        }

        for (char c : map.keySet()) {
            if (map.get(c) != 0) list.add(c);
        }

        System.out.println(list);
        System.out.println(map);

        if (list.size() > 2) return false;


        if (list.isEmpty()) return true;
        if (list.size() == 1) return Math.abs(map.get(list.get(0))) == 1;

        if (list.size() == 2) return Math.abs(map.get(list.get(0)) * map.get(list.get(1))) == 1;

        return false;
    }



}
