public class fibonacci {
    public static int fab(int n){
        if(n==0 || n==1){
            return n;
        }
        int f1=fab(n-1);
        int f2=fab(n-2);
        int fn=f1+f2;
        return fn;
    }
    public static void main(String[]args){
        int n=6;
        System.out.println(fab(n));
    }
    
}
