import javax.swing.plaf.IconUIResource;

// 프로그래머스 네트워크
public class test {
    static boolean[] visited;
    static int[][] graph;
    static int n;
    static int count=0;
    public static void main(String[] args) {
        int[][] computers = {{1,1,0}, {1,1,1}, {0,1,1}}; // 2
        n=3;
        graph = computers;
        visited = new boolean[graph.length];
        dfs(0);
        System.out.println(n-count);
        //노드 - count = 네트워크의 갯수 // 노드3 간선 1 = 2 // 노드 3 간선 2 = 1
    }
    static void dfs(int start) { // 간선의 갯수 count로 세기
        visited[start] = true;
        for(int i=0; i<n; i++){
            if(visited[i] == false && graph[start][i] == 1){
                count ++;
                dfs(i);
            }
        }
    }
}
