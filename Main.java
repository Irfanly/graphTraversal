/*
Class: Main
The main class of the program. This class is responsible for creating the graph,
reading the file, and calling the user interface.
*/

//references https://medium.com/@mithratalluri/basic-graph-implementation-in-java-9ed12e328c57
//references https://www.baeldung.com/java-graphs
//references https://www.geeksforgeeks.org/graph-and-its-representations/
//https://www.geeksforgeeks.org/creating-a-dynamic-array-in-java/
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Graph graph = new Graph();
        FileReader fileReader = new FileReader();
        boolean exit = false;
        //read file
        fileReader.readFile("src\\LRT_Route.txt", graph);

        Search search = new Search(graph);
        //create a new instance of the userInterfaces class
        userInterfaces UI = new userInterfaces(graph);

        do {
            UI.mainUI();
            search.DFS(graph.getVertex(UI.getStartVertex()), graph.getVertex(UI.getEndVertex()));
        } while (!UI.repeat());

        System.exit(0);


/*
        //get start and end vertex
        Vertex start = graph.getVertex(startVertex);
        Vertex end = graph.getVertex(endVertex);

        //create a new instance of the search class
        Search search = new Search(graph);

        search.findPathDFS(start, end);
*/

/*
        //create vertices
        Vertex vertexA = new Vertex("A");
        Vertex vertexB = new Vertex("B");
        Vertex vertexC = new Vertex("C");

        //add vertices to graph
        graph.addVertex(vertexA);
        graph.addVertex(vertexB);
        graph.addVertex(vertexC);

        //add edges to graph
        graph.addEdge(vertexA, vertexB, 1);
        graph.addEdge(vertexB, vertexC, 2);
        graph.addEdge(vertexC, vertexA, 3);
*/



        //print graph
        graph.printGraph();
    }
}