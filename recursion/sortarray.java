public class sortarray {
    public static boolean issorted(int arr[],int i){
        if(i ==arr.length-1){
            return true;
        }
        if(arr[i]>arr[i+1]){
            return false;
        }
        return issorted(arr,i+1);
    }
    public static void main(String[]args){
        int arr[]={2,5,6};
        System.out.println(issorted(arr,0));
    }
    
}
