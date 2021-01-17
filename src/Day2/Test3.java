//package Day2;

import java.util.*;


public class Test3 {

    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        String zwork = a.nextLine();
        String wwork = a.nextLine();
        Map<String,Integer> mapz = new HashMap<>();
        getMap(zwork, mapz);//得到map bj 6,hz 2,qd 4,nj 5,wh 3
       /* StringBuilder s = new StringBuilder();
        int i = 2;
        while (i < zwork.length()){
            if(zwork.charAt(i) == ','){
                i++;
            }else{
                if(zwork.charAt(i) != ' ' ){
                    s.append(zwork.charAt(i));
                }else{
                    if (mapz.containsKey(s.toString())){
                        mapz.put(s.toString(),mapz.get(s.toString())+Integer.valueOf(zwork.charAt(i+1)) -51+3);
                    }else {
                        mapz.put(s.toString(), Integer.valueOf(zwork.charAt(i+1)) -51+3);
                        s = new StringBuilder();
                        i++;
                    }
                }
                i++;
            }
        }*/


        Map<String,Integer> mapw = new HashMap<>();
       // getMap(wwork, mapw);//得到map hn 7,xm 6,bj 4,gz 6,wh 4
         /*int[] arr = new int[integerSet.size()];
        int i = 0;
        for (Integer integer : integerSet) {
            System.out.println(integer);
            arr[arr.length-1-i] = integer;
            i++;
        }
        return arr;*/
        StringBuilder end = new StringBuilder("  ");
        for (String s : mapw.keySet()) {//z:bj 6,w:wh 4
            if(mapz.containsKey(s)){
                int wvalue = mapw.get(s);
                int zvalue = mapz.get(s);
                if(wvalue > zvalue){
                    //w 去这个地方多
                    end.append( s + " " + wvalue);
                }else {
                    end.append(  s + " " + zvalue);
                }
                end.append(",");
            }
        }
        end.delete(end.length()-1,end.length());//delete 最后一个逗号

        Map<String,Integer> endmap = new HashMap<>();//将无序的去过的地点排序
        getMap(end.toString(),endmap);
        List<String> newendlist = sortMap(endmap);

        StringBuilder answer = new StringBuilder();
        for (String s : newendlist) {
            if(mapw.get(s) > mapz.get(s)){//z:bj 6,w:wh 4
                answer.append("w:" + s + " " + mapw.get(s));
            }else {
                answer.append("z:" + s + " " + mapz.get(s));
            }
            answer.append(",");
        }
        answer.deleteCharAt(answer.lastIndexOf(","));
        if(answer.length() == 0){
            System.out.println("none");
        }else
            System.out.println(answer);//z:bj 6,w:wh 4

    }

    private static List<String>  sortMap(Map<String, Integer> mapz) {
        List<String> newlist = new ArrayList<>();
        Collection<String> keyset= mapz.keySet();
        List list=new ArrayList<>(keyset);
        Collections.sort(list);
        for(int i=0;i<list.size();i++){
            newlist.add(list.get(i)+"");
        }
        return newlist;
    }

    private static void getMap(String zwork, Map<String, Integer> mapz) {
        StringBuilder s = new StringBuilder();
        int i = 2;
        while (i < zwork.length()){
            if(zwork.charAt(i) == ','){
                i++;
            }else{
                if(zwork.charAt(i) != ' ' ){
                    s.append(zwork.charAt(i));
                }else{
                    if (mapz.containsKey(s.toString())){
                        mapz.put(s.toString(),mapz.get(s.toString())+Integer.valueOf(zwork.charAt(i+1)) -51+3);
                    }else {
                        mapz.put(s.toString(), Integer.valueOf(zwork.charAt(i+1)) -51+3);
                        s = new StringBuilder();
                        i++;
                    }
                }
                i++;
            }
        }
    }
}
class CQqueue {
    /**
     * Your CQueue object will be instantiated and called as such:
     * CQueue obj = new CQueue();
     * obj.appendTail(value);
     * int param_2 = obj.deleteHead();
     */
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    int value;
    public CQqueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    /*public void appendTail(int value) {
        if(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        stack1.push(value);
    }

    public int deleteHead() {
        if(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }*/
    public void appendTail(int value) {//优化版

        stack1.push(value);
    }

    public int deleteHead() {
        if(stack2.isEmpty()) {
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        if(stack2.isEmpty()){
            return -1;
        }
        return stack2.pop();
    }
}
