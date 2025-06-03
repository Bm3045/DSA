public class binary {
    public static void binstring(int n,int lastplace,String string){
       if(n==0){
        System.out.println(string);
        return ;
       }
       binstring(n-1, 0, string+"0");
       if(lastplace==0){
        binstring(n-1, 1, string+"1");

       }

        }
        public static void main(String[]args){
            binstring(3, 0,"");
        }
    }
    

