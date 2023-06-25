/*
Class: Vertex
This class is responsible for creating the vertices of the graph.
The vertices are stored in a linked list.
*/

import java.util.LinkedList;

public class Vertex {
    private String name;
    private LinkedList<Edge> edges;

    // Constructor
    public Vertex(String name){
        this.name = name;
        edges = new LinkedList<>();
    }

    // Get the name of the vertex
    public String getName(){
        return name;
    }

    // Return the edges of the vertex
    public LinkedList<Edge> getEdges(){
        return edges;
    }
}
