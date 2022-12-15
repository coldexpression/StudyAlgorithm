package Level4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class problem60060 {


    public class TrieNode {

        private Map<Character, TrieNode> childNode = new HashMap<>();
        private Map<Integer, Integer> lengthMap = new HashMap<>();

        private boolean endOfWord;

        public Map<Character, TrieNode> getChildNode() {
            return childNode;
        }

        public Map<Integer, Integer> getLengthMap() {
            return lengthMap;
        }

        public boolean isEndOfWord() {
            return endOfWord;
        }

        public void setEndOfWord(boolean endOfWord) {
            this.endOfWord = endOfWord;
        }
    }

    public class Trie {
        private TrieNode rootNode;

        public Trie() {
            rootNode = new TrieNode();
        }

        void insert(String word) {
            TrieNode thisNode = this.rootNode;

            for (int i = 0; i < word.length(); i++) {
                if (thisNode.lengthMap.containsKey(word.length())) {
                    thisNode.lengthMap.put(word.length(), thisNode.lengthMap.get(word.length()) + 1);
                } else {
                    thisNode.lengthMap.put(word.length(), 1);
                }

                thisNode = thisNode.getChildNode().computeIfAbsent(word.charAt(i), val -> new TrieNode());
            }

            thisNode.setEndOfWord(true);
        }

        int search(String word) {
            TrieNode thisNode = this.rootNode;

            for(int i=0;i<word.length();i++) {
                char c = word.charAt(i);
                if (c == '?') break;

                if (thisNode.getChildNode().containsKey(c)) {
                    thisNode = thisNode.getChildNode().get(c);
                } else {
                    return 0;
                }
            }

            if (thisNode.getLengthMap().containsKey(word.length())) {
                return thisNode.getLengthMap().get(word.length());
            }

            return 0;

        }
    }

    public static void main(String[] args) {
        problem60060 problem60060 = new problem60060();
        problem60060.solution(new String[]{"frodo","front","frost","frozen","frame","kakao"}, new String[]{"fro??","????o","fr???","fro???","pro?"});
    }

    public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];
        int idx = 0;

        Trie frontTrie = new Trie();
        Trie backTrie = new Trie();

        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            frontTrie.insert(word);
            backTrie.insert(sb.append(word).reverse().toString());
        }

        for (String query : queries) {
            StringBuilder sb = new StringBuilder();
            if (query.charAt(0) == '?') {
                answer[idx++] = backTrie.search(sb.append(query).reverse().toString());
            } else {
                answer[idx++] = frontTrie.search(query);
            }
        }
        return answer;
    }

}
