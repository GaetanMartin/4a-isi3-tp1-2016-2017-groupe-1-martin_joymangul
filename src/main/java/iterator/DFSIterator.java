package iterator;

import graph.Graph;
import graph.Node;

/**
 * Created by Gaetan on 15/03/2017.
 * DFS - Stack
 */
public class DFSIterator extends GraphIterator {

    DFSIterator(Graph g, Node start) {
        super(g, start);
    }

    // Stack

    @Override
    protected Node pop() {
        return this.collection.pollLast();
    }
}
