package graph;

import iterator.BFSIterator;
import iterator.DFSIterator;

import java.util.*;
import java.util.stream.Collectors;


public class Graph implements IDirectedGraph {

	/**
	 * A chaque cle=noeud est associe la liste des arcs sortants de ce noeud
	 */
	private Map<Node,List<Arc>> adjacence; 
	
	public Graph(){
		
		adjacence = new HashMap<>();

	}
	/**
	 *  Tells if there is an arc between 2 nodes
	 * @param _n1 first node
	 * @param _n2 second node
	 * @return vrai si graph possede arc de src _n1 et destination _n2
	 */
	public boolean hasArc(Node _n1, Node _n2){
		List<Arc> arretesAdj = adjacence.get(_n1);
		for (Arc _a : arretesAdj){
			if (_n1.equals(_a.getSource()) && _n2.equals(_a.getDestination()))
				return true;
		}
		return false;
	}
	
	public void addNode(Node _node){
		adjacence.put(_node, new ArrayList<>());

	}
	
	public void addArc(Arc _edge){
	
		if (!hasArc(_edge.getSource(),_edge.getDestination()))
			adjacence.get(_edge.getSource()).add(_edge);
	
	}
	
	public Set<Node> getAllNodes(){
		return adjacence.keySet();
	}
	
	public int getNbNodes(){
		return getAllNodes().size();
	}
	
	/**
	 * 
	 * @param _n source
	 * @return tous les arcs de source _n
	 */
	public List<Arc> getArc(Node _n){
		
		return adjacence.get(_n);
	}
	/**
	 * renvoie tous les noeuds qui sont destination d'un arc dont la source est _n
	 */
	public List<Node> getAdjNodes(Node _n){
	    return getArc(_n).stream()
                .map(Arc::getDestination)
                .collect(Collectors.toList());
	}

    @Override
    public BFSIterator creerBFSIterator(Node n) {
        return new BFSIterator(this, n);
    }

	@Override
	public DFSIterator creerDFSIterator(Node n) {
		return new DFSIterator(this, n);
	}

    @Override
	public String toString() {
	    StringBuilder stb = new StringBuilder();
		stb.append("Graph \n");
        for (Node node : getAllNodes()){
            stb.append(node);
            stb.append(getArc(node));
            stb.append("\n");
        }
		return stb.toString();
	}
}
