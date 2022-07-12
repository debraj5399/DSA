public class Palindrome {

    public static boolean palindrome(String str, int index, int N) {
        if (index >= N / 2) {
            return true;
        }
        if (str.charAt(index) != str.charAt(N - index - 1))
            return false;
        return palindrome(str, index + 1, N);
    }

    public static void main(String[] args) {
        System.out.println(palindrome("MADAM", 0, 5));
    }

}
