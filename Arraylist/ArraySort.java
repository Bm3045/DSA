import java.util.*;
public class ArraySort {
    public static void main(String[]args){
        ArrayList<Integer>list=new ArrayList<>();
        list.add(5);
        list.add(6);
        list.add(2);
        list.add(1);
        list.add(7);
        System.out.println();
        Collections.sort(list);
        System.out.println(list);
        //descending sorting
        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list);
    }
}

