import java.util.*;
public class build{
    static class node{
        int data;
        node left;
        node right;
        node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
        public static node insert(node root, int val){
            if(root==null){
                root=new node(val);
                return root;
            }
        
            if(root.data>val){
                root.left=insert(root.left,val);
            }else{
               
                    root.right=insert(root.right, val);
                }
            
            return root;   
    }
    public static void inorder(node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.println(root.data+"");
        inorder(root.right);
    }
    public static boolean search(node root,int key){
        if(root==null){
            return false;
        }
        if(root.data==key){
            return true;
        }
        if(root.data>key){
            return search(root.left,key);
        }
        else{
            return search(root.right,key);
        }
    }
    public static node delete(node root, int val){
        if(root.data<val){
            root.right=delete(root.right,val);
        }
        else if(root.data>val){
            root.left=delete(root.left,val);
        }
        else{
            if(root.left==null&& root.right==null){
                return null;
            }
            if(root.left==null){
                return root.right;
            }
            else if(root.right==null){
                return root.left;
            }
           node IS= findInordersuccessor(root.right);
           root.data=IS.data;
           root.right=delete(root.right,IS.data);
        }
        return root;
    }
    public static node findInordersuccessor(node root){
        while(root.left !=null){
            root=root.left;
        }
        return root;
    }
    public static void  printinrange( node root,int k1,int k2){
        if(root==null){
            return;
        }
        if(root.data>=k1 && root.data<=k2){
            printinrange(root.left,k1,k2);
            System.out.print(root.data+"");
            printinrange(root.right,k1,k2);
        }else if(root.data<k1){
            printinrange(root.left,k1,k2);

        }else{
            printinrange(root.right,k1,k2);
        }
    }
    public static void printpath(ArrayList<Integer>path){
        for(int i=0; i<path.size();i++){
            System.out.print(path.get(i)+"->");
        }
        System.out.println();
    }
    public static void printroot2leaf(node root,ArrayList<Integer>path){
        if(root==null){
            return;
        }
        path.add(root.data);
        if(root.left==null && root.right==null){
            printpath(path);
        }
        printroot2leaf(root.left,path);
        printroot2leaf(root.right,path);
         path.remove(path.size()-1);

    }
    
    public static void main(String[]args){
        int values[]={8,5,3,1,4,6,10,11,14};
        node root=null;
        for(int i=0; i<values.length;i++){
            root=insert(root,values[i]);
            
        }
        inorder(root);
        System.out.println();
        if(search(root,1)){
            System.out.println("found");
        }else{
            System.out.println("Not found");

        }
       
        System.out.println();
        root=delete(root,10);
        System.out.println();
        inorder(root);
        printinrange(root,5,12);
        printroot2leaf(root,new ArrayList<>());
    }
   
}
