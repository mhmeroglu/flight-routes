import java.util.Collections;
import java.util.LinkedList;

public class BFS {
    private boolean[] marked;
    private int[] tempList;
    private LinkedList<Integer> queue;

    // source
    private int s;

    // destination
    private int d;

    // Constructor
    public BFS(Graph G, int s, int d, int t, int c) {
        this.s = s;
        this.d = d;

        // marked array
        marked = new boolean[G.V()];
        // temp list
        tempList = new int[G.V()];
        // queue
        queue = new LinkedList<Integer>();

        // call bfs
        bfs(G, s, d, t, c);
    }

    //--------------------------------------------------------
    // Summary: Breadth First Search Method
    // Precondition: G is an Undirected Graph and x, y, t and c are an integer.
    // Postcondition: Path found by searching using bfs iterative.
    //--------------------------------------------------------
    private void bfs(Graph G, int x, int y, int t, int c) {

        //queue
        LinkedList<Integer> queue = new LinkedList<>();

        // First one visited
        marked[x] = true;
        queue.add(x);

        // Iterate till all nodes are visited
        while (!queue.isEmpty()) {
            // Get the top element by pop()
            int top = queue.pop();
            LinkedList<Integer> list = (LinkedList<Integer>) G.adj(top);
            Collections.sort(list);

            for (int i = 0; i < list.size(); i++) {
                int v = list.get(i);
                if (v == y) {
                    tempList[v] = top;

                    queue.clear();
                    break;
                }
                // If not visited
                if (marked[v] != true) {
                    marked[v] = true;
                    queue.add(v);
                    tempList[v] = top;
                }
            }
        }
        // creating result list and check it
        LinkedList<Integer> result = new LinkedList<>();
        result.add(y);
        while (y != 0) {
            int temp = tempList[y];
            if (temp != 0)
                result.add(temp);
            y = temp;
        }

        //Print the result
        System.out.println(result.size());
        for (int i = result.size() - 1; -1 < i; i--) {
            System.out.print(result.get(i) + " ");
        }
        System.out.println();
        int time = ((result.size() - 1) * c) + ((result.size() - 2) * (t - (c % t)));
        System.out.println(time);
    }
}
