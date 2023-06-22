import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

class Solution {
  public int[] solution(int[] progresses, int[] speeds) {
    List<Integer> list = new ArrayList<>();

    Queue<Integer> remainDays = initQueue(progresses, speeds);

    int day = 0;

    int count = 0;

    while(!remainDays.isEmpty()) {
      int remainDay = remainDays.poll();

      if (day >= remainDay) {
        count++;
      } else {
        if (count != 0) {
          list.add(count);
        }

        count = 1;

        day += remainDay -  day;
      }
    }

    list.add(count);

    int[] answer = new int[list.size()];

    for (int i = 0; i < list.size(); i++) {
      answer[i] = list.get(i);
    }

    return answer;
  }


  private Queue<Integer> initQueue(int[] progresses, int[] speeds) {
    Queue<Integer> q = new LinkedList<>();

    for (int i = 0; i < progresses.length; i++) {
      int remain = Math.max(0, 100 - progresses[i]);

      if (remain == 0) {
        continue;
      }

      q.offer(remain / speeds[i] + Math.min(1, remain % speeds[i]));
    }

    return q;
  }
}