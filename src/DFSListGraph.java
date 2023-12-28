import java.util.ArrayList;
import java.util.List;

public class DFSListGraph {
    static List<List<Integer>> adjList;
    static boolean[] visited;
    public static void main(String[] args) {
        int[][] inputArr = {{0,1}, {0,2}, {1,3}, {2,3}, {2,4}};
        int node_n = 5;
        visited = new boolean[node_n];
        adjList = new ArrayList<>();
        for(int i=0; i<node_n; i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] a :  inputArr){
            addEdge(a[0], a[1]);
        }
        dfs(0);
    }
    static void addEdge(int a, int b){
        adjList.get(a).add(b);
        adjList.get(b).add(a);
        System.out.println(adjList);
    }

    static void dfs(int start){
        System.out.print(start + ", ");
        visited[start] = true;
        for(int target : adjList.get(start)){ // start번째 배열의 길이만큼 for문 동작
            if(visited[target] == false){ // start번째 배열에 i번째 요소가 1이면 dfs i반환
                dfs(target);
            }
        }
    }
}
