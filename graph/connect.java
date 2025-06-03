import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class connect {
    static class edge{
        int scr;
        int dest;
        int wt;

        public edge(int s,int d,int w){
            this.scr=s;
            this.dest=d;
            this.wt=w;
        }
    }
    static void creategraph(ArrayList<edge>graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new edge(0,1,1));
        graph[1].add(new edge(0,2,1));

        graph[1].add(new edge(1,0,1));
        graph[1].add(new edge(1,3,1));

        graph[2].add(new edge(2,0,1));
        graph[2].add(new edge(2,4,1));

        graph[3].add(new edge(3,1,1));
        graph[3].add(new edge(3,4,1));
        graph[3].add(new edge(3,5,1));

        graph[4].add(new edge(4,2,1));
        graph[4].add(new edge(4,3,1));
        graph[4].add(new edge(4,5,1));

        graph[5].add(new edge(5,3,1));
        graph[5].add(new edge(5,4,1));
        graph[5].add(new edge(5,6,1));
        graph[5].add(new edge(5,5,1));

    }
    public static void bfs(ArrayList<edge>[]graph ){
        boolean vis[] =new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                bfsutil(graph, vis);
            }
        }

    }
    public static void bfsutil(ArrayList<edge>[]graph, boolean[] vis){//O(n)
            Queue<Integer>q=new LinkedList<>();
           
            q.add(0);
            while(!q.isEmpty()){
                int curr=q.remove();
                 
                            if(!vis[curr]){
                System.out.println(curr+"");
                vis[curr]=true;
                for(int i=0;i<graph[curr].size();i++){
                    edge e=graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }

            
        }
        public static void main(String[]args){
            int V=7;
            ArrayList<edge>graph[]=new ArrayList[V];
           // creategraph(graph);
           // bfs(graph);
          //dfs(graph,0,new boolean[v]);
            
        }  }  
    
    

