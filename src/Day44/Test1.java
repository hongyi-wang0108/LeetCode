package Day44;

public class Test1 {
    public static void main(String[] args) {

    }
    int res = 0;
    public int sumNums(int n){
        //时间复杂度 O(n)O(n) ： 计算 n + (n-1) + ... + 2 + 1需要开启 n 个递归函数。
        //空间复杂度 O(n)O(n) ： 递归深度达到 nn ，系统使用 O(n)O(n) 大小的额外空间。
        boolean x =  n > 1 && sumNums(n-1) > 0;//现在要进行B，所以A要为T
        // 短路规则
        // A&&B 与 A为f 不会进行B
        // A||B 或 A为T 不会进行B
        res+= n;
        return res;
    }
}
