public class DFSArrayGraph {
    static boolean[] visited;
    static int[][] static_graph;
    public static void main(String[] args) {
        int[][] graph =
                {{0, 1, 1, 0, 0}, // 0에서 시작했을때
                {1, 0, 0, 1, 0},
                {1, 0, 0, 1, 1},
                {0, 1, 1, 0, 0},
                {0, 0, 1, 0, 0}};
        static_graph = graph;
        visited = new boolean[graph.length];
        dfs(0); // start 0부터 시작
    }
    static void dfs(int start){
        System.out.println(start);
        visited[start] = true;
        for(int i=0; i<static_graph[start].length; i++){ // start번째 배열의 길이만큼 for문 동작
                if(visited[i] == false && static_graph[start][i] == 1){ // start번째 배열에 i번째 요소가 1이면 dfs i반환
                    dfs(i);
            }
        }
    }
}
