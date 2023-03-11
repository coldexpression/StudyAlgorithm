package Backjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class problem1205 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();
        String[] word = input.split(" ");
        HashMap<Integer, Integer> indexOfRankMap = new HashMap<>();
        HashMap<Integer, Integer> rankOfFirstIndex = new HashMap<>();
        HashMap<Integer, Integer> numOfMap = new HashMap<>();
        HashMap<Integer, Integer> numOfFirstIndex = new HashMap<>();
        int rn = 0;
        int cn = Integer.MAX_VALUE;
        int ans = 0;

        int n = Integer.parseInt(word[0]);
        int nScore = Integer.parseInt(word[1]);
        int p = Integer.parseInt(word[2]);

        int[] rank = new int[n];

        if (n == 0) {
            ans = 1;
        } else {
            input = bf.readLine();
            word = input.split(" ");
            for (int i = 0; i < n; i++) {
                rank[i] = Integer.parseInt(word[i]);
                numOfMap.put(rank[i], numOfMap.getOrDefault(rank[i], 0) + 1);
                if (!numOfFirstIndex.containsKey(rank[i])) numOfFirstIndex.put(rank[i], i);

            }

            for (int i = 0; i < n; i++) {
                if (rank[i] < cn) {
                    cn = rank[i];
                    rn = i + 1;
                    rankOfFirstIndex.put(rn, i);
                }
                indexOfRankMap.put(i, rn);
            }

            int left = 0;
            int right = n - 1;
            int middle = 0;

            if (rank[right] > nScore) {
                int rightRank = indexOfRankMap.get(right);
                int rightCnt = numOfMap.get(rank[right]);
                ans = right + 1 < p ? rightRank + rightCnt : -1;
            } else if (rank[left] < nScore){
                ans = 1;
            } else {
                while (left < right) {
                    middle = (left + right) / 2;

                    if (rank[middle] > nScore) {
                        left = middle + 1;
                    } else if (rank[middle] < nScore) {
                        right = middle - 1;
                    } else {
                        break;
                    }
                }

                int compScore = rank[middle];
                int compRank = indexOfRankMap.getOrDefault(middle, -1);
                int compIndex = rankOfFirstIndex.get(compRank);
                int cnt = numOfMap.get(compScore);

                System.out.println(numOfFirstIndex);
                System.out.println(indexOfRankMap);
                System.out.println(numOfMap);
                System.out.println(rankOfFirstIndex);
                System.out.println("middle : " + middle);
                System.out.println("비교 대상 정보 : [점수: " + compScore + ", 랭크: " + compRank + ", 인덱스: " + compIndex + "]");
                System.out.println("p >> : " + p);
                System.out.println("cnt >> " + cnt);

                if (compIndex > p) ans = -1;
                else {
                    if (compScore < nScore) {
                        if (numOfMap.containsKey(nScore)) {
                            int newIdx = numOfFirstIndex.get(nScore);
                            ans = indexOfRankMap.get(newIdx);
                        } else {
                            ans = compRank;
                        }
//                        ans = numOfMap.containsKey(nScore) ? indexOfRankMap.get(rankOfFirstIndex.get(compRank)) : compRank;
                    } else if (compScore == nScore) {
                        ans = compIndex + cnt < p ? compRank : -1;
                    } else {
                        if (numOfMap.containsKey(nScore)) {
                            int newRank = compRank + cnt;
                            int newIndex = rankOfFirstIndex.get(newRank);
                            int newCnt = numOfMap.get(nScore);
                            ans = newIndex + newCnt < p ? newRank : -1;
                        } else {
                            ans = compIndex + cnt < p ? compRank + cnt : -1;
                        }
                    }
                }

//            if (nScore > compScore) {
//                if (compIndex < p)
//                    ans = indexOfRankMap.get(compIndex);
//                else
//                    ans = -1;
//            } else if (nScore < compScore) {
//                int nextIdx = compIndex + cnt;
//
//                if (nextIdx < p) {
//                    if (rank[nextIdx] < nScore) {
//                        ans = indexOfRankMap.get(nextIdx);
//                    } else if (rank[nextIdx] == nScore) {
//                        ans = nextIdx + 1 < p ? indexOfRankMap.get(nextIdx) : -1;
//                    } else ans = -1;
//                } else
//                    ans = -1;
//            } else {
//                int nextIdx = compIndex + cnt;
//                if (nextIdx < p)
//                    ans = indexOfRankMap.get(compIndex);
//                else
//                    ans = -1;
//            }

            }
        }
        System.out.println(ans);

    }
}
