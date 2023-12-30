import java.lang.reflect.GenericDeclaration;
import java.util.*;

public class BFSListGraph {
    static List<List<Integer>> adjList; // 리스트 안에 리스트 배열 설정
    static boolean[] visited;
    static int[] distance; // distance int배열 선언

    public static void main(String[] args) {
        int[][] inputArr = {{0, 1}, {0, 2}, {1, 3}, {2, 3}, {2, 4}};
        int node_n = 5; // 노드 갯수 설정
        visited = new boolean[node_n]; // 방문한 노드visited체크를 위해 boolean으로 설정
        adjList = new ArrayList<>(); // adjList 리스트안에 리스트 초기화
        for (int i = 0; i < node_n; i++) { // 노드 갯수만큼 반복
            adjList.add(new ArrayList<>()); // 노드의 갯수만큼 리스트 길이 생성
        }
        for (int[] a : inputArr) { // Enhanced for문으로 요소별로 값분리[0, 1], [0, 2], [1, 3], [2, 3], [2, 4]
            addEdge(a[0], a[1]); // addEdge로 값 넘김.
        }

//        for (int i = 1; i <= 3; i++) { //3 == 높이길이-행의개수
//            for (int j = 1; j <= 5; j++) { // 5== 가로길이-열의개수
//                1) 시작노드표현식 : (i-1)*5(열의개수)+j // 노드번호 구할때 사용
//                2) 타겟의 번호와 타겟의 유효성(2)
//                2-1)타겟의 번호 : j에 -1빼면 왼쪽, j에서 1더하면 오른쪽 등
//                2-2) 타겟의 유효성 : i와j가 상하좌우 길이 체크
//                if문 4개 들어가야 한다.
//                상하좌우 체크 로직 // index값 기준으로 체크
//                int[] dx = {-1, 1, 0, 0};
//                int[] dy = {0, 0, -1, 1};
//                for (int d = 0; d < 4; d++) {
//                    int target_i = i + dx[d];
//                    int target_j = j + dy[d];
//                    if (target_i >= 1 && target_i <= 3 && target_j >= 1 && target_j <= 5) {
//                        addEdge((i - 1) * 5 + j, (target_i - 1) * 5 + target_j); // a는 내가 갈곳 // b는 인접노드
//                    }
//                }
//            }
//        }

        distance = new int[node_n]; // distance int배열 선언 초기화
        int end = 3;
        int shortest = bfs(0, end); // 0에서 end까지 도달하는 최소거리 구하기
        System.out.println(shortest); // 최소거리 출력
    }

    static int bfs(int start, int end) { // BFS(넓이우선 탐색) 로직 구현
        Queue<Integer> queue = new LinkedList<>(); //queue 선언 및 초기화
        queue.add(start); // queue에 start노드 추가
        visited[start] = true; // 방문한 노드는 visited를 true로 설정.
        while (!queue.isEmpty()) { // queue가 안비어있으면 계속 반복 // 자주쓰이기 때문에 코드 외우기
            System.out.println(" 1queue" + queue);
            int next = queue.poll(); // 방문한노드(start) queue에서 꺼내서 next에 담기
            System.out.print("next: " + next);
            for (int target : adjList.get(next)) { // next(0)에 근접해 있는 숫자(1,2)들을 target으로 가져옴 // 1먼저 가져옴
                if (visited[target] != true) { // 가져온 target이 true가 아닌경우에 queue에 target을 add // true이면 queue에 추가 안됌.
                    queue.add(target); //queue에 담았을때 바로 visited 를 true로 바꿔야 한다.// 방문예정인 데이터를 큐에 담는것.
                    System.out.println(" 2queue" + queue);
                    distance[target] = distance[next] + 1;
                    System.out.println(Arrays.toString(distance));
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