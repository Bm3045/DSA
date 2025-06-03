import java.util.ArrayList;
public class add{ 
    public static void main(String[]args){
        ArrayList<Integer>list=new ArrayList<>();

        list.add(1);//o(1)
        list.add(2);
        list.add(3);

        list.add(1,9);//o(n)
        System.out.println(list);

        //get operation
       // int element=list.get(2);
      //  System.out.println(element);

        //Delete 
      //  list.remove(2);
       // System.out.println(list);

        //set
        list.set(2,10);
        System.out.println(list);

        //contain
        System.out.println(list.contains(1));
        System.out.println(list.contains(5));

        System.out.println(list.size());

        //print the arraylist
        for(int i=0; i<list.size();i++){
            System.out.print(list.get(i)+" ");

        }
        System.out.println();
    }

}