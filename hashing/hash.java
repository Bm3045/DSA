import java.util.*;
public class hash{
    public static void main(String[]args){
        HashMap<String,Integer>hm=new HashMap<>();

        //insert
        hm.put("indian",100);
        hm.put("china",200);
        hm.put("us",50);

        System.out.println(hm);

        //get
        int population=hm.get("indian");
        System.out.println(population);

        //contain
        System.out.println(hm.containsKey("indian"));
        System.out.println(hm.containsKey("pak"));

        //remove
        System.out.println(hm.remove("china"));
        System.out.println(hm);

       

    }
}