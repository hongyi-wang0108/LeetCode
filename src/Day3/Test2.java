package Day3;

public class Test2 {
    public static void main(String[] args) {
        System.out.println(numWays(2));
    }
    public static int numWays(int n) {
        //一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
        int a1 = 0;
        int a2 = 1;
        int temp = 0;
        if(n == 0) return 1;
        for (int i = 2; i < n+2; i++) {

            //System.out.println("a1:" + a1 + "a2:" + a2);
            temp = a1 + a2;
            a1 = a2;
            a2 = temp %1000000007;
        }
        return a2;
    }
}
