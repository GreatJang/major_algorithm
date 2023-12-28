import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {7, 6, 5, 8, 3, 5, 9, 1, 6};

//        최초 힙구성 : n/2번만큼 heapify
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            heapify(arr, i);
        }

//        최초 힙구성 이후에 최대힙과 마지막 노드와 change

        System.out.println(Arrays.toString(arr));
    }

    static void heapify(int[] arr, int root) { //change가 발생한 부모 index root index
//        int max_index = root;
//        int left = root * 2 + 1;
//        int right = root * 2 + 2;
//        if(left<arr.length && arr[max_index] < arr[left]){
//            max_index = left;
//        }
//        if(right<arr.length && arr[max_index] < arr[right]){
//            max_index = right;
//        }
//        if(max_index != root){ // root보다 값이 큰index가 있다는 if문
//            int temp = arr[root];
//            arr[root] = arr[max_index];
//            arr[max_index] = temp;
//            heapify(arr, max_index);
//        }

        if (arr.length > 2 * root + 1 && arr[root] < arr[2 * root + 1]) {
            int temp = arr[root];
            arr[root] = arr[2 * root + 1];
            arr[2 * root + 1] = temp;
            heapify(arr, 2 * root + 1);
        }
        if (arr.length > 2 * root + 2 && arr[root] < arr[2 * root + 2]) {
            int temp = arr[root];
            arr[root] = arr[2 * root + 2];
            arr[2 * root + 2] = temp;
            heapify(arr, 2 * root + 2);
        }


//        if (arr.length > 2 * root + 1 && arr[root] < arr[2 * root + 1] && arr[2 * root + 1]>arr[2 * root + 2]) {
//            int temp = arr[root];
//            arr[root] = arr[2 * root + 1];
//            arr[2 * root + 1] = temp;
//            heapify(arr, 2 * root + 1);
//        }
//        if (arr.length > 2 * root + 2 && arr[root] < arr[2 * root + 2] && arr[2 * root + 1]<arr[2 * root + 2]) {
//            int temp = arr[root];
//            arr[root] = arr[2 * root + 2];
//            arr[2 * root + 2] = temp;
//            heapify(arr, 2 * root + 2);
//        }

//        xx조건의 경우에 change로직 : left와 right비교해서 자리 change
//        index값이 arr.length를 넘어가면 없는 index이기 때문에 이거에 대한 체크 로직 추가
//        부모index가 i라하면 왼쪽노드의 index는 2*i+1, 오른쪽노드의 index는 2*i+2

//        if(change가 발생하면){
//            heapify(arr, xx);//change가 발생한 부모 index // 종료로직 따로 필요없음 알
//        }
    }
}
