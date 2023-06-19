import java.util.Scanner;

public class Main {
    // main method
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // get values
        int n = scan.nextInt();
        int m = scan.nextInt();
        int t = scan.nextInt();
        int c = scan.nextInt();

        // creating Graph
        Graph G = new Graph(n + 1);

        for (int i = 1; i <= m; i++) {
            // get edges
            int u = scan.nextInt();
            int v = scan.nextInt();
            G.addEdge(u, v);
        }
        // get start and end points
        int x = scan.nextInt();
        int y = scan.nextInt();

        // call bfs
        BFS bfs = new BFS(G, x, y, t, c);
    }
}

