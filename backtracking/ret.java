public class ret{

public static void  printarr(int arr[],int val, int i){
    if(i==arr.length){
        printArr(arr);
        return;
    }
    //recursion
    arr[i]= val;
    printarr(arr, i+1, val+1);
    arr[i]=arr[i]- 2;

}
public static void printArr(int arr[]){
    for(int i=0; i<arr.length; i++){
        System.out.print(arr[i]+" ");
    }
    System.out.println();
}



    public static void main(String[]args){
        int arr[]=new int[5];
        printarr(arr,0,1);
        printArr(arr);
        
    }
}
    