package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class Traversal {
    public void bfs(Map<Integer,List<Integer>> graph){
        System.out.println("Bfs traversal");
        /* 
         * bfs explore the graph in layer fashon, it does by maintaining a queue (shortest path can found using this algo)
         * t=O(v+e)
         */
        //question (start,end)->(0,5) ->shortest distance
        int start=0;
        int end=2;
        //base case
        if(start==end){
            System.out.println("shortest distance b/w 0 to 2 -> 0");
            return;
        }
        int count=0;
        int[] visited= new int[6];
        Arrays.fill(visited, 0);
        
        Queue<Integer> qu=new LinkedList<>();
        qu.offer(start);
        visited[start]=1;
        count++;
        while(!qu.isEmpty()){
            int cur_vertex= qu.peek();
            qu.poll();
            for(int index:graph.get(cur_vertex)){
                if(index==end){
                    System.out.println("shortest distance b/w 0 to 2 -> "+count);
                    return;
                }
                if(visited[index]==1) continue;
                qu.offer(index);
                visited[index]=1;
            }
            count++;
        }
        System.out.println("shortest distance is - "+count);
    }

    public void dfs(Map<Integer,List<Integer>> graph){
        /*
         * t=O(v+e)
         * task like - count connected components, determine connectivity, or find bridges
         * updated dfs can use for :- Compute graph's MST, find cycle in graph, if a graph is bipartite, 
         * topological sort, generate mazes, find augmenting paths in a flow network.
         */
        System.out.println("Dfs traversal");
        //print the order of search
        int start=0;
        int[] visited=new int[6];
        Arrays.fill(visited, 0);
        dfshelp(graph,start,visited);
        System.out.println();
    }
    /**
     * @param graph
     * @param start
     * @param visited
     */
    void dfshelp(Map<Integer,List<Integer>> graph, int start,int[] visited){
        if(visited[start]==1){
            return;
        }
        System.out.print(" "+start);
        visited[start]=1;
        for(Integer ver:graph.get(start)){
            dfshelp(graph, ver, visited);
        }
    }

    public void cycledetection(Map<Integer,List<Integer>> graph){
        System.out.println("cycle-detection");
        
    }

    public void topologicalsort(){
        System.out.println("topological");
        // DAG, 1 to 10
        Map<Integer,List<Integer>> graph=new HashMap<>();
        graph.put(1, new ArrayList<Integer>(Arrays.asList(2,3,4)));
        graph.put(2, new ArrayList<Integer>(Arrays.asList(5,6)));
        graph.put(3, new ArrayList<Integer>(Arrays.asList(8)));
        graph.put(4, new ArrayList<Integer>(Arrays.asList(9)));
        graph.put(5, new ArrayList<Integer>(Arrays.asList(7)));
        graph.put(6, new ArrayList<Integer>(Arrays.asList(7)));
        graph.put(7, new ArrayList<Integer>(Arrays.asList(10)));
        graph.put(8, new ArrayList<Integer>(Arrays.asList(10)));
        graph.put(9, new ArrayList<Integer>(Arrays.asList(10)));
        graph.put(10, new ArrayList<Integer>(Arrays.asList()));


        //topological sort - starting node giving to us
        Stack<Integer> stack= new Stack<>();
        int[] visited= new int[11];
        Arrays.fill(visited,0);
        topodfs(graph,stack,1,visited);
        while(!stack.empty()){
            System.out.print(stack.peek()+" ");
            stack.pop();
        }
        System.out.println();
    }
    void topodfs(Map<Integer,List<Integer>> graph, Stack<Integer> stack, int start,int[] visited){
        visited[start]=1;
        for(Integer num:graph.get(start)){
            if(visited[num]!=1){
                topodfs(graph, stack, num, visited);
            }
        }
        stack.push(start);
    }
}
