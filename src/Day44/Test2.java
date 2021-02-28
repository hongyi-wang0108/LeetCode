package Day44;

public class Test2 {
    public static void main(String[] args) {

    }
//    "the sky is blue"
//    输出: "blue is sky the"
    public String reverseWords(String s) {
        //时间复杂度 O(N)O(N) ： 总体为线性时间复杂度，各函数时间复杂度和参考资料链接如下。
        //split() 方法： 为 O(N)O(N) ；
        //trim() 和 strip() 方法： 最差情况下（当字符串全为空格时），为 O(N)O(N) ；
        //join() 方法： 为 O(N)O(N) ；
        //reverse() 方法： 为 O(N)O(N) ；
        //空间复杂度 O(N)O(N) ： 单词列表 strsstrs 占用线性大小的额外空间
        String[] arr = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length-1; i >= 0; i--) {
            if(arr[i].equals(""))
                continue;
            sb.append(arr[i] + " ");
        }
        return sb.toString().trim();
    }
}
