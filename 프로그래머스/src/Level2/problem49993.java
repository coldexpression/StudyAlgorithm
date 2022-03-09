package Level2;

import java.util.*;

public class problem49993 {

    public static void main(String[] args) {

    }

    public int solution(String skill, String[] skill_trees) {
        Queue<String> skillTrees = new LinkedList<>();
        int answer = 0;
        int count = 0;
        boolean check;
        for(String index: skill_trees) {
            check = true;
            count = 0;
            for(String word: index.split("")) skillTrees.add(word);

            while(!skillTrees.isEmpty()) {
                if (count == skill.length()) break;
                String pickSkill = skillTrees.peek();
                String currentSkill = String.valueOf(skill.charAt(count));


                if (skill.contains(pickSkill)) {
                    if(pickSkill.equals(currentSkill)) {
                        count++;
                    } else {
                        check = false;
                        break;
                    }
                }
                skillTrees.poll();
            }

            answer = check ? answer + 1 : answer;
            skillTrees.clear();
        }
        return answer;
    }
}
