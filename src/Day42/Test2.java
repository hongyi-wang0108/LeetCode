package Day42;

import java.util.HashMap;
import java.util.Map;

public class Test2 {
    public static void main(String[] args) {

    }
    public char firstUniqChar(String s) {
        //时间复杂度 O(N)O(N) ： NN 为字符串 s 的长度；需遍历 s 两轮，使用 O(N)O(N) ；
        //                      HashMap 查找操作的复杂度为 O(1)O(1) ；
        //空间复杂度 O(1)O(1) ： 由于题目指出 s 只包含小写字母，因此最多有 26 个不同字符，
        //                      HashMap 存储需占用 O(26) = O(1)O(26)=O(1) 的额外空间。
        if(s.length() == 0) return ' ';
        char[] arr = s.toCharArray();
        HashMap<Character,Boolean> map = new HashMap<>();//存过的val为true
        for (char c : arr) {//先设置key，与val 出现过的val为true 没出现过的为fales
            map.put(c,map.containsKey(c));
        }
        for (char c : arr) {//看谁的val为false
            if(!map.get(c)) return c;
        }
        return ' ';
    }
}
