package Day1;

public class Test2 {
    public static void main(String[] args) {
        String s = "We are happy";
       // " " == "a"?
        System.out.println(replaceSpace(s));
        System.out.println(replaceSpace2(s));
    }
/*    请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
    示例 1：

    输入：s = "We are happy."
    输出："We%20are%20happy."*/
    public static  String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' '){
               sb.append("%20");
            }else{
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
    public static  String replaceSpace2(String s) {
        /*for (char c : s.toCharArray()) {

        }*/
        //first : 假如全是blank
        char[] src = new char[3*s.length()];
        int size = 0;
        for (char c : s.toCharArray()) {
            if(c == ' ') {
                src[size++] = '%';
                src[size++] = '2';
                src[size++] = '0';
            }else {
                src[size++] = c;
            }
        }
        return new String(src,0,size);
    }

    public static  String replaceSpace3(String s) {
        //先计算black，然后建立一个合适长度的char数组  时间换空间
        int cnt = 0;
        for (char c : s.toCharArray()) {
            if(c ==' ') cnt++;
        }
        char[] src = new char[s.length() + cnt * 2];
        int size = 0;
        for (char c : s.toCharArray()) {
            if(c == ' ') {
                src[size++] = '%';
                src[size++] = '2';
                src[size++] = '0';
            }else {
                src[size++] = c;
            }
        }
        return new String(src,0,size);
    }
}
