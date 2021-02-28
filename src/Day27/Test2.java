package Day27;

public class Test2 {
    public static void main(String[] args) {

    }
    public int missingNumber(int[] nums) {
        //时间复杂度 O(log N)O(logN)： 二分法为对数级别复杂度。
        //空间复杂度 O(1)O(1)： 几个变量使用常数大小的额外空间。
        int left = 0;
        int right = nums.length-1;
        while (left <= right){//当两者指向一个的时候退出，这个代表判断了全部
            int mid = (left + right) / 2;
            if(mid == nums[mid])//这个是最平常，当正常时，说明错误情况出现在后面
                left = mid + 1;
            else
            right = mid-1;
        }
        return left;

    }
}
