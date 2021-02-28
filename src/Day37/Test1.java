package Day37;

public class Test1 {
    public static void main(String[] args) {

    }
    public int[] constructArr(int[] a) {
        //时间复杂度 O(N)O(N) ： 其中 NN 为数组长度，两轮遍历数组 aa ，使用 O(N)O(N) 时间。
        //空间复杂度 O(1)O(1) ： 变量 tmptmp 使用常数大小额外空间（数组 bb 作为返回值，不计入复杂度考虑）
        if(a.length == 0) return new int[]{};
        int[] b = new int[a.length];
        b[0] = 1;
        //从1 开始，因为1之前才有数，0之前没数字
        for (int i = 1; i < a.length; i++) {//计算b[i] 前面的数字，b[i] = a[0] * ... * a[i-1];
            b[i] = b[i-1] * a[i-1];//因为b[0] = 1;所以不用担心，这里算的就是a[0] * ... * a[i-1];
        }
        int temp = 1;
        //从i = a.length - 2开始是因为最后一个的后面没数字
        for (int i = a.length - 2; i >= 0; i--) {//后面的数字
            temp = temp * a[i+1];//temp = a[i+1]*...*a[最后一个]；
            b[i] = b[i] * temp;//b[i] = a[0] * ... * a[i-1];temp = a[i+1]*...*a[最后一个]；
        }
        return b;
    }
}
