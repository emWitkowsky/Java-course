import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("The programme is a manager of grades for students. It allows to add, show min, max and mean of grades.");
        Scanner console = new Scanner(System.in);
        GradeList gradeList = new GradeList();
        boolean running = true;
        while(running) {
            menu();
            int chosenOption = console.nextInt();
            switch (chosenOption) {
                case 1 -> addAction(gradeList, console);
                case 2 -> showMeanAction(gradeList);
                case 3 -> showMaxAction(gradeList);
                case 4 -> showMinAction(gradeList);
                case 0 -> running = false;
            }
        }
    }

    public static void menu() {
        System.out.println("1. Add a grade");
        System.out.println("2. Show mean grade");
        System.out.println("3. Show max grade");
        System.out.println("4. Show min grade");
        System.out.println("0. Exit");
        System.out.println("Choose an option by selecting number (int): ");
    }

    public static void addAction(GradeList list, Scanner console) {
        System.out.println("Enter the grade you want to add (double): ");
        double gradeToAdd = console.nextDouble();
        list.addGrade(gradeToAdd);
    }

    public static void showMeanAction(GradeList list) {
        if (list.getMeanGrade() == 0.0) {
            errMessage();
        } else {
            System.out.printf("Mean grade: %.2f\n", list.getMeanGrade());
        }
    }

    public static void showMaxAction(GradeList list) {
        if (list.getMaxGrade() == 0.0) {
            errMessage();
        } else {
            System.out.printf("Max grade: %.2f\n", list.getMaxGrade());
        }
    }

    public static void showMinAction(GradeList list) {
        if (list.getMinGrade() == 0.0) {
            errMessage();
        } else {
            System.out.printf("Min grade: %.2f\n", list.getMinGrade());
        }
    }

    public static void errMessage() {
        System.out.println("No grades added yet.");
    }
}