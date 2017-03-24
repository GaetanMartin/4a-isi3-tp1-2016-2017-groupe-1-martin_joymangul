package graph;

import iterator.BFSIterator;
import iterator.DFSIterator;

import java.util.List;
import java.util.Set;

public interface IGraph {
	/**
	 * ajoute un noeud au graph
	 */
	void addNode(Node _node);
	
	/**
	 * 
	 * @return tous les noeuds du graph
	 */
	Set<Node> getAllNodes();
	/**
	 * 
	 * @return le nombre de noeuds du graph
	 */
	int getNbNodes();

	/**
	 * renvoie tous les noeuds du graph qui sont destination d'un arc dont la source est _n
	 */
	List<Node> getAdjNodes(Node _n);
	
	/**
	 * renvoi un iterateur pour recherche en largeur
	 */
	BFSIterator creerBFSIterator(Node n);

	/**
	 * renvoi un iterateur pour recherche en profondeur
	 */
	DFSIterator creerDFSIterator(Node n);
}
