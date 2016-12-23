import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;

public class Search
{
    private boolean[] visited;
    private int connections;    
    
    public Search(Graph undirectedG, int source)
    {
        visited = new boolean[undirectedG.numOfVertices()]; // init to false
        connections = 0;
        depthFirstSearch(undirectedG, source);
    }
    
    public void depthFirstSearch(Graph g, int v)
    {
        if (visited[v]) return;
        visited[v] = true;
        connections++;
        Queue<Integer> q = g.adjacentVertices(v);
        while (!q.isEmpty())
            depthFirstSearch(g, q.dequeue());
    }
    
    public boolean isConnected(int w)
    { return visited[w]; }
            
    
    public int numOfConnections()
    { return connections; }
    
    public static void main(String[] args)
    {   // or use medG.txt
        Graph g = new Graph(new In("/Users/Hennessy/Graph Algorithms/Graph Data Types/Undirected/data/tinyG.txt"));
        Search sg = new Search(g, 0);
        StdOut.println("Test numOfConnections: "); 
        StdOut.println(sg.numOfConnections());
        StdOut.println("Test isConnected()");
        for (int i = 0; i < sg.visited.length; i++)
            StdOut.println(i + " : " + sg.isConnected(i));
    }
}