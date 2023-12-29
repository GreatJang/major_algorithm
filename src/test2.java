import java.lang.reflect.GenericDeclaration;
import java.util.*;
//프로그래머스 게임 맵 최단거리
public class test2 {
    static List<List<Integer>> adjList;
    static boolean[] visited;
    static int[] distance;
    public static void main(String[] args) {
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        int m = maps.length;
        int n = maps[0].length;
        visited = new boolean[m*n];
        adjList = new ArrayList<>();
        distance = new int[m*n];
        for (int i = 0; i < m*n; i++) {
            adjList.add(new ArrayList<>());
        }
        Arrays.fill(distance,1);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) { // 0부터시작
                if(maps[i][j]==0) continue; // 본인이 0인자리 넘어가기
                int[] dx = {-1, 1, 0, 0};
                int[] dy = {0, 0, -1, 1};
                for (int d = 0; d < 4; d++) { // 0부터 시작
                    int target_i = i + dx[d];
                    int target_j = j + dy[d];
                    if (target_i >= 0 && target_i < m && target_j >= 0 && target_j < n && maps[target_i][target_j]==1) {
                        addEdge(i * n + j, target_i * n + target_j); // a는 내가 갈곳 // b는 인접노드
                    }
                }
            }
        }
//
//        distance = new int[m*n];
//        int end=25;
//        int shortest = bfs(0, end); // 0에서 end까지 갔을때
        System.out.println(bfs(0, m*n-1));
    }

    static int bfs(int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) { // 자주쓰이기 때문에 코드 외우기
            int next = queue.poll(); // 방문
//            System.out.print(next + " ");
            for (int target : adjList.get(next)) { // next에 근접해 있는 숫자들을 target으로 가져옴
                if (visited[target] != true) { // 가져온 target이 true가 아닌경우에 queue에 target을 add // true이면 queue에 추가 안됌.
                    queue.add(target); //queue에 담았을때 바로 visited 를 true로 바꿔야 한다.
                    distance[target] = distance[next] + 1;
                    visited[target] = true; //queue에 넣기전에 visited를 true로 바꾸어주면 queue에 중복되서 값이 들어갈 수 있기때문에
                    if (target == end) {
                        return distance[end];
                    }
                }
            }
        }
        return -1;
    }
    static void addEdge(int a, int b) {
        adjList.get(a).add(b);
        adjList.get(b).add(a);
    }
}

////BFS노드 만들기
//for(int i=1; i<=3;~)
//    for(int i=1; i<=5;~)
//    //1,1부터 시작하면 (i-1)*5(열의 개수) +j // 가로 5 // 세로 3
////0,0부터 시작하면 i*열의 개수  +j+1

//첫시작을 1로세팅하고 시작.
//0,0부터 시작해서 2,3자리까지 가는데 최단거리를 구하라고하면
//1,1부터 시작해서 3,4자리까지 가는 거리를 구한다.
//타겟의 번호와 타켓의 유효성(2)
// 타겟의 번호 : j에 -1빼면 왼쪽, j에 1더하면 오른쪽 등
// 타겟의 유효성 i와 j가 상하좌우 길이 체크