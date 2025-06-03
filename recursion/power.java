public class power {
    public static int powerx(int x, int n){
        if(n==0){
            return 1;
        }
        int xnm1=powerx(x,n-1);
        int xn=x*xnm1;
        return xn;
    }
    public static void main(String[]args){
        System.out.println(powerx(2,10));
    }
    
}
