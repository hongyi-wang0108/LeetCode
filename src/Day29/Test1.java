package Day29;

import java.util.ArrayList;
import java.util.List;

public class Test1 {
    public static void main(String[] args) {
        findContinuousSequence(9);
    }
    public static int[][] findContinuousSequence(int target) {
        //滑动窗口的重要性质是：窗口的左边界和右边界永远只能向右移动，而不能向左移动。
        // 这是为了保证滑动窗口的时间复杂度是 O(n)O(n)。
        // 如果左右边界向左移动的话，这叫做“回溯”，算法的时间复杂度就可能不止 O(n)O(n)。
        int left = 1;//滑动窗口，从1开始  //左闭，右开
        int right = 1;//一样
        int sum = 0;
        List<int[]> list = new ArrayList<>();
        while (left <= target/2){//因为是滑动窗口是1~n的递增序列，当左边界大于二分之target时候，后面加的肯定大于tar
            if(sum > target){//要先加减，在移动，因为左移时，减去的是移动之前的数
                sum -= left;
                left++;
            }else if(sum < target){
                sum += right;
                right++;
            }else {//==
                int[] arr = new int[right-left];
                for (int i = left; i < right; i++) {
                    arr[ i -left] = i;
                }
                list.add(arr);//满足了，先添加
                // sum-= left;
                // left++;
                //优化后
                sum -= 2*left+1;//现在是移动左边框，找下一个可能性   先减，在移动
                left += 2;//可以优化成这个，比如2 3 4向后移一个，后面不可能有满足条件的了（2在前面），所以往后移两个
            }
        }
        return list.toArray(new int[list.size()][]);

    }
}
