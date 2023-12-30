import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DFSListGraph {
    static List<List<Integer>> adjList; // 리스트 안에 리스트 배열 설정
    static boolean[] visited;
    public static void main(String[] args) {
        int[][] inputArr = {{0,1}, {0,2}, {1,3}, {2,3}, {2,4}};
        int node_n = 5; // 노드 갯수 설정
        visited = new boolean[node_n]; // 방문한 노드visited체크를 위해 boolean으로 설정
        adjList = new ArrayList<>(); // adjList 리스트안에 리스트 초기화
        for(int i=0; i<node_n; i++){ // 노드 갯수만큼 반복
            adjList.add(new ArrayList<>()); // 노드의 갯수만큼 리스트 길이 생성
        }
        for(int[] a :  inputArr){ //Enhanced for문으로 요소별로 값분리[0, 1], [0, 2], [1, 3], [2, 3], [2, 4]
            addEdge(a[0], a[1]); // addEdge로 값 넘김.
        }
        dfs(0);
    }
    static void addEdge(int a, int b){ // addEdge(a[0], a[1]);에서 넘겨준 값 받음.
        adjList.get(a).add(b); // a자리에 b값 넣기
        adjList.get(b).add(a); // b자리에 a 값넣기 // 반대로 뒤집에서 넣어주느 이유는 양방향으로 설정해주어야 하기때문.
    }

    static void dfs(int start){ //DFS 로직 구현
        System.out.print(start + ", "); // 방문한 노드 출력
        visited[start] = true; // 방문한 노드는 visited를 true로 설정.
        for(int target : adjList.get(start)){ // start번째 배열의 길이만큼 for문 동작
            if(visited[target] == false){ // 만약 visited가 false이고, start번째 배열에 i번째 요소가 1이면 dfs i반환
                dfs(target);
            }
        }
    }
}
