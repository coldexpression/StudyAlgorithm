package Level3;

import java.util.*;

public class problem43164 {

    static HashMap<Integer, List<String>> resultMap;
    static Stack<String> board;
    static int index;
    static boolean check;

    public static void main(String[] args) {
        problem43164 problem43164 = new problem43164();
//        problem43164.solution(new String[][]{{"ICN","JFK"},{"HND","IAD"},{"JFK","HND"}});
//        problem43164.solution(new String[][]{{"ICN","SFO"},{"ICN","ATL"},{"SFO","ATL"},{"ATL","ICN"},{"ATL","SFO"}});
//        problem43164.solution(new String[][]{{"ICN", "B"},{"B","ICN"},{"ICN","A"},{"A","D"},{"D","A"}});
//        problem43164.solution(new String[][]{{"ICN", "AAA"},{"ICN","AAA"},{"ICN","AAA"},{"AAA","ICN"},{"AAA","ICN"}});
//        problem43164.solution(new String[][]{{"ICN", "COO"},{"ICN","BOO"},{"COO","ICN"},{"BOO","DOO"}});
        problem43164.solution(new String[][]{{"ICN", "BOO"},{"ICN","COO"},{"COO","DOO"},{"DOO","COO"},{"BOO","DOO"},{"DOO","BOO"},{"BOO","ICN"},{"COO","BOO"}});
    }

    public String[] solution(String[][] tickets) {
        String[] answer = {};
        HashMap<String, List<String>> ticketMap = new HashMap<>();
        resultMap = new HashMap<>();
        board = new Stack<>();
        board.add("ICN");
        index = 0;
        check = false;
        for(String[] ticket: tickets) {
            List<String> list = new ArrayList<>();
            ticketMap.put(ticket[0], list);
        }

        for(String[] ticket: tickets) {
            List<String> list = ticketMap.get(ticket[0]);
            list.add(ticket[1]);
            ticketMap.put(ticket[0], list);
        }
        System.out.println(ticketMap);
        dfs(ticketMap, "ICN", 0, tickets.length);
        System.out.println(resultMap);
        answer = resultMap.get(0).toArray(new String[resultMap.get(0).size()]);
        return answer;
    }

    private void dfs(HashMap<String, List<String>> ticketMap, String start, int count, int end) {
        if (check) return;
        if (count == end) {
            List<String> temp = new ArrayList<>(board);
            resultMap.put(index++, temp);
            check = true;
            return;
        }
        if (ticketMap.get(start) != null) {
            Collections.sort(ticketMap.get(start));
            for (int i = 0; i < ticketMap.get(start).size(); i++) {
                String next = ticketMap.get(start).get(i);
                ticketMap.get(start).remove(next);
                board.add(next);
                System.out.println(board);
                dfs(ticketMap, next, count + 1, end);
                board.pop();
                ticketMap.get(start).add(i, next);
            }
        }
    }
}
