import java.util.*;
public class BFS{
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
    public static void bfs(ArrayList<edge>[]graph){//O(n)
        Queue<Integer>q=new LinkedList<>();
        boolean vis[] =new boolean[graph.length];
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
    public static void dfs(ArrayList<edge>[]graph,int curr,boolean vis[]){
        System.out.print(curr+" ");
        vis[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            edge e=graph[curr].get(i);
            if(!vis[e.dest]){
                dfs(graph, e.dest, vis);
               
            }
        }
    }
    public static boolean haspath(ArrayList<edge>[]graph,int scr,int dest,boolean vis[]){
        if(scr==dest){
            return true;
        }
        for(int i=0;i<graph[scr].size();i++){
            edge e=graph[scr].get(i);
            if(!vis[e.dest]&& haspath(graph,e.dest,dest,vis)){
                return true;
            }
        }
        return false;
    }
    
    public static void main(String[]args){
        int V=7;
        ArrayList<edge>graph[]=new ArrayList[V];
       // creategraph(graph);
       // bfs(graph);
      //dfs(graph,0,new boolean[v]);
        System.out.println(haspath(graph,0,7,new boolean[V]));
        

    }
}
