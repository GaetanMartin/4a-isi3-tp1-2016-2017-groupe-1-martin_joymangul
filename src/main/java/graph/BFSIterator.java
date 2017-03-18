package graph;

import java.util.*;

/**
 * Created by Gaetan on 15/03/2017.
 * BFS - Queue
 */
public class BFSIterator extends GraphIterator {

    BFSIterator(Graph g, Node start) {
        super(g, start);
    }

    // Queue

    @Override
    protected Node pop() { return this.collection.pollFirst(); }
}
