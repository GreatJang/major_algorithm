public class DFSArrayGraph {
    static boolean[] visited;
    static int[][] static_graph;
    public static void main(String[] args) {
//        DFS(깊이우선탐색)로직 구현
        int[][] graph =
                {{0, 1, 1, 0, 0}, // 0에서 시작했을때
                {1, 0, 0, 1, 0},
                {1, 0, 0, 1, 1},
                {0, 1, 1, 0, 0},
                {0, 0, 1, 0, 0}};
        static_graph = graph; // 2차원 배열을 static으로 설정
        visited = new boolean[graph.length]; // 방문한 노드visited체크를 위해 boolean으로 설정
        dfs(0); // start 0부터 시작
    }
    static void dfs(int start){ //DFS 로직 구현
        System.out.println(start); // 방문한 노드 출력
        visited[start] = true; // 방문한 노드는 visited를 true로 설정.
        for(int i=0; i<static_graph[start].length; i++){ // start번째 배열의 길이만큼 for문 동작
                if(visited[i] == false && static_graph[start][i] == 1){ // 만약 visited가 false이고, start번째 배열에 i번째 요소가 1이면 dfs i반환
                    dfs(i);
            }
        }
    }
}
