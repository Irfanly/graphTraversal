/*
Class: Search
This class is responsible for the searching algorithm.
The DFS algorithm closely follows the pseudocode from the assignment document.
The DFS algorithm is called recursively until the destination is found.
The visited path is stored in a linked list.
The path is printed when the destination is found.
*/
import java.util.LinkedList;

public class Search {
    private Graph graph;
    private LinkedList<Vertex> visited;
    private int totalWeight = 0;
    private boolean found = false;

    public Search(Graph graph) {
        this.graph = graph;
        visited = new LinkedList<>();
    }

    public void DFS(Vertex v, Vertex d) {
        LinkedList<Vertex> path = new LinkedList<>(); // List to store the path
        path.add(v); // Add the starting vertex to the path
        DFS(v, d, path); // Call the recursive DFS method
        if(!found){
            System.out.println("No path found");
        }
        clearData(); // Clear the data for the next search
    }

    public void DFS(Vertex v, Vertex d, LinkedList<Vertex> path){
        visited.add(v); // Add the current vertex to the visited set
        if(v == d){ // If the current vertex is the destination vertex
            found = true;
            printPath(path); // Print the path
            //System.out.println("Path found: " + path);
        }

        else {
            for (Edge edge : v.getEdges()) { // Loop through the edges of the current vertex
                Vertex neighbour = edge.getDestination();
                if (!visited.contains(neighbour)) { // If the neighbour has not been visited
                    path.add(neighbour); // Add the neighbour to the path
                    totalWeight += edge.getWeight();
                    DFS(neighbour, d, path); // Call the recursive DFS method
                    path.remove(neighbour); // Remove the neighbour from the path
                }
            }
        }
    }

    // Print the path
    private void printPath(LinkedList<Vertex> path){
        System.out.print("Path found: ");
        for(Vertex vertex : path){
            if (vertex == path.getLast())
                System.out.print(vertex.getName());
            else
                System.out.print(vertex.getName() + " -> ");
        }
        System.out.println("\nTicket Cost: RM" + totalWeight);
    }

    // Clear the data for the next search
    private void clearData(){
        visited.clear();
        totalWeight = 0;
        found = false;
    }
}
