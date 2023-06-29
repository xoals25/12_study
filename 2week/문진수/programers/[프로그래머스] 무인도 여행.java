import java.util.*;
class Solution {

    static boolean [][] check;
    static char [][] graph;
    static ArrayList<Integer> list = new ArrayList();
    static int [] dx = {-1,1,0,0};
    static int [] dy = {0,0,-1,1};

    public int[] solution(String[] maps) {
        int[] answer = {};

        check = new boolean[maps.length][maps[0].length()];
        graph = new char[maps.length][maps[0].length()];

        for (int i = 0; i < maps.length; i++) {
            graph[i] = maps[i].toCharArray();
        }

        for (int i = 0; i < graph.length ; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                if('X'!= graph[i][j] && !check[i][j]){
                    list.add(bfs(graph,i,j));
                }
            }
        }

        // 오름차순 정렬 및 list => 배열로 변환
        answer =  list.stream().mapToInt(Integer::intValue).sorted().toArray();

        // answer배열의 길이가 0이면 -1  크면 answer 그대로 반환
        return answer.length == 0 ? new int[]{-1} : answer;
    }


    private static int bfs(char[][] graph, int x, int y) {
        int sum = 0;

        Queue<Nodes> q = new LinkedList<>();
        q.offer(new Nodes(x,y));
        check[x][y] = true;

        while(!q.isEmpty()){
            Nodes cur = q.poll();
            int cX = cur.x;
            int cY = cur.y;
            sum+= graph[cX][cY]-'0';

            for (int i = 0; i < 4; i++) {
                int nx = cX + dx[i];
                int ny = cY + dy[i];

                if(nx <0 || ny < 0 || nx >= graph.length ||ny >= graph[0].length ){
                    continue;
                }

                if(!check[nx][ny] && graph[nx][ny] != 'X'){
                    check[nx][ny] = true;
                    q.offer(new Nodes(nx,ny));
                }

            }

        }
        return sum;


    }

}

class Nodes {
    int x ;
    int y ;
    public Nodes(int x, int y){
        this.x = x;
        this.y = y;
    }
}