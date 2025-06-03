import java.util.*;
public class link{
    public static class node{
        int data;
        node next;

        public node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static node head;
    public static node tail;
    public static int size;

    public void addfirst(int data){
        node newnode=new node(data);
        size++;
        if(head==null){
            head=tail=newnode;
            return;
           
        }
        newnode.next=head;
        head=newnode;
    }
    public void addlast(int data){
        node newnode=new node(data);
        size++;
        if(head==null){
            head=tail=newnode;
            return;
        }
        tail=head=newnode;
        tail=newnode;

    }
    public void print(){
        if(head==null){
            System.out.println("linked is empty");
            return;
        }
        node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ->");
            temp=temp.next;
        }
        System.out.println();

    }
    public void add(int idx,int data){
        node newNode=new node(data);
        size++;
        node temp=head;
        int i=0;

        while(i<idx-1){
            temp=temp.next;
            i++;
            newNode.next=temp.next;
            temp.next=newNode;
        }
    }
    public int removefirst(){
        int val=head.data;
        head=head.next;
        return val;


    }
    public static void main(String[]args){ 
        link ll =new link();
        ll.print();
        ll.addfirst(1);
        ll.print();
        ll.addfirst(2);
        ll.print();
        ll.addlast(3);
        ll.print();
        ll.addlast(4);
        ll.print();
        System.out.println(ll.size);
        ll.removefirst();
        ll.print();
        
        

    }


}