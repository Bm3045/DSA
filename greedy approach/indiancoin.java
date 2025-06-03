import  java.util.*;
public class indiancoin {
    public static void main(String[]args){
        Integer coins[]={1,2,5,10,20,50,100,200,500,1000,2000};

        Arrays.sort(coins, Comparator.reverseOrder());

        int countofcoins=0;
        int amount=800;
        ArrayList<Integer>ans=new ArrayList<>();
        for(int i=0;i<coins.length;i++){
            if(coins[i]<=amount){
                while(coins[i]<=amount){
                    countofcoins++;
                    ans.add(coins[i]);
                    amount -=coins[i];

                }
              
            }
          
        }
        System.out.println("total amount are pay ="+countofcoins);
        for(int i=0;i<ans.size();i++){
            System.out.println(ans.get(i)+"");


        }
        System.out.println();

    }
    
}
