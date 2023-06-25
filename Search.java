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
        clearData();
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

    private void clearData(){
        visited.clear();
        totalWeight = 0;
        found = false;
    }
/*
    public void BFS(Vertex v, Vertex d) {
        LinkedList<Vertex> queue = new LinkedList<>(); // Queue to store the vertices
        HashSet<Vertex> visited = new HashSet<>(); // Set to keep track of visited vertices
        LinkedList<Edge> edges = new LinkedList<>(); // List to store the edges of the path

        queue.add(v); // Add the starting vertex to the queue
        visited.add(v); // Add the starting vertex to the visited set

        while (!queue.isEmpty()) {
            Vertex current = queue.remove(); // Remove the first vertex from the queue
            if (current == d) {
                found = true;
                break;
            }
            for (Edge edge : current.getEdges()) { // Loop through the edges of the current vertex
                Vertex neighbour = edge.getDestination();
                if (!visited.contains(neighbour)) { // If the neighbour has not been visited
                    queue.add(neighbour); // Add the neighbour to the queue
                    visited.add(neighbour); // Add the neighbour to the visited set
                    edges.add(edge); // Add the edge to the list of edges
                }
            }
        }

        if (found) {
            System.out.println("Path from " + v.getName() + " to " + d.getName() + ":");
            for (Edge edge : edges) {
                System.out.println(edge.getSource().getName() + " -> " + edge.getDestination().getName() + " with weight " + edge.getWeight());
            }
        } else {
            System.out.println("No path found from " + v.getName() + " to " + d.getName());
        }
    }
/*
    public void DFS(Vertex v, Vertex d) {
        LinkedList<Vertex> stack = new LinkedList<>(); // Stack to store the vertices
        HashSet<Vertex> visited = new HashSet<>(); // Set to keep track of visited vertices
        LinkedList<Edge> edges = new LinkedList<>(); // List to store the edges of the path

        stack.push(v); // Add the starting vertex to the stack
        visited.add(v); // Add the starting vertex to the visited set

        while (!stack.isEmpty()) {
            Vertex current = stack.pop(); // Remove the first vertex from the stack
            if (current == d) {
                found = true;
                break;
            }
            for (Edge edge : current.getEdges()) { // Loop through the edges of the current vertex
                Vertex neighbour = edge.getDestination();
                if (!visited.contains(neighbour)) { // If the neighbour has not been visited
                    stack.push(neighbour); // Add the neighbour to the stack
                    visited.add(neighbour); // Add the neighbour to the visited set
                    edges.add(edge); // Add the edge to the list of edges
                }
            }
        }

        if (found) {
            System.out.println("Path from " + v.getName() + " to " + d.getName() + ":");
            for (Edge edge : edges) {
                System.out.println(edge.getSource().getName() + " -> " + edge.getDestination().getName() + " with weight " + edge.getWeight());
            }
        } else {
            System.out.println("No path found from " + v.getName() + " to " + d.getName());
        }
    }*/



/*
//Apa ni tak fahammmmmmmm
    public void findPathDFS(Vertex v, Vertex d) {
        HashSet<Vertex> visited = new HashSet<>(); // Set to keep track of visited vertices
        LinkedList<Edge> edges = new LinkedList<>(); // List to store the edges of the path
        int i = 0;

        for (Vertex vertex : graph.getNodes()) {
            vertex.setNum(0); // Reset the num value for each vertex
        }

        while (v != d || hasUnvisitedVertex()) {
            DFS(v, d, visited, edges, i);
        }

        if (v == d) {
            System.out.println("Path from " + v.getName() + " to " + d.getName() + ":");
            for (int j = edges.size() - 1; j >= 0; j--) {
                Edge edge = edges.get(j);
                System.out.println(edge.getSource().getName() + " -> " + edge.getDestination().getName() + " with weight " + edge.getWeight());
            }
        } else {
            System.out.println("No path from " + v.getName() + " to " + d.getName());
        }
    }

    private void DFS(Vertex v, Vertex d, HashSet<Vertex> visited, LinkedList<Edge> edges, int i) {
        v.setNum(i++); // Set the num value for the current vertex

        for (Edge edge : v.getEdges()) {
            Vertex u = edge.getDestination();
            if (!visited.contains(u) && v != d) {
                edges.add(edge); // Add the edge to the path
                visited.add(u); // Mark the vertex as visited
                DFS(u, d, visited, edges, i);
            }
        }
    }

    private boolean hasUnvisitedVertex() {
        for (Vertex vertex : graph.getNodes()) {
            if (vertex.getNum() == 0) {
                return true;
            }
        }
        return false;
    }*/
}
