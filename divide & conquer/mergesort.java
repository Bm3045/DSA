

public class mergesort{
    public static void printarr(int arr[]){
        for(int i=0; i<arr.length;i++){
            System.out.println(arr[i]+"");
        }
        System.out.println();
    }
    public static void merge(int arr[],int si, int ei){
        if(si>=ei){
            return;
        }
        int mid=si+(ei-si)/2;
        merge(arr,si,mid);
        merge(arr,mid+1,ei);
        mer(arr,si,mid,ei);
    }
    public static void mer(int arr[],int si, int mid, int ei){
        int temp[]=new int[ei-si+1];
        int i =si;
        int j=mid+1;
        int k=0;
        while(i<=mid && j<=ei){
            if(arr[i]<arr[j]){
                temp[k]=arr[i];
                i++;;
            }else{
                temp[k]=arr[j];
                j++;;
            }
            k++;
        }
        while(i<=mid){
            temp[k+1]=arr[i++];
        }
        while(j<=ei){
            temp[k+1]=arr[j++];
        }
        for(k=0,i=si;k<temp.length;k++,i++){
            arr[i]=temp[k];
        }
    }
    public static void main(String[]args){
        int arr[]={6,3,9,5,2,8};
        merge(arr,0,arr.length-1);
        printarr(arr);
    }
}