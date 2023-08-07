package Graph;

import java.util.*;

public class Representation {
    /**
     * 
     */
    public Map<Integer,List<Integer>> Adjlist(){
        //list representation of list
        int n=6; //no of vertices
        int[][] edges= new int[][]{{0,3},{1,2},{1,5},{2,4},{3,5},{5,4},{5,0}};

        //make list from edges
        Map<Integer,List<Integer>> graph=new HashMap<>();
        for(int i=0;i<edges.length;i++){
            if(!graph.containsKey(edges[i][0])){
                graph.put(edges[i][0], new ArrayList<Integer>(Arrays.asList(edges[i][1])));
            }else{
                graph.get(edges[i][0]).add(edges[i][1]);
            }
        }

        //show the graph
        for(Map.Entry<Integer, List<Integer>> entry:graph.entrySet()){
            System.out.print(entry.getKey()+"--->");
            for(int i: entry.getValue()){
                System.out.print(i+" ");
                
            }
            System.out.println();
        }
        return graph;

    }
    public void matrix(){
        //matrix representation of graph
        int n=6;
        int[][] edges= new int[][]{{0,3},{1,2},{1,5},{2,4},{3,5},{5,4},{5,0}};

        int[][] mat=new int[6][6];
        for(int i=0;i<edges.length;i++){
            mat[edges[i][0]][edges[i][1]]=1;
        }

        //show the adjecency matrix
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }
}
