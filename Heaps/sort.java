import java.util.*;
public class sort {

    public static void heapify(int i,int size,int arr[]){
        int left=2*i+1;
        int right=2*i+2;
        int maxIdx=i;

        if(left<size && arr[left]>arr[maxIdx]){
            maxIdx=left;

        }
        if (right<size && arr[right] > arr[maxIdx]){
            maxIdx=right;
        }
        if(maxIdx !=i){
            int temp=arr[i];
            arr[i]=arr[maxIdx];
            arr[maxIdx]=temp;

            heapify(i,0,arr);
        }
    }
    public static void heapsort(int arr[]){
        //start1-build maxheap
        int n=arr.length;
        for(int i=n/2;i>0;i--){
            heapify(i,n,arr);
        }
//step2-push largest at end
        for(int i=n-1;i>0;i--){
            //swap
            int temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;

            heapify(0,1,arr);

      

        }
    }
    public static void main(String[]args){
        int arr[]={1,2,4,5,3};
        heapsort(arr);


        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+"  ");
        }
        System.out.println();

    }
    
}
