public class PrintNumber {
    public static void print1toNBackTrack(int N){
        if(N==0){
            return;
        }
        print1toNBackTrack(N-1);
        System.out.println(N);
    }
    public static void printNto1BackTrack(int N){
        if(N==0){
            return;
        }
        printNto1BackTrack(N-1);
        System.out.println(11-N);
    }
    public static void printNto1(int N){
        if(N==0){
            return;
        }
        System.out.println(N);
        printNto1(N-1);
    }
    public static void print1toN(int N){
        if(N==0){
            return;
        }
        System.out.println(11-N);
        print1toN(--N);
    }
    public static void printName(String name, int count){
        if(count==0){
            return;
        }
        System.out.println("name :"+name);
        printName(name, --count);
    }

    public static void main(String[] args) {
        printName("debraj", 5);
        print1toN(10);
        printNto1(10);
        print1toNBackTrack(10);
        printNto1BackTrack(10);

    }
}
