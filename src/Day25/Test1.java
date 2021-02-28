package Day25;

public class Test1 {
    public static void main(String[] args) {
        int[] nums = {0,1,2,3,4};
       // System.out.println(lastRemaining(5,3));
        System.out.println(6.2/8);
    }
    //O(N)
    //O(1)
    public static int lastRemaining(int n, int m) {
        int pos = 0;
        //i是当前有多少个个数的下标，i=2是3个元素 0 1 2
        for (int i = 2; i <= n; i++) {//从2开始是因为前两轮跟后期规则不一样
            pos = (pos + m) % i;//往后移m位，然后求余i，是害怕溢出，取余完是可以放入头部，
        }
        return pos;
    }
}
