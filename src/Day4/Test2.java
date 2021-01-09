package Day4;

public class Test2 {
    public static void main(String[] args) {
        System.out.println(hammingWeight(9));
    }
    public static int hammingWeight(int n) {// 9 00000000000000000000000000001011
        int count = 0;
        for (int i = 0; i < 32; i++) {//O(n)
            if (((n >>> i) & 1) == 1) {
                count++;
            }
        }
        return count;
    }
}
