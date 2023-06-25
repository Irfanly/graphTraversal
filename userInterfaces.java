/*
Class: userInterfaces
This class is responsible for the user interface of the program.
All the text UI and methods are in this class.
*/
import java.util.Scanner;

public class userInterfaces {

    String startVertex;
    String endVertex;
    Graph graph;

    public userInterfaces(Graph graph){
        this.graph = graph;
    }

    public void getInput(){
        System.out.println("From Which Station?: ");
        Scanner scanner = new Scanner(System.in);
        startVertex = scanner.nextLine().toUpperCase();
        System.out.println("Your Destination: ");
        endVertex = scanner.nextLine().toUpperCase();

        if(graph.getVertex(startVertex) == null || graph.getVertex(endVertex) == null){
            System.out.println("Station(s) not available in database. Please try again.");
            clearScreen();
            mainUI();
        }
    }

    public void mainUI(){
        System.out.println("KL LRT Station Route Finder");
        System.out.println("Our Coverage: ");

        for(Vertex vertex : graph.getNodes()){
            System.out.println(vertex.getName());
        }
        getInput();
    }

    public boolean repeat(){
        System.out.println("Would you like to find another route? (Y/N)");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().toUpperCase();

        if(!input.equals("N") && !input.equals("Y")) {
            System.out.println("Invalid input. Please try again.");
            return repeat();
        }

        else {
            if(input.equals("Y")){
                return false;
            }
            else{
                System.out.println("Thank you for using Our System. Goodbye!");
                return true;
            }
        }

    }

    private void clearScreen(){
        System.out.println("cls");
    }

    public String getStartVertex(){ return startVertex; }
    public String getEndVertex(){ return endVertex; }
}
