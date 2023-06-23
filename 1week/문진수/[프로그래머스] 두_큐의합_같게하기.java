import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        long total = 0;
        long hap = 0;
        int ans = 0;
        for (int i = 0; i < queue1.length ; i++) {

            total+= queue1[i];
            hap += queue1[i];
            total+= queue2[i];
            q1.add(queue1[i]);
            q2.add(queue2[i]);
        }


        total /= 2;

        while(hap != total){
            if(ans > (queue1.length + queue2.length)*2) return -1;
            if(hap == total){break;}
            else if(hap > total){
                int temp1 = q1.poll();
                hap-=temp1;
                q2.add(temp1);
            }else{
                int temp2 = q2.poll();
                hap+= temp2;
                q1.add(temp2);
            }
            ans++;
        }

        return ans;

    }
}