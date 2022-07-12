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


    public static void sumSubsequence(int [] arr, ArrayList<Integer> ans, int size, int index, int sum, int s){
        if(index == size){
            if(s == sum){
                System.out.println(ans);
            }
            return;
        }

        ans.add(arr[index]);
        s+=arr[index];

        sumSubsequence(arr, ans, size, index+1, sum, s);

        ans.remove(ans.size()-1);
        s-=arr[index];

        sumSubsequence(arr, ans, size, index+1, sum, s);
    }

    public static void main(String[] args) {
        int [] arr = {3,1,2};
        ArrayList<Integer> ans = new ArrayList<>();
        System.out.println("All Subsequences of Arr : ");
        printSubsequence(arr, ans, 3, 0);
        System.out.println("------------------");
        System.out.println("Subsequence of Arr with Sum 3");
        sumSubsequence(arr, ans, 3, 0, 3, 0);
    }
}
