package Day37;

public class Test2 {
    public static void main(String[] args) {

    }
    public int singleNumber(int[] nums) {
        //时间复杂度 O(N)O(N) ： 其中 NN 位数组 numsnums 的长度；遍历数组占用 O(N)O(N) ，每轮中的常数个位运算操作占用 O(32 \times3 \times 2) = O(1)O(32×3×2)=O(1) 。
        //空间复杂度 O(1)O(1) ： 变量 onesones , twostwos 使用常数大小的额外空间
        //有限状态自动机
        int ones = 0,twos = 0;
        for (int n : nums) {
            //1. 最原始
            //if two == 0:
            //  if n == 0:
            //    one = one
            //  if n == 1:
            //    one = ~one
            //if two == 1:
            //    one = 0

            //2. 引入 异或运算 ，可将以上拆分简化为：ones^n
            //if two == 0:
            //    one = one ^ n
            //if two == 1:
            //    one = 0

            //3. 引入 与运算 ，可继续简化为：
            //one = one ^ n & ~two

            ones = ones^n & ~twos;
            twos = twos^n & ~ones;//因为等价
        }
        return ones;
    }
}
