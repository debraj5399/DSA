public class ReverseArray {
    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    public static void reverse(int[] arr, int index, int N){
        if(index>N/2){
            return;
        }
        swap(arr, index, N-index-1);
        reverse(arr, index+1, N);
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        reverse(arr, 0, 5);
        for(Integer it: arr){
            System.out.println(it);
        }
    }
}
 