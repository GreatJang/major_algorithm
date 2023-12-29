import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
//        정렬이 돼 있어야 이분탐색 가능
        int [] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        Arrays.sort(arr);

        int start = 0;
        int end = arr.length-1;
        int middle = (start+end)/2;
        int find = 19;

        while (true){
            if(start > end){
                System.out.println("찾는 숫자가 없습니다.");
                break;
            }
            if(arr[middle] == find){
                System.out.println("숫자 " + find + "는 " + middle +"index에 있습니다.");
                break;
            }
            if(arr[middle] > find){
                end = middle -1;
                middle = (start+end)/2;
            }
            if(arr[middle] < find){
                start = middle +1;
                middle = (start+end)/2;
            }
        }
    }
}
