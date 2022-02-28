package Level2;

import java.util.*;

public class problem12911 {

    public static void main(String[] args) {

    }

    public int solution(int n) {
        int answer = 0;
        int mok = n;
        int ret = 0;
        int iCount = 0;
        int checkCount = 0;

        while(mok != 0) {
            ret = mok % 2;
            mok = mok / 2;
            iCount = ret == 1 ? iCount+1 : iCount;
        }


        for(int i=n+1;;i++) {
            mok = i;
            checkCount = 0;
            while(mok != 0) {
                ret = mok % 2;
                mok = mok / 2;
                checkCount = ret == 1 ? checkCount+1 : checkCount;
                if (checkCount > iCount) break;
            }
            if (checkCount == iCount) {
                answer = i;
                break;
            }
        }

        return answer;
    }
}
