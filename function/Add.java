import java.util.Scanner;

public class Add{
    public static int calculateAdd(int num1,int num2){
        int Add=num1+num2;
return Add; 
    }   

public static void main(String[]args){
    Scanner sc = new Scanner (System.in);
    int a=sc.nextInt();
    int b=sc.nextInt();
   
    System.out.println("The sum of the two numbers is: "+ Add.calculateAdd(a,b));
}
}