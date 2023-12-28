import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSListGraph {
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


        bfs(0);
    }

    static void addEdge(int a, int b){
        adjList.get(a).add(b);
        adjList.get(b).add(a);
        System.out.println(adjList);
    }

    static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);
        while (!queue.isEmpty()){ // 자주쓰이기 때문에 코드 외우기
            int next = queue.poll();
            System.out.print(next + " ");
            for(int target : adjList.get(next)){ // next에 근접해 있는 숫자들을 target으로 가져옴
                if(visited[target] != true){ // 가져온 target이 true가 아닌경우에 queue에 target을 add // true이면 queue에 추가 안됌.
                    queue.add(target); //queue에 담았을때 바로 visited 를 true로 바꿔야 한다.
                    visited[target] = true; //queue에 넣기전에 visited를 true로 바꾸어주면 queue에 중복되서 값이 들어갈 수 있기때문에
                }
            }

        }

    }
}
