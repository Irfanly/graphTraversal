/*
Class: Main
The main class of the program. This class is responsible for creating the graph,
reading the file, and calling the user interface.
*/

//references https://www.baeldung.com/java-graphs
//references https://www.geeksforgeeks.org/graph-and-its-representations/
//references https://www.geeksforgeeks.org/implementing-generic-graph-in-java/

public class Main {

    public static void main(String[] args) {
        Graph graph = new Graph();
        FileReader fileReader = new FileReader();
        boolean exit = false;
        String filePath = ".\\LRT_Route.txt"; //change the file path if needed
        //read file
        fileReader.readFile(filePath, graph);

        Search search = new Search(graph);
        //create a new instance of the userInterfaces class
        userInterfaces UI = new userInterfaces(graph);

        do{
            int option = UI.option();
            if(option==1) {
                do{
                UI.mainUI();
                search.DFS(graph.getVertex(UI.getStartVertex()), graph.getVertex(UI.getEndVertex()));
                }while(!UI.repeat());
            }
            else if(option==2) {
                graph.printGraph();
                userInterfaces.waitInput();
            }
            else if(option==3) {
                exit = true;
            }
            userInterfaces.clearScreen();
        }while(!exit);

        System.out.println("Thank you for using Our System. Goodbye!");
        System.exit(0);
    }
}