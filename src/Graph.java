import java.util.LinkedList;

public class Graph {
    private final int V;
    private LinkedList<Integer>[] adj;

    // Graph constructor
    public Graph(int V) {
        this.V = V;
        adj = new LinkedList[V];
        for (int v = 0; v < V; v++)
            adj[v] = new LinkedList<>();
    }

    // return V(vertex)
    public int V() {
        return V;
    }

    //--------------------------------------------------------
    // Summary: Connecting the vertex with the vertices.
    // Precondition: u and v are an integer.
    // Postcondition: vertices connected by edges.
    //--------------------------------------------------------
    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    //return adj list
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }
}