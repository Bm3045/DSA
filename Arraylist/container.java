import java.util.*;
public class container {
    
    public static int storewater (ArrayList<Integer>height){
        int maxWater=0;
        //brute force 
        for(int i=0; i<height.size();i++){
            for(int j=i+1;j<height.size();j++){
                int ht =Math.min(height.get(i),height.get(j));
                int water=j-1;
                int currwater=ht*water;
                maxWater=Math.max(maxWater,currwater);
            }
            return maxWater;
        }
        return maxWater;
       
    }
    public static void main(String[]args){
        ArrayList<Integer>height=new ArrayList<>();
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);  height.add(5);  height.add(4);
        height.add(7); height.add(5);  height.add(7);
        System.out.println(storewater(height));
    }
    
}
