package Day1;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test1 {
    public static void main(String[] args) {
        int[] nums = {2,2,3,0};
        System.out.println(111);
        System.out.println(findRepeatNumber2(nums));

/*        int i = findRepeatNumber(nums);
        System.out.println(i);*/
    }
/*    在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
    数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
    请找出数组中任意一个重复的数字。*/


    public static int findRepeatNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){//baohan
                map.put(nums[i],(map.get(nums[i])) + 1);
                return nums[i];
            }else {
                map.put(nums[i],1);
            }
        }
        return 0;

    }
    public static int findRepeatNumber2(int[] nums) {
        //假设 现在是 没有重复，并且数组内是0~n-1大小的数字
        //现在把他们排好
        // 2 2 3 0
        for (int i = 0; i < nums.length; i++) {
            while(nums[i] != i){//2 0
                if(nums[i] != i && nums[i] == nums[nums[i]])//2 0 2 nums[2]3
                    return nums[i];
                int temp = nums[i];//2 nums[i]是2
                nums[i] = nums[nums[i]];//nums[i] 是 3
                nums[temp] = temp;//nums[]    所以不能写 nums[nums[i]] = temp;因为nums[nums[i]]从nums[2]-->nums[3]
                //这是犯错的重点，虽然思路是nums[nums[i]]与nums[i]交换值，
                //但是这一步（nums[temp] = temp;）的时候，nums[i](是2)已经是交换过的值了（2->3），所以这一部用nums[temp]
                //代替nums[nums[i]]
            }
        }
        return -1;
    }
}
