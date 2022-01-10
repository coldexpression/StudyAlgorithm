package Level2;

import java.util.ArrayList;
import java.util.List;

public class problem1835 {

    public static void main(String[] args) {

    }

    public int solution(int n, String[] data) {
        int answer = 0;
        // {N,F,R,A,C,T,J,M} => 64 // (16+8+8+8) => 40 // (16+8+4+2) => 30
        // acjm acmj ajcm ajmc amcj amjc
        // cajm camj cjam cjma cmaj cmja
        // jacm jamc jcam jcma jmac jmca
        // macj majc mcaj mcja mjac mjca
        // 8+4+4+4 = 20
        // {N,F,R,A,C,J,T,M} => 64 // 40 // 20
        // {N,F,R,A,C,J,M,T} => 64 // 40 // 20
        // {N,F,A,R,C,J,T,M} => 64 // 40 // 20
        // {N,F,A,R,C,J,M,T} => 64 // 40 // 20
        // {N,F,A,C,R,J,M,T} => 64 // 40 // 20
        // => 64*6 = 384 // 40* 6 => 240 // 30* 6 * 2 => 360
        // R 과 T 위치 변경 => 384*2 = 768 // 480 // 20 * 6 * 2 = 240
        // {R,N,F,T,A,C,J,M} => 64 // 16 * 5 * 2 => 160
        // {R,N,F,A,T,C,J,M} => 64
        // {R,N,F,A,C,T,J,M} => 64
        // {R,N,F,A,C,J,T,M} => 64
        // {R,N,F,A,C,J,M,T} => 64
        //  768 * 2 => 1536 // 40 * 5 => 200 * 2 => 400 // 30 * 5 * 2 => 300 // 20 * 5 * 2 => 200
        // {R,A,N,F,T,C,J,M} => 64 // 16 * 4 * 2 => 128
        // ... 64*4 = 256 * 2 = 512 // 40*4 => 160 * 2 => 320 // 30 * 4 * 2 => 240 // 20 * 4 * 2 => 160
        // 1536 + 512 = 2048
        // {R,A,C,N,F,T,J,M} => 64 // 16 * 3 * 2 => 96
        // ... 64 * 3 => 192 * 2 => 384 // 40 * 3 * 2 => 240 // 30 * 3 * 2= > 180 // 20 * 3 * 2 => 120
        // 2048 + 384 = 2432
        // ... 64 * 3 => 252 * 2 => 504 // 40 * 3 => 120 * 2 => 240 // 30 * 3 * 2 => 180 // 20 * 3* 2 => 120
        // 2432 + 504 = 2936
        // {R,A,C,T,N,F,J,M}
        // {R,A,C,T,J,N,F,M}
        // {R,A,C,T,J,M,N,F}
        // {R,A,C,J,N,F,M,T} => 64 // 16 * 2 * 2 => 64
        // ... 64 * 2 => 128 * 2 => 256 // 40 * 2 * 2 => 160 // 30 * 2 * 2 => 120 // 20 * 2 * 2 => 80
        // 2936 + 256 = 3192
        // {R,A,C,J,M,N,F,T}
        // {R,A,C,J,M,T,N,F}

        // {R,A,C,J,M,T,N,F} => 64 // 16 * 2 => 32
        // ... 64 * 2 => 128 // 40 * 2 => 80 // 30 * 2 => 60 // 20 * 2 => 40
        // 3192 + 128 => 3320
        String[] store = new String[]{"A","C","F","J","M","N","R","T"};
        String[] exp = new String[data.length];
        int[] num = new int[data.length];
        List<String> alpha = new ArrayList<>();
        String[] temp = new String[8];
        int count = 0;
        int index = 0;
        int length = 0;
        for(int i=0;i<data.length;i++) {
            exp[i] = data[i].split("")[data.length-2];
            num[i] = Integer.parseInt(data[i].split("")[data.length-1]);
            alpha.add(data[i].split("")[0]);
            alpha.add(data[i].split("")[2]);
        }

        while(true) {
            length = num[count];

            switch(exp[count]) {
                case "=" : {
                    temp[0] = alpha.get(0);
                    alpha.remove(0);
                    temp[length+1] = alpha.get(0);
                    alpha.remove(0);
                } break;
                case "<" : {

                } break;
                case ">" : {

                } break;
            }
        }

        return answer;
    }
}
