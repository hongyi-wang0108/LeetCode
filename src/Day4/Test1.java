package Day4;

public class Test1 {
    public static void main(String[] args) {
        int[] arr = {6 ,1,3,4};
        int a = minArray(arr);
        int a2 = minArray2(arr);
        System.out.println(a);
        System.out.println(a2);
    }
    public static  int minArray(int[] numbers) {//3 5 6 1    1 3 5 6
        if(numbers.length == 1) return numbers[0 ];
        for (int i = 1; i < numbers.length; i++) {
            if(numbers[i-1] > numbers[i]) {
                return numbers[i ];
            }
            if(i == numbers.length-1){
                return numbers[0];
            }
        }
        return -1;
    }
    public static  int minArray2(int[] n) {//3 0 1 2    1 3 5 6
        int left = 0;
        int right = n.length-1;
       //0+3/2 1
        while(left <= right){
            int mid = left + (right - left) / 2;
           // if(right == 0) return  n[0];       // 6 1 3 4  0 1
            if(n[mid] >n[right] ){// 3 4  5 1  2
                left = mid + 1;
            }else if(n[mid] < n[right]){//8 9 5 6   7
                right = mid ;
            }else if(n[mid] == n[right]){
                right--;
            }
        }
        return n[left];
    }
}
