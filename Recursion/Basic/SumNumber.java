
class SumNumber {

    public static void sumNumberParameterised(int N, int sum){
        if(N==0){
            System.out.println("Sum : "+sum);
            return;
        }
        sumNumberParameterised(N-1, sum+N);
    }

    public static int sumNumberFunctional(int N){
        if(N==0){
            return 0;
        }
        return N + sumNumberFunctional(N-1);
    }

    public static void main(String[] args) {
        sumNumberParameterised(5, 0);
        System.out.println(sumNumberFunctional(5));
    }
}
