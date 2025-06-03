import java.util.*;
public class iteration {
    public static void main(String[]args){
        HashMap<String,Integer> hm=new HashMap<>();
        hm.put("Indian",100);
        hm.put("china",200);
        hm.put("japana",50);
        hm.put("us",75);
        System.out.println(hm);
         
        //iteration
         Set<String>Keys=hm.keySet();
         System.out.println(Keys);


         for (String k : Keys) {
            System.out.println("key="+k+"value"+hm.get(k));
            
         }


    }
    
}
