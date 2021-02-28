package Day43;

public class Test2 {
    public static void main(String[] args) {

    }
    public int add(int a, int b) {
        //时间复杂度 O(1)O(1) ： 最差情况下（例如 a =a= 0x7fffffff , b = 1 时），
        // 需循环 32 次，使用 O(1)O(1) 时间；每轮中的常数次位操作使用 O(1)O(1) 时间。
        //空间复杂度 O(1)O(1) ： 使用常数大小的额外空间。
        while (b != 0 ){
            int c = (a & b) << 1;//c是进位
            a = a^b;//非进位和
            b = c;//b之后变为进位
        }
        return a;
    }
}
