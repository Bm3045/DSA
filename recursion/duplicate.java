public class duplicate {
    public static void duplicateremove(String str,int idx , StringBuilder Newstr,boolean map[]){
        if(idx==str.length()){
            System.out.println(Newstr);
            return;
        }
    
        char currChar=str.charAt(idx);
        if(map[currChar-'a']==true){
            duplicateremove(str, idx+1, Newstr, map);
        }else{
            if(map[currChar-'a']==true){
                duplicateremove(str, idx+1, Newstr.append(currChar), map);
                
            }
        }
        }
        
       
       public static void main(String[]args){
        String str ="bhavesh";
        duplicateremove(str, 0, new StringBuilder(""),new boolean[26]);
        
       
    }
}
    

