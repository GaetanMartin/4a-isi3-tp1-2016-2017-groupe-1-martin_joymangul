package iterator;

import graph.Graph;
import graph.Node;

import java.util.*;

/**
 * Created by Gaetan on 18/03/2017.
 * Graph Iterator for browsing
 */
public abstract class GraphIterator implements Iterator {

    protected LinkedList<Node> collection;

    private Set<Node> visited;

    private final Graph graph;

    GraphIterator(Graph g, Node start) {
        this.graph = g;
        this.collection = new LinkedList<>();
        this.visited = new HashSet<>();
        this.visited.add(start);
        this.collection.add(start);

    }

    @Override
    public boolean hasNext() {
        return !collection.isEmpty();
    }

    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        } else {
            Node node = this.pop();
            for (Node neighbour : graph.getAdjNodes(node)) {
                if (! this.visited.contains(neighbour)) {
                    this.collection.add(neighbour);
                    this.visited.add(neighbour);
                }
            }
            return node;
        }
    }

    protected Node pop() {
        // TO OVERRIDE
        return collection.getFirst();
    }
}
