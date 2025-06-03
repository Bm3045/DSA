import java.util.*;
public class iterationset {
    public static  void main (String[]args){
        HashSet<String>cities=new HashSet<>();
        cities.add("mumbai");
        cities.add("nagpur");
        cities.add("dehli");
        cities.add("kolkata");
        //Iterator it =cities.iterator();
        //while(it.hasNext()){
          //  System.out.println(it.next());
       // }
       for(String city:cities){
        System.out.println(city);
       }

    }
    
}
