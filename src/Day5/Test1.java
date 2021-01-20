package Day5;

public class Test1 {
    public static void main(String[] args) {
        int[] arr = printNumbers(1);
        System.out.println(printNumbers2(2));
    }
    public static int[] printNumbers(int n) {//1 9 2 99 3 999  n*10-1
        //Math.pow(10,n);
        int[] arr = new int[(int)((Math.pow(10,n))-1)];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i+1;
        }
        return arr;
    }




    public static String printNumbers2(int n) {
        char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        int count = 0;
        StringBuilder res = new StringBuilder(); // 数字字符串集
        num = new char[n]; // 定义长度为 n 的字符列表
        dfs(0,n,res,num,loop); // 开启全排列递归
        res.deleteCharAt(res.length() - 1); // 删除最后多余的逗号
        return res.toString(); // 转化为字符串并返回
    }
    public static void dfs(int x,int n,StringBuilder res,char[] num,char[] loop) {
        if(x == n){
            res.append(String.valueOf(num) + ",");
            return;
        }
        for (char c : loop) {
            num[x] = c;
            dfs(x+1,n,res,num,loop);
        }
/*        if(x == n) {
            res.append(String.valueOf(num) + ",");
            return;
        }// 遍历 ‘0‘ - ’9‘
        for(char i : loop) {
            // 固定第 x 位为 i
            num[x] = i;
            // 开启固定第 x + 1 位
            dfs(x + 1,n,res,num,loop);
        }*/
    }
}
