import javax.swing.plaf.IconUIResource;
import java.util.Arrays;

// 프로그래머스 네트워크
public class test {
    static boolean[] visited;
    static int[][] graph;
    static int n;
    static int count=0;
    public static void main(String[] args) {
        int[][] computers = {{1,0,0}, {0,1,1}, {0,1,1}}; // 2
        n=3;
        int a=0;
        graph = computers;
        visited = new boolean[n];
        for(int i=0; i<n; i++){ // dfs를 for문에 넣은 이유: dfs(0)이 간선이 없을 때는
//            dfs if문에 해당하지 않고 그대로 종료되는데, 그렇게 되면 그대로 구문이 종료되어 버리기 때문에
//            간선이 없더라도 그 다음 요소값을 체크할 수 있도록 for문에 넣은 것이다.
            dfs(i);
        }
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
