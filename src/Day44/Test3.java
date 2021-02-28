package Day44;

import java.util.HashSet;
import java.util.Set;

public class Test3 {
    public boolean isStraight(int[] nums) {
        //时间复杂度 O(N) = O(5) = O(1)O(N)=O(5)=O(1) ： 其中 NN 为 numsnums 长度，本题中 N \equiv 5N≡5 ；遍历数组使用 O(N)O(N) 时间。
        //空间复杂度 O(N) = O(5) = O(1)O(N)=O(5)=O(1) ： 用于判重的辅助 Set 使用 O(N)O(N) 额外空间
        Set<Integer> repeat = new HashSet<>();//为了判断后面有没有重复的
        int min = 14,max = 0;
        for (int num : nums) {
            if(num == 0) continue;
            max = Math.max(max,num);
            min = Math.min(min,num);
            if(repeat.contains(num)) return false;
            repeat.add(num);
        }
        return max - min < 5;
    }
}
