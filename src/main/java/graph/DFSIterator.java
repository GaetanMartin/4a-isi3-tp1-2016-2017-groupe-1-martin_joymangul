package graph;

import java.util.*;

/**
 * Created by Gaetan on 15/03/2017.
 */
public class DFSIterator implements Iterator {

    private final Graph graph;
    private final Node start;
    private Set<Node> visited = new HashSet<>();
    private Deque<Node> queue = new LinkedList<Node>();


    public DFSIterator(Graph g, Node start) {
        this.graph = g;
        this.start = start;
        this.visited.add(start);
    }

    @Override
    public boolean hasNext() {
        return this.queue.isEmpty();
    }

    @Override
    public Object next() {
        Node node = queue.remove();
        for (Node neighbour : visited) {
            if (! this.visited.contains(neighbour)) {
                this.queue.add(neighbour);
                this.visited.add(neighbour);
            }
        }
        return node;
    }
}
