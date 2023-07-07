/*
Class: Graph
This class is responsible for creating the graph.
The ADT used to store the graph is a linked list.
The graph is created by adding vertices and edges to the graph.
*/

import java.util.LinkedList;

public class Graph {
    private LinkedList<Vertex> nodes;

    // Constructor
    public Graph(){
        nodes = new LinkedList<>();
    }

    // Add a vertex to the graph
    public void addVertex(Vertex vertex){
        nodes.add(vertex);
    }

    // Add an edge between two vertices
    public void addEdge(Vertex source, Vertex destination, int weight){
        Edge edge = new Edge(source, destination, weight);
        source.getEdges().add(edge);
    }

    // Return the list of vertices
    public LinkedList<Vertex> getNodes(){
        return nodes;
    }

    // Get the vertex with the given name
    public Vertex getVertex(String name){
        for(Vertex vertex : nodes){
            if(vertex.getName().equals(name)){
                return vertex;
            }
        }
        return null;
    }

    // Print the connections between vertices
    public void printGraph(){
        for(Vertex vertex : nodes){
            //If the vertex has no edges, skip it
            if(vertex.getEdges().size() > 0) {
                for (Edge edge : vertex.getEdges()) {
                    System.out.println("From " + vertex.getName() + " to " + edge.getDestination().getName());
                    System.out.println("Ticket cost: RM" + edge.getWeight());
                }
                System.out.println();
            }
        }
    }

}
