import java.util.List;

public class DepthFirstSearch {
    private Graph graph;
    private List<Vertex> visitedVertices;

    public DepthFirstSearch(Graph graph) {
        this.graph = graph;
        visitedVertices = new java.util.LinkedList<>();
    }

    public void search(Vertex vertex) {
        if (!visitedVertices.contains(vertex)) {
            visitedVertices.add(vertex);
            System.out.println(vertex.getName());
            for (Edge edge : vertex.getEdges()) {
                search(edge.getDestination());
            }
        }
    }

    public void search() {
        for (Vertex vertex : graph.getNodes()) {
            search(vertex);
        }
    }





}
