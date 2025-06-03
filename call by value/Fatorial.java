public class Fatorial {
    public static int Fatorial (int n){
        int f=1;
        for(int i=1;i<=n;i++){
            f*=i;
        }
        return f;

    }
    public static void main(String[]args){
        System.out.println("factorial of 5 is: "+Fatorial(5));
    }

    }

