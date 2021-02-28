package Day26;

public class Test1 {
    public static void main(String[] args) {

    }
    public int[] exchange(int[] nums) {
        //时间复杂度 O(N)O(N) ： N 为数组 nums 长度，双指针 i, j 共同遍历整个数组。
        //空间复杂度 O(1)O(1) ： 双指针 i, j 使用常数大小的额外空间。
        if(nums.length == 1) return  nums;
        int j = 0;//j每次记录的都是最后一个奇数后一个数的下标，如果后一个是偶数，那就不变，如果是奇数，那就继续指向下一个的下一个
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] % 2 != 0){//交换最后一个奇数后面那个位置的数和最新遇到的奇数
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;//每次遇到的是奇数的时候下标往后+1
            }
        }
        return nums;
    }
}
