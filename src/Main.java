import datastructures.binarysearchtree.BinarySearchTree;
import datastructures.graph.Graph;
import datastructures.hashtable.HashTable;
import datastructures.linkedlist.LinkedList;

public class Main {
    public static void main(String[] args) {

        Graph g = new Graph();

        g.addVertex("A");
        g.addVertex("B");
        g.addVertex("C");
        g.printGraph();
        g.addEdge("A", "B");
        g.addEdge("B", "C");
        g.addEdge("C", "A");
        g.printGraph();
        g.removeVertex("A");
        g.printGraph();

    }
}