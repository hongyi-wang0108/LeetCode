package Day2_26;

import java.util.Deque;
import java.util.LinkedList;


public class Test2 {
    public static void main(String[] args) {

    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        //时间复杂度 O(n)O(n) ： 其中 nn 为数组 numsnums 长度；线性遍历 numsnums 占用 O(N)O(N) ；每个元素最多仅入队和出队一次，因此单调队列 dequedeque 占用 O(2N)O(2N) 。
        //空间复杂度 O(k)O(k) ： 双端队列 dequedeque 中最多同时存储 kk 个元素（即窗口大小）。
        if(nums.length == 0 || k == 0) return new int[]{0};
        Deque<Integer> deque = new LinkedList<>();//双端有序链表
        int[] res = new int[nums.length - k + 1];//比如7个数字有7-3+1个最大值
        for (int i = 0; i < k; i++) {//没形成窗口
            while (!deque.isEmpty() && nums[i] > deque.peekLast())//把没形成窗口这几个数字与deque最后一个数字对比
                deque.removeLast();//把deque中比它小的都删了
            deque.addLast(nums[i]);//然后把自己加进去，加入到最后，因为可能有比它大的
        }
        res[0] = deque.peekFirst();//没形成窗口那三个数字其实是第一个窗口，把最大值加入res
        for (int i = k; i < nums.length; i++) {//可以变成窗口了，现在把第k个数字加入窗口，后面开始循环
            if(nums[i - k] == deque.peekFirst()){//如果这个区间外的数字是deque中最大的  这犯错了，res[i - k] == deque.peekFirst()
                deque.removeFirst();//就移走最大数字，去找新窗口中的最大值
            }
            while (!deque.isEmpty() && nums[i] > deque.peekLast())
                deque.removeLast();
            deque.addLast(nums[i]);
            res[i - k + 1] = deque.peekFirst();//i是从k开始的 但是res里面要从下标1开始
        }
        return res;
    }
}
