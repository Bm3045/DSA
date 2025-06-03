public class decimal_to_binary {
    public static void dectobin(int n){
        int mynum=0;
        int binnum=0;
        int pow=0;
        while(n>0){
            int rem=n%2;
            binnum=binnum+(rem*(int)Math.pow(10,pow));
            pow++;
            n=n/2;
        }
        System.out.println("BINARY FROM OF"+ mynum +"="+binnum);
        

        }
        public static void main(String[]args){
            dectobin(15);
        }
    }
    

