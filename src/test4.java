import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.*;

public class test4 {
    //    프로그래머스 가장 먼 노드
    static List<List<Integer>> adjList;
    static boolean[] visited;
    static int[] distance;

    public static void main(String[] args) {
//        가장 멀리 떨어진 노드란 최단경로로 이동했을 때 간선의 개수가 가장 많은 노드들을 의미
//        1번 노드로부터 가장 멀리 떨어진 노드가 몇 개인지를 return

        int[][] inputArr = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        int node_n = 7; //6+1
        visited = new boolean[node_n];
        adjList = new ArrayList<>();
        for (int i = 0; i < node_n; i++) {
            adjList.add(new ArrayList<>());
        }
        distance = new int[node_n];
        Arrays.fill(distance,1);
        for(int[] a : inputArr){
            addEdge(a[0], a[1]);
        }
        bfs(1); // 노드 1번부터 시작
        int max = Arrays.stream(distance).max().getAsInt();
        int answer = (int)Arrays.stream(distance).filter(a->a==max).count();
        System.out.println(Arrays.toString(distance));
        System.out.println(answer);
    }

    static int bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int next = queue.poll(); //방문
//            System.out.print(next + " ");
            for (int taget : adjList.get(next)) {
                if (visited[taget] != true) {
                    queue.add(taget); //방문예정인 데이터를 큐에 담는것.
                    distance[taget] = distance[next] + 1;
                    visited[taget] = true;
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