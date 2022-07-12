import java.util.ArrayList;

public class Subsequence {
    
    public static void printSubsequence(int [] arr, ArrayList<Integer> ans, int size, int index){
        if(index == size){
            for(Integer it: ans){
                 System.out.print(it+" ");
            }
            if(ans.size()==0){
                System.out.print("{}");
            }
            System.out.println();
            return;
        }

        printSubsequence(arr, ans, size, index+1);

        ans.add(arr[index]);

        printSubsequence(arr, ans, size, index+1);

        ans.remove(ans.size()-1);
    }

    public static void main(String[] args) {
        int [] arr = {3,1,2};
        ArrayList<Integer> ans = new ArrayList<>();
        printSubsequence(arr, ans, 3, 0);
    }
}
