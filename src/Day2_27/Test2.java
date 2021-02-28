package Day2_27;

public class Test2 {
    public static void main(String[] args) {

    }
    public int nthUglyNumber(int n) {
        //时间复杂度 O(N)O(N) ： 其中 N = n ，动态规划需遍历计算 dpdp 列表。
        //空间复杂度 O(N)O(N) ： 长度为 NN 的 dpdp 列表使用 O(N)O(N) 的额外空间
        int[] dp = new int[n];//记录丑数
        dp[0] = 1;//记录第一个
        int a = 0,b = 0,c = 0;//记录丑数因子的下标
        for (int i = 1; i < n; i++) {//i要从1开始 因为第一个都确定了丑数就是因子 * 叫小一点的丑数
            int n2 = dp[a] * 2;
            int n3 = dp[b] * 3;
            int n5 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n2,n3),n5);//找最小的

            if(dp[i] == n2) a++;//对应的话就+1
            if(dp[i] == n3) b++;
            if(dp[i] == n5) c++;
        }
        return dp[n-1];
    }
}
