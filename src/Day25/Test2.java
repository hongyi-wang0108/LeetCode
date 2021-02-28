package Day25;

import java.util.ArrayList;

public class Test2 {
    public static void main(String[] args) {

    }
    public int majorityElement(int[] nums) {
        //时间复杂度 O(N) ： N 为数组 nums 长度。
        //空间复杂度 O(1) ： votes 变量使用常数大小的额外空间
        int x = 0;//x是当前众数
        int votes = 0;//当前得分
        for (int num : nums) {
            if(votes == 0){//如果得分为0了，那前面就不要了，从当前位开始继续赋值新的众数，到最后一定会有一个得分为正，就是众数
                x = num;
            }
            votes = votes + (x == num ? 1 : -1);//与当前众数相等，得分+1 否则-1
        }
        return x;
    }
}
