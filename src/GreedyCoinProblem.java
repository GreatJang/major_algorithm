public class GreedyCoinProblem {
    public static void main(String[] args) {
        int[] coins = {1, 5, 10, 25};
        int amount = 99;
        int count = 0;
//        최소동전의 개수 산출
        int answer = 0;
        for(int i=coins.length-1; i>=0; i--){
            int temp = amount / coins[i];
            answer += temp;
            amount -= temp * coins[i];
        }
        System.out.println(answer);
    }
}
