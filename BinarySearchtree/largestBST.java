public class largestBST {
  
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
    static class info{
        boolean isBST;
        int size;
        int min;
        int max;

        public info(boolean isBST,int size,int min,int max){
            this.isBST=isBST;
            this.size=size;
            this.min=min;
            this.max=max;
        }
    }
    public static int maxBST=0;
    public static info largestBST(node root){
        if(root==null){
            return new info(true,0,Integer.MAX_VALUE,Integer.MIN_VALUE);
        }
        info leftinfo= largestBST(root.left);
        info rightinfo=largestBST(root.right);
        int size=leftinfo.size+rightinfo.size;
        int min=Math.min(root.data,Math.min(leftinfo.min,rightinfo.min));
        int max=Math.max(root.data,Math.min(leftinfo.max,rightinfo.max));
        if(root.data<=leftinfo.max || root.data>=rightinfo.min){
            return new info(false,size,max,min);
        }
        if(leftinfo.isBST && rightinfo.isBST){
            maxBST=Math.max(maxBST,size);
            return new info(true,size,min,max);

        }
        return new info(false,size,min,max);



    }
    public static void main(String[]args){
       
            node root=new node(1);
            root.left=new node(2);
            root.right=new node(3);
            root.left.left=new node(4);
            root.left.right=new node(5);
            root.right.left=new node(6);
            root.right.right=new node(7);
            info info=largestBST(root);
            System.out.println("largest BST size="+maxBST);

    }
}