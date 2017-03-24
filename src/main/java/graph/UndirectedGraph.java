package graph;

import label.Label;
import iterator.BFSIterator;
import iterator.DFSIterator;

import java.util.*;


public class UndirectedGraph implements IUndirectedGraph {


	private Graph graph;

	public UndirectedGraph(){
		this.graph = new Graph();
	}

	@Override
	public void addEdge(Node _node1, Node _node2) {
		this.addEdge(_node1, _node2, null);
	}

	@Override
	public void addEdge(Node _node1, Node _node2, Label valuation) {
		this.graph.addArc(new Arc(_node1, _node2, valuation));
		this.graph.addArc(new Arc(_node2, _node1, valuation));
	}

	@Override
	public boolean hasEdge(Node _node1, Node _node2) {
		return this.graph.hasArc(_node1, _node2);
	}

	@Override
	public void addNode(Node _node) {
		this.graph.addNode(_node);
	}

	@Override
	public Set<Node> getAllNodes() {
		return this.graph.getAllNodes();
	}

	@Override
	public int getNbNodes() {
		return this.graph.getNbNodes();
	}

	@Override
	public List<Node> getAdjNodes(Node _n) {
		return this.graph.getAdjNodes(_n);
	}

	@Override
	public BFSIterator creerBFSIterator(Node n) {
		return this.graph.creerBFSIterator(n);
	}

	@Override
	public DFSIterator creerDFSIterator(Node n) {
		return this.graph.creerDFSIterator(n);
	}
}
