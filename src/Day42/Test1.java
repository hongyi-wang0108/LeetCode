package Day42;

public class Test1 {
    public static void main(String[] args) {
        reverseLeftWords("abcdefg",2);//cdefg ab
    }
    public static String reverseLeftWords(String s, int n) {
        //时间复杂度 O(N)O(N) ： 其中 NN 为字符串 ss 的长度，字符串切片函数为线性时间复杂度（参考资料）；
        //空间复杂度 O(N)O(N) ： 两个字符串切片的总长度为 N
        return s.substring(n) + s.substring(0,n);
    }
}
