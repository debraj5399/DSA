import java.util.ArrayList;

public class SubsequencePatterns {
    
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

    public static boolean firstSumSubsequence(int [] arr, ArrayList<Integer> ans, int size, int index, int sum, int s){
        if(index == size){
            if(s == sum){
                System.out.println(ans);
                return true;
            }
            return false;
        }

        ans.add(arr[index]);
        s+=arr[index];

        if(firstSumSubsequence(arr, ans, size, index+1, sum, s)==true) return true;

        ans.remove(ans.size()-1);
        s-=arr[index];

        if(firstSumSubsequence(arr, ans, size, index+1, sum, s)==true) return true;

        return false;
    }

    public static int countSumSubsequence(int [] arr, int size, int index, int sum, int s){
        if(index == size){
            if(s == sum){
                return 1;
            }
            return 0;
        }
        s+=arr[index];
        int l = countSumSubsequence(arr, size, index+1, sum, s);
        s-=arr[index];
        int r = countSumSubsequence(arr, size, index+1, sum, s);
        return l + r;
    }

    public static void main(String[] args) {
        int [] arr = {3,1,2};
        ArrayList<Integer> ans = new ArrayList<>();
        System.out.println("All Subsequences of Arr : ");
        printSubsequence(arr, ans, 3, 0);
        System.out.println("------------------");
        System.out.println("Subsequence of Arr with Sum 3");
        sumSubsequence(arr, ans, 3, 0, 3, 0);
        System.out.println("------------------");
        System.out.println("First Subsequence of Arr with Sum 3:");
        firstSumSubsequence(arr, ans, 3, 0, 3, 0);
        System.out.println("------------------");
        System.out.println("Count of Subsequences of Arr with Sum 3 : "+countSumSubsequence(arr, 3, 0, 3, 0));
        
    }
}
