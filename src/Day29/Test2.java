package Day29;

public class Test2 {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray2bymyself(nums));
    }
    public static int maxSubArray2bymyself(int[] nums) {//
        int[] dp = new int[nums.length];
        int max = 0;
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]) ;
            max = Math.max(dp[i],max);
        }
        return max;
    }













    public static int maxSubArray(int[] nums) {
        //时间复杂度 O(N)O(N) ： 线性遍历数组 numsnums 即可获得结果，使用 O(N)O(N) 时间。
        //空间复杂度 On ： 使用常数大小的额外空间。
        int[] dp = new int[nums.length];//dp[i] 代表以元素 nums[i] 为结尾的连续子数组最大和。
        dp[0] = nums[0];
        int max = dp[0];
        for(int i=1;i < nums.length;i++){
            dp[i] = Math.max(dp[i-1] + nums[i],nums[i]);
            max = Math.max(max,dp[i]);//一直记录最大值
        }
        return max;
    }
}
