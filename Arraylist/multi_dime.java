import java.util.*;
public class multi_dime {
    public static void main(String[]args){
        ArrayList<ArrayList<Integer>>mainList=new ArrayList<>();
        ArrayList<Integer>list=new ArrayList<>();
        list.add(1);
        list.add(2);
        mainList.add(list);
        ArrayList<Integer>list2=new ArrayList<>();
        list.add(3);
        list.add(4);
        mainList.add(list2);

        for(int i=0;i<mainList.size();i++){
            ArrayList<Integer>Currlist=mainList.get(i);
            for(int j=0; j<Currlist.size();j++){
                System.out.println(Currlist.get(j)+"");
            }
            System.out.println();
        }
    }
    
}
