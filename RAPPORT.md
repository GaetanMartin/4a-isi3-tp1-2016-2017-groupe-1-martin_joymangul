**Nom/Prénom Etudiant 1 : MARTIN Gaëtan**

**Nom/Prénom Etudiant 2 : JOYMANGUL Jensen**

# Rapport TP1

## Question 1
**public Set\<Node> getAllNodes())**
```java
public Set<Node> getAllNodes(){
    return adjacence.keySet();
}
````
On retourne la liste de tous les noeuds dans un _Set\<Node>_.
On a fait le choix du _Set\<Node>_ car les noeuds sont unique.

**public List<Arc> getArc(Node _n)**
```java
public List<Arc> getArc(Node _n){
    return adjacence.get(_n);
}
````
Retourner la list des arcs du noeud donné(_n)

**public String toString()**
```java
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
````
Récupérer la chaïne de charactère qui représente un graph.
Pour réaliser cela, la methode fait appel au toString() de des noeuds et des arcs.

L 'appel aux methodes toString() est gérer automatiquement en Java dans la focntion append()

## Question 2
**Patron de conception**

![Package graph](images/exo2.png)

## Question 3 / Question 4
Le code pour le parcour en profondeur et en largeur se ressemble, la seule différence est dans le parcour en profondeur on utilise une file alors pour le parcour en largeur, on utilise une pile.

Afin de limiter la duplication de code le pattern suivant est appliqué:

![Package graph](images/exo3.png)

Dans la classe abstraite GraphIterator possède le code pour parcourir le graph cependant seulement le pop() doit être surchargé dans les classes BFSIterator et DFSIterator
```java
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
````

Le pop() de BFSIterator:
```java
protected Node pop() {
    return this.collection.pollFirst();
}
````

Le pop() de DFSIterator:
```java
protected Node pop() {
    return this.collection.pollLast();
}
````
