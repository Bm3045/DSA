//import java.util.*;
public class Pairs {
    
    public static void print(int numbers[] ){
        for(int i=0;i<numbers.length;i++){
            int curr =numbers[i];
            for(int j=0;j<numbers.length;j++){
                System.out.println("("+ curr +","+numbers +")");
                        
                        
            }
           System.out.println(); 

        }
    }
    public static void main(String[]args){
        int numbers[]={2,4,6,8,10};
        print(numbers);
       
    }
    
}
