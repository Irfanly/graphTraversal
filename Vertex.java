import java.util.LinkedList;

public class Vertex {
    private String name;
    private LinkedList<Edge> edges;

    public Vertex(String name){
        this.name = name;
        edges = new LinkedList<>();
    }

    public String getName(){
        return name;
    }

    public LinkedList<Edge> getEdges(){
        return edges;
    }
}
