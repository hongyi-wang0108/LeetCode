package Day43;



import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Test1 {
    public static void main(String[] args) {
        Test1 test1 = new Test1();
        test1.permutation("abc");
    }
    //时间复杂度 O(N!)： N 为字符串 s 的长度；时间复杂度和字符串排列的方案数成线性关系，
    //              方案数为N×(N−1)×(N−2)…×2×1 ，因此复杂度为 O(N!)O(N!) 。
    //空间复杂度 O(N^2) ： 全排列的递归深度为 N ，系统累计使用栈空间大小为 O(N) ；
    //     递归中辅助 Set 累计存储的字符数量最多为 N + (N-1) + ... + 2 + 1 = (N+1)N/2N+(N−1)+...+2+1=(N+1)N/2 ，
    //     即占用 O(N^2)的额外空间。
    List<String> list  = new LinkedList<>();//记得初始化
    char[] arr ;
    public String[] permutation(String s){
        arr = s.toCharArray();
        dfs(0);
        return list.toArray(new String[list.size()]);
    }

    private void dfs(int x) {
        if(x == arr.length-1) {//固定到最后一位了，直接添加最后一位 并返回
            list.add(String.valueOf(arr));
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = x; i < arr.length; i++) {
            if(set.contains(arr[i]))//为了一层中防止有重复数字
                continue;
            set.add(arr[i]);
            swap(i,x);//把arr第i位放到x上，
            //假如x是0，那就是把a，b，c依次固定0位 就是依次把arr中数字放入这一层

            dfs(x+1);//准备固定下一位
            swap(i,x);//这是恢复交换，恢复成最开始的样子，便于开始固定下一位是不会错乱
        }
    }

    private void swap(int i, int x) {
        char temp = arr[i];
        arr[i] = arr[x];
        arr[x] = temp;
    }









    /*List<String> res = new LinkedList<>();
    char[] c;

    public String[] permutation(String s) {
        c = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }
    void dfs(int x) {
        if(x == c.length - 1) {
            res.add(String.valueOf(c)); // 添加排列方案
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for(int i = x; i < c.length; i++) {
            if(set.contains(c[i]))
                continue; // 重复，因此剪枝
            set.add(c[i]);

            swap(i, x); // 交换，将 c[i] 固定在第 x 位
            dfs(x + 1); // 开启固定第 x + 1 位字符
            swap(i, x); // 恢复交换
        }
    }
    void swap(int a, int b) {
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }*/
}
