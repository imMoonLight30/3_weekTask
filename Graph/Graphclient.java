package Graph;

import java.util.List;
import java.util.Map;

class Graph{
    public static void main(String args[]){
        //graph representation (adjecency list & matrix)
        System.out.println("Graph representation");
        System.out.println("adjency list");
        Representation rep=new Representation();
        Map<Integer,List<Integer>> graph =rep.Adjlist();
        System.out.println("adjency matrix");
        rep.matrix();

        //bfs and dfs (travelsal)
        Traversal travel= new Traversal();
        travel.bfs(graph);
        travel.dfs();
        travel.cycledetection();
        travel.topologicalsort();

    }
}