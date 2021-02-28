package Day32;

import java.util.Arrays;

public class Test1 {
    public static void main(String[] args) {
        int[] nums = {3,30,34,9,5};
        System.out.println(minNumber(nums));
    }
    public static String minNumber(int[] nums) {
        //时间复杂度O(NlogN) ： N 为最终返回值的字符数量（strs 列表的长度 N≤N ）；
        // 使用快排或内置函数的平均时间复杂度为O(NlogN) ，最差为 O(N^2)
        //空间复杂度 O(N)O(N) ： 字符串列表 strsstrs 占用线性大小的额外空间。
        String[] arr = new String[nums.length];
        for (int i = 0; i < arr.length; i++) {//int数组变string数组
            arr[i] = String.valueOf(nums[i]);
        }
        //lamba表达式x,y的，按字典顺序排序比较
        Arrays.sort(arr,(x,y) -> (x+y).compareTo(y+x));
        StringBuilder s = new StringBuilder();
        for (String s1 : arr) {
            s.append(s1);
        }
        return s.toString();
    }
}
