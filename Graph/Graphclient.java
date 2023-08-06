package Graph;

class Graph{
    public static void main(String args[]){
        System.out.println("Graph representation");
        System.out.println("adjency list");
        Representation rep=new Representation();
        rep.Adjlist();
        System.out.println("adjency matrix");
        rep.matrix();
        //bfs and dfs (travelsal)
        
    }
}