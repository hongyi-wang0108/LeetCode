package Day34;

public class Test2 {
    public static void main(String[] args) {

    }
    public int[] singleNumbers(int[] nums) {
        //时间复杂度是O(n)，空间复杂度是O(1)。
        //1 先找出两个不一样的数的异或结果k 1^2^3^1 = 2^3 相同的抵消掉了
        //2 找出结果k中最低位为1的地方，因为两个不同的数，异或结果后至少一位数为1，如果都是0（异或时相同为0）那不就是一样了
        //3 找出来最低的值为1位的位置后，遍历所有数，分为两组，两组中肯定都是：全是相同的数+一个不同的数，
        //  因为相同的数对一个数&结果都一样，所以组里肯定是相同的数
        //  一个不同的数是 因为通过k找出的最低位，把两个不同的数分到了两个组中
        //4 组内进行异或，相同数字异或为0，所以x ^ 0 = x，所以最后这个结果就是不同的数字
        int k = 0;
        for (int num : nums) {
            k ^= num;//1 得出两个不一样的数的异或结果k 1^2^3^1 = 2^3 相同的抵消掉了
        }
        int mask = 1;
        while ((k&mask) == 0){//找最低位是1得那一位 当那一位是1的时候跳出 不满足条件时跳出
            mask<<=1;//因为k中这一位不是1，所以0001 左移1位变 0010
        }
        int a = 0,b = 0;//a，b可以代表两组  不用数组得原因是 减少空间复杂度，因为ab只涉及结果异或
        for (int num : nums) {
            if((num&mask)==0){//把唯一不同的两个数，分到两组
                a ^= num;
            }else {
                b ^= num;
            }
        }
        return new int[]{a,b};
    }
}
