import java.util.Arrays;

public class DPCoinProblem {
    public static void main(String[] args) {
//        프로그래머스 정수삼각형 문제풀기
//        1,4,5동전
//        13원이 되게 하는 최소의 동전의 개수
//        1) 식 : f(n) = min(f(n-a) : for a int coins) +1
//        2) 일반 for문 : 메모이제이션 : new int[amount]
        int[] coins = {1,4,5};
        int amount = 13;
//        최소동전의 개수 산출
        int answer = 0;
        int[] arr = new int[amount+1];
        arr[1] = 1;
        for(int i=2; i<=amount; i++){
            int min = amount;
            for(int c : coins){
                if(i-c <0) continue;
                if(min > arr[i-c]){
                    min = arr[i-c];
                }
            }
            arr[i] = min+1;

        }
        System.out.println(Arrays.toString(arr));
    }
}
