package Day3;

public class Test1 {
    public static void main(String[] args) {
        //0 <= n <= 100
        int n = 5;
        System.out.println(fib2(n));
    }
    public static int fib(int n) {
        int[] arr = new int[n+1];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i <=n; i++) {
            arr[i] = arr[i-1]+arr[i-2];
            arr[i] = arr[i] %1000000007;
        }
        if(n==0)return 0;
        return arr[n];
    }
    public static int fib2(int n) {

        int a1 = 0;
        int a2 = 1;
        int temp = 0;
        for (int i = 2; i <=n; i++) {
           temp = a1 + a2;
           a1 = a2;
           a2 = temp %1000000007;
        }
        if(n==0)return 0;
        return a2;
    }
}
