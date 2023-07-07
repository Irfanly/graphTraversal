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

    public int option(){
        int input;
        do {
            System.out.println("------------------------------------");
            System.out.println("KL LRT Station Route Finder");
            System.out.println("------------------------------------");
            System.out.println("Please select an option: ");
            System.out.println("1. Find the route from one station to another");
            System.out.println("2. Check ticket price");
            System.out.println("3. Exit");
            System.out.print("Your option: ");

            Scanner scanner = new Scanner(System.in);

            if(scanner.hasNextInt())
                input = scanner.nextInt();
            else
                input = 0;

            clearScreen();

            if(input < 1 || input > 3)
                System.out.println("Invalid input. Please try again.");

        } while (input < 1 || input > 3);

        return input;
    };
    public void getInput(){
        System.out.println("Enter Start Station?: ");
        Scanner scanner = new Scanner(System.in);
        startVertex = scanner.nextLine().toUpperCase().trim();
        System.out.println("Your Destination: ");
        endVertex = scanner.nextLine().toUpperCase().trim();

        if(graph.getVertex(startVertex) == null || graph.getVertex(endVertex) == null){
            clearScreen();
            System.out.println("Station(s) not available in database. Please try again.");
            mainUI();
        }
    }

    public void mainUI(){
        System.out.println("------------------------------------");
        System.out.println("KL LRT Station Route Finder");
        System.out.println("------------------------------------");
        System.out.println("Our Stations Coverage: ");

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
                clearScreen();
                return false;
            }
            else{
                return true;
            }
        }
    }

    //clear screen by printing line to make the UI looks cleaner
    public static void clearScreen(){
        for(int i = 0; i < 50; i++){
            System.out.println();
        }
    }

    //wait for user input
    public static void waitInput(){
        System.out.println("Press enter to continue!!...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }
    public String getStartVertex(){ return startVertex; }
    public String getEndVertex(){ return endVertex; }
}
