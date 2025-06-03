import java.util.*;

public class height {
    static class node{
        int data;
        node left, right;
        public node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    public static int height(node root){
        if(root==null){
            return 0;
        }
        int lh=height(root.left);
        int rh=height(root.right);
        return Math.max(lh,rh)+1;
    }
    public static int count(node root){
        if(root==null){
            return 0;
        }
        int leftcount=count(root.left);
        int rightcount=count(root.right);
        return leftcount+rightcount+1;
    }
    public static int sum(node root){
        if(root==null){
            return 0;
        }
        int leftsum=sum(root.left);
        int rightsum=sum(root.right);
        return leftsum+rightsum+root.data;
    }
    public static int diameter(node root){
        if(root==null){
            return 0;
        }
        int leftdiam=diameter(root.left);
        int leftht=height(root.left);
        int rightdiam=diameter(root.right);
        int rightht=height(root.right);

        int selfdiam=leftht+rightht+1;

       return Math.max(selfdiam,Math.max(leftdiam,rightdiam));
    }
    static class Info{
        int diam;
        int ht;
        public Info(int diam,int ht){
            this.diam=diam;
            this.ht=ht;
        }
    }
    public static Info diameter1(node root){
        if(root==null){
            return new Info(0,0);
        }

        Info leftInfo=diameter1(root.left);
        Info rightInfo=diameter1(root.right);
        int diam=Math.max(Math.max(leftInfo.diam,rightInfo.diam),leftInfo.ht=rightInfo.ht+1);
        int ht=Math.max(leftInfo.ht,rightInfo.ht)+1;
        return new Info(diam,ht);

    }
    public static boolean isIdentical(node node,node subroot){
        if(node==null && subroot==null){
            return true;
        }else if(node==null || subroot==null || node.data !=subroot.data){
            return false;

        }
        if(!isIdentical(node.left,subroot.left)){
            return false;

        }
        if(!isIdentical(node.right,subroot.right)){
            return false;
        }
        return true;
         
    }
     
      
      public static boolean issubtree(node root,node subroot){
        if(root==null){
            return false;
        }
        if(root.data==subroot.data){
            if(isIdentical(root,subroot)){
                return true;
            }
        }
        boolean leftAns=issubtree(root.left,subroot);
        boolean rightans=issubtree(root.right,subroot);
        return leftAns || rightans;
      }
      static class info{
        node node;
        int hd;
        public info(node node,int hd){
            this.node=node;
            this.hd=hd;
        }

      }
      public static void topview(node root ){
        //level order
        Queue<info>q=new LinkedList<>();
        HashMap<Integer,node>map=new HashMap<>();

        int min=0, max=0;
        q.add(new info(root,0));
        q.add(null);

        while(!q.isEmpty()){
            info curr=q.remove();
            if(curr==null){
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{

            if(!map.containsKey(curr.hd)){
                map.put(curr.hd,curr.node);
            }
            if(curr.node.left!=null){
                q.add(new info(curr.node.left,curr.hd-1));
                min=Math.min(min,curr.hd-1);

            }
            if(curr.node.right!=null){
                q.add(new info(curr.node.right,curr.hd+1));
                max=Math.max(max,curr.hd+1);
            
        }
    }
}

        for(int i=min;i<=max;i++){
            System.out.println(map.get(i).data+"");
        }
        System.out.println();
      }
      public static void klevel(node root,int level,int k){
        if(root==null){
            return;
        }
        if(level==k){
            System.out.print(root.data+"  ");
            return;

        }
        klevel(root.left,level+1,k);
        klevel(root.right,level+1,k);
      }
      public static boolean getpath(node root,int n, ArrayList<node>path){
        if(root==null){
            return false;
        }
        path.add(root);
        if(root.data==0){
            return true;
        }
        boolean left=getpath(root.left,n,path);
        boolean right=getpath(root.right,n,path);
        if(left || right){
            return true;

        }
        path.remove(path.size()-1);
        return false;

      }
      public static node lca(node root,int n1,int n2){
        ArrayList<node>path1=new ArrayList<>();
        ArrayList<node>path2=new ArrayList<>();

        getpath(root,n1,path1);
        getpath(root,n2,path2);


        int i= 0;
        for(; i<path1.size() &&i< path2.size();i++){
            if(path1.get(i)!=path2.get(i)){
                break;

            }
        }
        node lca=path1.get(i-1);
        return lca;
      }
    
    
    
    public static void main(String[]ages){
        node root=new node(1);
        root.left=new node(2);
        root.right=new node(3);
        root.left.left=new node(4);
        root.left.right=new node(5);
        root.right.left=new node(6);
        root.right.right=new node(7);
        System.out.println(height(root));
        //System.out.println(count(root));
        //System.out.println(sum(root));
        //System.out.println(diameter(root));
        //System.out.println(diameter1(root).diam);

        node subroot=new node(2);
        subroot.left=new node(4);
        subroot.right=new node(5);
        //System.out.println(issubtree(root, subroot));
       // topview(root);
      // int k=2;
       // klevel(root,1,k);
       int n1=4, n2=5;
       System.out.println(lca(root, n1, n2).data);

      


    }
    
}
