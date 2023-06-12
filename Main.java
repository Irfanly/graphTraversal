public class Main {

    //references https://medium.com/@mithratalluri/basic-graph-implementation-in-java-9ed12e328c57
    //references https://www.baeldung.com/java-graphs
    //references https://www.geeksforgeeks.org/graph-and-its-representations/
    //https://www.geeksforgeeks.org/creating-a-dynamic-array-in-java/

    public static void main(String[] args) {
        Graph graph = new Graph();
        FileReader fileReader = new FileReader();

        //read file
        fileReader.readFile("src\\input.txt", graph);

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