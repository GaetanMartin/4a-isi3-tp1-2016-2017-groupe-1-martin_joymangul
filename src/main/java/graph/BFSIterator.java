package graph;

import java.util.*;

/**
 * Created by Gaetan on 15/03/2017.
 */
public class BFSIterator implements Iterator {

    private final Graph graph;
    private Set<Node> visited = new HashSet<>();
    private Queue<Node> queue = new LinkedList<Node>();


    public BFSIterator(Graph g, Node start) {
        this.graph = g;
        this.queue.add(start);
        this.visited.add(start);
    }

    @Override
    public boolean hasNext() {
        return !this.queue.isEmpty();
    }

    @Override
    public Node next() {
        if (queue.isEmpty()) {
            throw new NoSuchElementException();
        } else {
            Node node = queue.remove();
            for (Node neighbour : this.graph.getAdjNodes(node)) {
                if (! this.visited.contains(neighbour)) {
                    this.queue.add(neighbour);
                    this.visited.add(neighbour);
                }
            }
            return node;
        }
    }
}
