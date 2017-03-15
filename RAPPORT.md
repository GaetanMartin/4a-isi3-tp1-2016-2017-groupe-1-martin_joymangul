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
*Expliquer le code ajouté et insérer un schéma du patron de conception mis en place*

## Question 3
*Expliquer le code ajouté et insérer un schéma du patron de conception mis en place*

## Question 4
*Expliquer le code ajouté et insérer un schéma du patron de conception mis en place*
