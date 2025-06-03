public class prefixsum {
    public static void max(int number[]){
        int currsum=0;
        int maxsum=Integer.MAX_VALUE;
        int prefix[]=new int[number.length];
        prefix[0]=number[0];
        for(int i=0;i<number.length;i++){
            prefix[i]=prefix[i-1]+number[i];
        }
        for(int i=0;i<number.length;i++){
            int start=0;
            for(int j=0;j<number.length;j++){
                int end=j;
                currsum=start==0? prefix[end]:prefix[end]-prefix[start-1];
                if(maxsum<currsum){
                    maxsum=currsum;
                }
            }
        }
        System.out.println("max sum="+maxsum);

    }
    public static void main(String[]args){
        int number[]={2,4,6,8,10};
        max(number);
    }
    
}
