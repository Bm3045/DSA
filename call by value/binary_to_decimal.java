public class binary_to_decimal {
    public static void bintodic(int BinDic){
        int pow=0;
        int decnum=0; int mynum=0;
        while(BinDic>0){
            int lastDigit=BinDic%10;
            decnum=(int) (decnum+(lastDigit *  Math.pow(2,pow)));
            pow++;
            BinDic=BinDic/10;
        }
        System.out.println("decnum of"+mynum+decnum);
    }
    public static void main(String[]args){
        bintodic(15);
        
    }
    
}
