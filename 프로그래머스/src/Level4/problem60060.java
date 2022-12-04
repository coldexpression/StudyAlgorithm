package Level4;

public class problem60060 {

    public static void main(String[] args) {
        problem60060 problem60060 = new problem60060();
        problem60060.solution(new String[]{"frodo","front","frost","frozen","frame","kakao"}, new String[]{"fro??","????o","fr???","fro???","pro?"});
    }

    public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];
        int idx = 0;

        for (String query : queries) {
            int firstIdx = -1;

            firstIdx = query.charAt(0) != '?' ? 0 : -1;

            String keyword = query.replaceAll("\\?","");

            firstIdx = firstIdx == -1 ? query.length() - keyword.length() : firstIdx;

            System.out.println("[KEYWORD] => " + keyword);

            for (String word : words) {
                int check = firstIdx == 0 ? word.indexOf(keyword) : word.lastIndexOf(keyword);
                int length = word.length();

                System.out.println("[firstIdx , check] => ["+firstIdx+", "+check+"]");
                if (firstIdx == check && query.length() == length) answer[idx]++;

            }

            idx++;
        }
        return answer;
    }
}
