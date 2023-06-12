import java.util.HashSet;


public class Graph {
    private HashSet<Vertex> nodes;

    public Graph(){
        nodes = new HashSet<>();
    }

    public void addVertex(Vertex vertex){
        nodes.add(vertex);
    }

    public void addEdge(Vertex source, Vertex destination, int weight){
        Edge edge = new Edge(source, destination, weight);
        source.getEdges().add(edge);
    }

    public HashSet<Vertex> getNodes(){
        return nodes;
    }

    public Vertex getVertex(String name){
        for(Vertex vertex : nodes){
            if(vertex.getName().equals(name)){
                return vertex;
            }
        }
        return null;
    }


    public void printGraph(){
        for(Vertex vertex : nodes){
            System.out.println(vertex.getName() + " is connected to:");
            for(Edge edge : vertex.getEdges()){
                System.out.println(edge.getDestination().getName() + " with weight " + edge.getWeight());
            }
            System.out.println();
        }
    }
}
