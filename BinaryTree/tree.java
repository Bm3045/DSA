import java.util.*;
public class tree{
    static class node{
        int data;
        node left;
        node right;
        node(int data){
            this.data=data;
            this.left = null;
            this.right= null;
        }

        
            }
            static class binarytree{
                static int idx=-1;
                public static node buildtree(int nodes[]){
                    idx++;
                    if(nodes[idx]==-1){
                        return null;
                    }
                    node newnode=new node(nodes[idx]);
                    newnode.left=buildtree(nodes);
                    newnode.right =buildtree(nodes);
                    return newnode;
    
        }
        public static void preorder(node root){
            if(root ==null){
                return;

            }
            System.out.print(root.data+"");
            preorder(root.left);
            preorder(root.right);
            

        }
        public static void inorder(node root){
            if(root==null){
                return;
            }
            inorder(root.left);
            System.out.println(root.data+"");
            inorder(root.right);
        }
        public static void postorder(node root){
            if(root==null){
                return;
            }
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data+"");
        }
        //levelorder order travelar
        public static void levelorder(node root){
            if(root==null){
                return;
            }
            Queue<node>q=new LinkedList<>();
            q.add(root);
            q.add(null);

            while(!q.isEmpty()){
                node currNode =q.remove();
                if(currNode==null){
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    }else{
                        q.add(null);
                    }
                }else{
                    System.out.print(currNode.data+"");
                    if(currNode.left !=null){
                        q.add(currNode.left);
                    }
                    if(currNode.right !=null){
                        q.add(currNode.right);
                    }
                }
            }
        }
        
    }
    public static void main(String[]args){
        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        binarytree tree=new binarytree();
        node root=tree.buildtree(nodes);
        System.out.println(root.data);
        //tree.preorder(root);
        //tree.inorder(root);
        //tree.postorder(root);
        tree.levelorder(root);

    }
}