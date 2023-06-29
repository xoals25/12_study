import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        //미사일을 최소로 사용해서 모든 폭격 미사일을 요격
        int answer = 0;

        Arrays.sort(targets, (o1, o2) -> { return o1[1]-o2[1]; });

        int end = 0;
        for (int [] num: targets
        ) {
            int x1 = num[0];
            int x2 = num[1];
            if(end == 0){
                // 첫 end 값
                answer++;
                end = x2 -1;
                continue;
            }
            if(end >= x1 && end <= x2){
                // s ,e 값이면 continue
                continue;
            }
            answer++;
            end = x2-1;

        }

        return answer;
    }
}