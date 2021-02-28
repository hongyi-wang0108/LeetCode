package Day24;

public class Test2 {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        System.out.println(search(nums,8));
    }
    //平均情况下，二分查找的时间复杂度为O(log(n))，当数组元素全部等于target时，退化到O(n)
    static int count=0;
    public static int search(int[] nums, int target) {//递归
       // this.nums = nums;
        helper(nums,target,0,nums.length-1);//传入左右边界
        return count;
    }

    private static void helper(int[] nums, int target, int left, int right) {
        if(left <= right){
            int mid = (right+ left) / 2;
            if(nums[mid] == target){//找到tar的时候 cnt++
                count++;
                helper(nums,target,left,mid-1);//这时候可能左边还有tar
                helper(nums,target,mid+1,right);//这时候可能右边还有tar
            }
            if(nums[mid] > target){//mid比tar大的时候，调整范围到left----mid-1
                helper(nums,target,left,mid-1);
            }
            if(nums[mid] < target){//mid比tar小的时候，调整范围到mid+1-----right
                helper(nums,target,mid+1,right);
            }
        }
    }

}
