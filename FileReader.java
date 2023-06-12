import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class FileReader {

    public boolean readFile(String fileName, Graph graph) {
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);

            int size = Integer.parseInt(scanner.nextLine()); // Read the size of the adjacency matrix
            int[][] adjacencyMatrix = new int[size][size]; // Create a 2D array to store the adjacency matrix

            // Read the adjacency matrix values from the file
            for (int i = 0; i < size; i++) {
                String line = scanner.nextLine();
                String[] lineArray = line.split(" ");
                for (int j = 0; j < size; j++) {
                    adjacencyMatrix[i][j] = Integer.parseInt(lineArray[j]);
                }
            }

            String vertexNames = scanner.nextLine(); // Read the vertex names from the file
            String[] vertexNamesArray = vertexNames.split(","); // Split the vertex names into an array
            // Create vertices and add them to the graph
            for (int i = 0; i < size; i++) {
                Vertex vertex = new Vertex(vertexNamesArray[i]);
                graph.addVertex(vertex);
            }

            // Add edges to the graph based on the adjacency matrix
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    int weight = adjacencyMatrix[i][j];
                    if (weight != 0) {
                        Vertex source = graph.getVertex(vertexNamesArray[i]);
                        Vertex destination = graph.getVertex(vertexNamesArray[j]);
                        graph.addEdge(source, destination, weight);
                    }
                }
            }

            scanner.close();
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
            return false;
        }
    }

}
