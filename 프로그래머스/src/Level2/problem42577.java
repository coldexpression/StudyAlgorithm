package Level2;

import java.util.*;

public class problem42577 {

    public static void main(String[] args) {
        System.out.println("1234999".indexOf("12344"));
    }

    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashMap<String, String> store = new HashMap<>();
        Arrays.sort(phone_book);
        for (String s : store.keySet()) {
            System.out.println(s);
        }
        for (int i = 0; i < phone_book.length; i++) {
            String phoneNumber = phone_book[i];
            for (int j = 0; j <= phone_book[i].length(); j++) {
                if (store.get(phoneNumber) != null) {
                    return false;
                }
                store.put(phoneNumber.substring(0, j), "");
            }
        }
        return answer;
    }
}
