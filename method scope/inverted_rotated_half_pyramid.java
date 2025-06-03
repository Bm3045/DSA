public class inverted_rotated_half_pyramid {
    public static void haf_pyramid(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n-i;j++){
                System.out.println("");
            }
            for(int j=1;j<=1;j++){
                System.out.println("*");
            }
            System.out.print("");
        }
    }
    public static void main(String[]args){
        haf_pyramid(4);
    }
    
}
