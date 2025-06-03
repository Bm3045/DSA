public class subarrays {
    public static void sub(int numbers[]){
        for(int i=0;i<numbers.length;i++);
        int start=0;
        for(int j=0;j<numbers.length;j++){
            int end=j;
            for(int k=start;k<=end;k++){
                System.out.println(numbers[k]+"");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void main(String[]args){
        int numbers[]={2,4,6,8,10};
        sub(numbers);
    }
    
}
