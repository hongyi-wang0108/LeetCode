package Day27;

public class Test1 {
    public static void main(String[] args) {

    }
    public int[] twoSum(int[] nums, int target) {
        //时间复杂度 O(N)O(N) ： NN 为数组 numsnums 的长度；双指针共同线性遍历整个数组。
        //空间复杂度 O(1)O(1) ： 变量 ii, jj 使用常数大小的额外空间。
        int left = 0;//快慢指针
        int right = nums.length - 1;
        while (left < right){
            int current = nums[left] + nums[right];
            if(current == target) return new int[]{nums[left],nums[right]};
            if(current > target) right--;
            if(current < target) left++;
        }
        return new int[]{};
    }
}
