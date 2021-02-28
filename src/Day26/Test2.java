package Day26;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

public class Test2 {
    public static void main(String[] args) {
        int[] arr = {8,5,4,1,6,2,7,9};
        getLeastNumbers(arr,3);//1 2 4
    }

    public static int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        // 最后一个参数表示我们要找的是下标为k-1的数,因为第K个数的下标是k-1
        return quickSearch(arr, 0, arr.length - 1, k - 1);
    }

    private static int[] quickSearch(int[] nums, int lo, int hi, int k) {
        // 每快排切分1次，找到排序后下标为j的元素，如果j恰好等于k就返回j以及j左边所有的数；
        int j = partition(nums, lo, hi);
        if (j == k) {
            return Arrays.copyOf(nums, j + 1);
        }
        // 否则根据下标j与k的大小关系来决定继续切分左段还是右段。
        return j > k? quickSearch(nums, lo, j - 1, k): quickSearch(nums, j + 1, hi, k);
    }

    // 快排切分，返回下标j，使得比nums[j]小的数都在j的左边，比nums[j]大的数都在j的右边。
    private static int partition(int[] nums, int lo, int hi) {
        int v = nums[lo];
        int i = lo, j = hi + 1;
        while (true) {//while判断时先判断i <= hi ，然后++i，然后nums[i] < v这时候i已经是+1过了
            while (++i <= hi && nums[i] < v);
            //从头部开始找，第一轮找到第一个比nums[lo]大的，后面就是找比nums[i]大的

            while (--j >= lo && nums[j] > v);
            //从尾部开始找，第一轮找到第一个比nums[lo]小的，后面就是找比nums[i]小的

            if (i >= j) {//这样就是ij还能再判断，这样里面换
                break;
            }
            int t = nums[j];
            nums[j] = nums[i];
            nums[i] = t;
        }
        nums[lo] = nums[j];//i~j里面最小的和第一个换
        nums[j] = v;
        return j;
    }
}
