package dsa_practice_questions;


import java.util.*;
@SuppressWarnings("unchecked") // suppress the warning of unchecked cast
public class graph_data_structure
{
    
    static class edge
    { 
        int scr;
        int des;
       int wt; // for weighted graph uncomment this line
        public edge(int scr,int des,int wt)
        {
            this.wt = wt;
            this.scr = scr;
            this.des=des;
        }
    }

    static void create_graph(ArrayList<edge> graph[])
    {
        for(int i=0;i<graph.length;i++)
        {
            graph[i] = new ArrayList<edge>();   
        }
            graph[0].add(new edge(0, 1, 1)); 
            graph[0].add(new edge(0, 2, 1));
            
            graph[1].add(new edge(1, 0, 1));
            graph[1].add(new edge(1, 3, 1));
            
            graph[2].add(new edge(2, 0, 1));
            graph[2].add(new edge(2, 4, 1));
            
            graph[3].add(new edge(3, 1, 1));
            graph[3].add(new edge(3, 4, 1)); 
            graph[3].add(new edge(3, 5, 1));
            
            graph[4].add(new edge(4, 2, 1));
            graph[4].add(new edge(4, 3, 1));
            graph[4].add(new edge(4, 5, 1));
            
            graph[5].add(new edge(5, 3, 1));
            graph[5].add(new edge(5, 4, 1));
            graph[5].add(new edge(5, 6, 1));
            graph[5].add(new edge(6, 5, 1));

    }
    
    static void bfs_graph(ArrayList<edge> graph[], int v,boolean []visited)
    {
        Queue<Integer> q = new LinkedList<Integer>();

        q.add(0); // adding source = 0

        while(!q.isEmpty())
        {
            int curr = q.remove();
            if(!visited[curr]){

                System.out.print(curr + " ");
                visited[curr] = true;

                for(int j=0;j<graph[curr].size();j++){
                    edge e = graph[curr].get(j);
                    q.add(e.des);   
                }
            }
        }
        System.out.println();       
    }

    public static void dfs(ArrayList<edge> graph[], int curr,boolean visited[]){
        // boolean visited[] = new boolean[v];
        System.out.print(curr+ " ");
        visited[curr] = true;
        for(int i=0;i<graph[curr].size();i++){
            edge e= graph[curr].get(i);
            if(!visited[e.des])
                dfs(graph,e.des,visited);
        }
    }

    public static void paths(ArrayList<edge> graph[], int src,boolean visited[],int tar, String data)
    {

        if(src == tar)
        {
            System.out.println(data);
            return;
        }
 
        for(int i=0;i<graph[src].size();i++){

            edge e= graph[src].get(i);
            
            if(!visited[e.des])
            {
                visited[e.des] = true;
                paths(graph, e.des, visited, tar, data+" -> "+e.des);
                visited[e.des] = false;
            }
        }
    }

 
    static void print_neighbour(ArrayList<edge> graph[])
    {
        for(int i=0;i<graph.length;i++)
        {
            System.out.print("Neighbour of " + i + ": ");
            for(int j=0;j<graph[i].size();j++)
            {
                edge e = graph[i].get(j);
                System.out.print(e.des + " -> ");
            }
            System.out.println("null");
        }
    }

    

    public static void main(String args[]){
        int v = 7;
        ArrayList<edge> graph[] = new ArrayList[v];
        boolean visited[] = new boolean[v];
        create_graph(graph);


        /*
                1 ----- 3 
              /         | \
             0          |  5 -- 6       // the graph   
              \         | /
               2 ------ 4 
                 
        */


        // print_neighbour(graph);

        // System.out.print("\nBFS:\t");
        // bfs(graph,v,visited);

        // System.out.print("\nDFS:\t");
        // dfs(graph,0,visited);

        // all_paths(graph, 0, 5, data,visited_path);
        // String data2;
        visited[0] = true;
        paths(graph,0,visited, 5, "0");
        
        
    }
    
}
