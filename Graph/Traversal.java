package Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

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
    }

    public void dfs(){
        /*
         * t=O(v+e)
         * task like - count connected components, determine connectivity, or find bridges
         * updated dfs can use for :- Compute graph's MST, find cycle in graph, if a graph is bipartite, 
         * topological sort, generate mazes, find augmenting paths in a flow network.
         */
        System.out.println("Dfs traversal");

    }

    public void cycledetection(){
        System.out.println("cycle");
    }

    public void topologicalsort(){
        System.out.println("topological");
    }
}
