import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        startProgramme();
        int initRadius = console.nextInt();
        int initHeight = console.nextInt();
        Walec cylinder = new Walec(initRadius, initHeight);


        boolean running = true;
        while(running) {
            printMenu();
            String chosenOpt = console.next();
            switch(chosenOpt) {
                case "a" -> showValues(cylinder);
                case "b" -> changeValues(cylinder, console);
                case "c" -> countAreas(cylinder);
                case "d" -> countCapacity(cylinder);
                case "e" -> running = false;
            }
        }
    }

    public static void startProgramme() {
        System.out.println("The programme is supposed to give information about cylinder after choosing the option");
        System.out.println("Create your cylinder (give radius and height, in that order, separated by newline(enter):");
    }
    public static void printMenu() {
        System.out.println("Choose the action" + "\n" +
                "[a]: Show cylinder info" + "\n" +
                "[b]: Set values of cylinder" + "\n" +
                "[c]: Count areas of cylinder" + "\n" +
                "[d]: Count capacity of cylinder" + "\n" +
                "[e]: Exit");
    }

    public static void showValues(Walec givenCylinder) {
        System.out.println("Height: " + givenCylinder.getHeight());
        System.out.println("Radius: " + givenCylinder.getRadius());
    }

    public static void changeValues(Walec givenCylinder, Scanner userInput) {
        System.out.println("Insert height:");
        int givenHeight = userInput.nextInt();
        System.out.println("Insert radius:");
        int givenRadius = userInput.nextInt();

        givenCylinder.setHeight(givenHeight);
        givenCylinder.setRadius(givenRadius);
    }

    public static void countAreas(Walec givenCylinder) {
        System.out.printf("Area of base: %.2f\n", givenCylinder.areaOfBase());
        System.out.printf("Area of side: %.2f\n", givenCylinder.areaOfSide());
        System.out.printf("Total area: %.2f\n", givenCylinder.areaOfTotal());
    }

    public static void countCapacity(Walec givenCylinder) {
        System.out.printf("Capacity of cylinder: %.2f\n", givenCylinder.capacity());
    }
}