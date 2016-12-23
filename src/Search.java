/**
  * Description: Generic FIFO queue implemented
  * using a linked list.  Supports basic insert
  * and remove operations.  All operations take
  * constant time, aside from initilization.
  * 
  * Dependencies: Graph.java, Queue.java
  * 
  * API                            Description
  * -----------------------------------------------------
  *     Search(Graph undirectedG, int source)
  *                                Run depth first search
  *                                from source on an
  *                                undirected graph
  * 
  * 
  * void depthFirstSearch(Graph g, int v)
  *                                Recursive dfs for an
  *                                undirected graph 
  * 
  * boolean isConnected(int w)     Is a vertex connected 
  *                                to the graph containing
  *                                the source vertex which
  *                                was used for init?
  * 
  * int numOfConnections()         Number of vertices the
  *                                source vertex is
  *                                connected to                                
  */
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