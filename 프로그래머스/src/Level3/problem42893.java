package Level3;

import java.util.*;

public class problem42893 {

    public static void main(String[] args) {
        problem42893 problem42893 = new problem42893();
        problem42893.solution("Muzi", new String[]{"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://careers.kakao.com/interview/list\"/>\n</head>  \n<body>\n<a href=\"https://programmers.co.kr/learn/courses/4673\"></a>#!MuziMuzi!)jayg07con&&\n\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://www.kakaocorp.com\"/>\n</head>  \n<body>\ncon%\tmuzI92apeach&2<a href=\"https://hashcode.co.kr/tos\"></a>\n\n\t^\n</body>\n</html>"});
//        problem42893.solution("blind", new String[]{"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://a.com\"/>\n</head>  \n<body>\nBlind Lorem Blind ipsum dolor Blind test sit amet, consectetur adipiscing elit. \n<a href=\"https://b.com\"> Link to b </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://b.com\"/>\n</head>  \n<body>\nSuspendisse potenti. Vivamus venenatis tellus non turpis bibendum, \n<a href=\"https://a.com\"> Link to a </a>\nblind sed congue urna varius. Suspendisse feugiat nisl ligula, quis malesuada felis hendrerit ut.\n<a href=\"https://c.com\"> Link to c </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://c.com\"/>\n</head>  \n<body>\nUt condimentum urna at felis sodales rutrum. Sed dapibus cursus diam, non interdum nulla tempor nec. Phasellus rutrum enim at orci consectetu blind\n<a href=\"https://a.com\"> Link to a </a>\n</body>\n</html>"});
    }

    public int solution(String word, String[] pages){
        int answer = -1;
        double min = -1;
        int minIndex = -1;
        int index = 0;
        HashMap<String, int[]> map = new HashMap<>();
        HashMap<String, List<String>> linkMap = new HashMap<>();
        HashMap<Integer, Double> scoreMap = new HashMap<>();

        for (String page : pages) {
            int outerLinkCount = 0;
            int wordCount = 0;
            word = word.toLowerCase();
            String[] content = page.split("<meta property="+"\"og:url\" content=");
            String title = content[1].split("/>")[0];
            String body = content[1].split("<body>")[1].split("</body>")[0];
            body = body.toLowerCase();
            for(int i=0;i<body.length();i++) {
                if (body.substring(i).startsWith("<a href=")) {
                    List<String> list = linkMap.getOrDefault(body.substring(i).split("=")[1].split(">")[0], new ArrayList<>());
                    list.add(title);
                    linkMap.put(body.substring(i).split("=")[1].split(">")[0], list);
                    outerLinkCount++;
                }
                if (body.substring(i).startsWith(word)) {
                    if (!body.substring(i, i+word.length()+1).matches(word+"[a-zA-Z]") && !body.substring(i-1, i+word.length()).matches("[a-zA-Z]"+word)) {
                        wordCount++;
                    }
                }
            }
            map.put(title, new int[]{outerLinkCount, wordCount, index++});
        }


        for (String key : map.keySet()) {
            int[] ints = map.get(key);
            scoreMap.put(ints[2], ((double)ints[1]));
        }

        for (String key : linkMap.keySet()) {
            List<String> value = linkMap.get(key);
            if (map.containsKey(key)) {
                int scoreIndex = map.get(key)[2];
                double linkScore = 0;
                for (String link : value) {
                    if (map.containsKey(link)) {
                        int[] ints = map.get(link);
                        linkScore += ((double) ints[1]) / ints[0];
                    }
                }
                scoreMap.put(scoreIndex, scoreMap.get(scoreIndex) + linkScore);
            }
        }


        for (int key : scoreMap.keySet()) {
            double score = scoreMap.get(key);
            if (score > min) {
                min = score;
                minIndex = key;
            } else if (score == min) {
                if (key < minIndex) {
                    minIndex = key;
                }
            }
        }

        answer = minIndex;
        return answer;
    }
}
