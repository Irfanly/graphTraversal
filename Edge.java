/*
Class: Edge
This class is responsible for creating the edges of the graph.
The edges are stored in a linked list.
*/

public class Edge {
    private Vertex source;
    private Vertex destination;
    private int weight;

    // Constructor
    public Edge(Vertex source, Vertex destination, int weight){
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    // Get the source vertex
    public Vertex getSource(){
        return source;
    }

    // Get the destination vertex
    public Vertex getDestination(){
        return destination;
    }

    // Get the weight of the edge
    public int getWeight(){
        return weight;
    }

}
