import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("The programme is a Calendar manager. You can add and remove meetings of various days. You can also print meetings of a specific day, filtered by various artibutes.");
        Scanner console = new Scanner(System.in);

        Calendar calendar = new Calendar();
        calendar.addMockMeetings();

        boolean running = true;
        while(running) {
            menu3();
            int chosenOption = console.nextInt();
            switch (chosenOption) {
                case 1 -> menuMeeting(console, calendar, running);
                case 2 -> menuTask(console, calendar, running);
                case 0 -> running = false;
            }
        }
    }

    public static void menu1() {
        System.out.println("1. Add meeting");
        System.out.println("2. Remove meeting");
        System.out.println("3. Show meetings of a day");
        System.out.println("4. Show meetings of a day with a priority");
        System.out.println("5. Show meetings of a day from a specific time");
        System.out.println("6. Show meetings of a day from a specific time to specific time");
        System.out.println("7. Show meetings of a day with priority from a specific time");
        System.out.println("0. Exit");
        System.out.println("Choose an option by selecting number (int): ");
    }

    public static void menu2() {
        System.out.println("1. Add task");
        System.out.println("2. Remove task");
        System.out.println("3. Show tasks of a day");
        System.out.println("4. Show tasks of a day with a status");
        System.out.println("5. Show tasks of a day from a specific time");
        System.out.println("6. Show tasks of a day from a specific time to specific time");
        System.out.println("7. Show tasks of a day with status from a specific time");
        System.out.println("0. Exit");
        System.out.println("Choose an option by selecting number (int): ");
    }

    public static void menu3() {
        System.out.println("1. Manage meetings");
        System.out.println("2. Manage tasks");
        System.out.println("0. Exit");
        System.out.println("Choose an option by selecting number (int): ");
    }

    public static void menuMeeting(Scanner console, Calendar calendar, Boolean running) {
        menu1();
        int chosenOption = console.nextInt();
        switch (chosenOption) {
            case 1 -> addMeeting(calendar, console);
            case 2 -> removeMeeting(calendar, console);
            case 3 -> printMeetingsOfADay(calendar, console);
            case 4 -> printMeetingsOfDayWithPriority(calendar, console);
            case 5 -> printMeetingsOfDayWithStartTime(calendar, console);
            case 6 -> printMeetingsOfDayFromTimeToTime(calendar, console);
            case 7 -> printMeetingsOfDayWithPriorityAndStartTime(calendar, console);
            case 0 -> running = false;
        }
    }

    public static void menuTask(Scanner console, Calendar calendar, Boolean running) {
        menu2();
        int chosenOption = console.nextInt();
        switch (chosenOption) {
            case 1 -> addTask(calendar, console);
            case 2 -> removeTask(calendar, console);
            case 3 -> printTasksOfADay(calendar, console);
            case 4 -> printTasksOfDayWithPriority(calendar, console);
            case 5 -> printTasksOfDayWithStartTime(calendar, console);
            case 6 -> printTasksOfDayFromTimeToTime(calendar, console);
            case 7 -> printTasksOfDayWithStatusAndStartTime(calendar, console);
            case 0 -> running = false;
        }
    }
    public static void addMeeting(Calendar calendar, Scanner console) {
        System.out.println("Select day (1-7):");
        int givenDay = console.nextInt();
        System.out.println("Enter description:");
        String givenDescription = console.next();
        System.out.println("Enter start time (hh:mm):");
        LocalTime givenStartTime = LocalTime.parse(console.next());
        System.out.println("Enter end time (hh:mm):");
        LocalTime givenEndTime = LocalTime.parse(console.next());
        System.out.println("Select priority (NORMAL, HIGH, HIGHEST):");
        String givenPriorityString = console.next().toUpperCase();
        Priority givenPriority;
        try {
            givenPriority = Priority.valueOf(givenPriorityString);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid priority. Please enter NORMAL, HIGH, or HIGHEST.");
            return;
        }
        calendar.addMeeting(givenDay, givenDescription, givenStartTime, givenEndTime, givenPriority);
    }

    public static void addTask(Calendar calendar, Scanner console) {
        System.out.println("Select day (1-7):");
        int givenDay = console.nextInt();
        System.out.println("Enter description:");
        String givenDescription = console.next();
        System.out.println("Enter start time (hh:mm):");
        LocalTime givenStartTime = LocalTime.parse(console.next());
        System.out.println("Enter end time (hh:mm):");
        LocalTime givenEndTime = LocalTime.parse(console.next());
        System.out.println("Select status (PLANNED, CONFIRMED, IN_PROGRESS, DONE):");
        String givenStatusString = console.next().toUpperCase();
        Status givenStatus;
        try {
            givenStatus = Status.valueOf(givenStatusString);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid status. Please enter PLANNED, CONFIRMED, IN_PROGRESS, DONE.");
            return;
        }
        calendar.addMeeting(givenDay, givenDescription, givenStartTime, givenEndTime, givenStatus);
    }
    public static void removeMeeting(Calendar calendar, Scanner console) {
        System.out.println("Select day (1-7):");
        int givenDay = console.nextInt();
        for (Activity meeting : calendar.meetings.get(givenDay - 1)) {
            int index = calendar.meetings.get(givenDay - 1).indexOf(meeting) + 1;
            if (meeting instanceof Meeting) {
                System.out.println("Index: " + index + "\n" + meeting.toString());
            }
        }
        System.out.println("Select index of meeting to remove:");
        int givenIndex = console.nextInt();
        calendar.removeMeeting(givenDay, givenIndex);
    }

    public static void removeTask(Calendar calendar, Scanner console) {
        System.out.println("Select day (1-7):");
        int givenDay = console.nextInt();
        for (Activity meeting : calendar.meetings.get(givenDay - 1)) {
            int index = calendar.meetings.get(givenDay - 1).indexOf(meeting) + 1;
            if (meeting instanceof Task) {
                System.out.println("Index: " + index + "\n" + meeting.toString());
            }
        }
        System.out.println("Select index of meeting to remove:");
        int givenIndex = console.nextInt();
        calendar.removeMeeting(givenDay, givenIndex);
    }

    public static void printMeetingsOfADay(Calendar calendar, Scanner console) {
        System.out.println("Select day (1-7):");
        int givenDay = console.nextInt();
        ArrayList<Activity> meetings = calendar.filterMeetingsDuringADay(givenDay, (meeting) -> meeting instanceof Meeting);
        for (Activity meeting : meetings) {
            System.out.println(meeting.toString());
        }
    }

    public static void printMeetingsOfDayWithPriority(Calendar calendar, Scanner console) {
        System.out.println("Select day (1-7):");
        int givenDay = console.nextInt();
        console.nextLine();
        System.out.println("Select priority (NORMAL, HIGH, HIGHEST):");
        String givenPriorityString = console.next().toUpperCase();
        console.nextLine();
        Priority givenPriority;
        try {
            givenPriority = Priority.valueOf(givenPriorityString);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid priority. Please enter NORMAL, HIGH, or HIGHEST.");
            return;
        }

        ArrayList<Activity> meetings = calendar.filterMeetingsDuringADay(givenDay, (meeting) -> meeting instanceof Meeting && ((Meeting) meeting).getPriority() == givenPriority);
        for (Activity activity : meetings) {
            if (activity instanceof Meeting meeting) {
                System.out.println(meeting.toString());
            }
        }
    }

    public static void printMeetingsOfDayWithStartTime(Calendar calendar, Scanner console) {
        System.out.println("Select day (1-7):");
        int givenDay = console.nextInt();
        console.nextLine();
        System.out.println("Select time (hh:mm):");
        LocalTime givenTime = LocalTime.parse(console.next());
        console.nextLine();
        ArrayList<Activity> meetings = calendar.filterMeetingsDuringADay(givenDay, (meeting -> meeting != null && !meeting.getStartTime().isBefore(givenTime)));
        for (Activity activity : meetings) {
            if (activity instanceof Meeting meeting) {
                System.out.println(meeting.toString());
            }
        }
    }

    public static void printMeetingsOfDayFromTimeToTime(Calendar calendar, Scanner console) {
        System.out.println("Select day (1-7):");
        int givenDay = console.nextInt();
        console.nextLine();
        System.out.println("Select start time (hh:mm):");
        LocalTime fromTime = LocalTime.parse(console.next());
        console.nextLine();
        System.out.println("Select end time (hh:mm):");
        LocalTime endTime = LocalTime.parse(console.next());
        console.nextLine();
        ArrayList<Activity> meetings = calendar.filterMeetingsDuringADay(givenDay, meeting -> meeting != null && !meeting.getStartTime().isBefore(fromTime) && !meeting.getEndTime().isAfter(endTime));
        for (Activity activity : meetings) {
            if (activity instanceof Meeting meeting) {
                System.out.println(meeting.toString());
            }
        }
    }

    public static void printMeetingsOfDayWithPriorityAndStartTime(Calendar calendar, Scanner console) {
        System.out.println("Select day (1-7):");
        int givenDay = console.nextInt();
        console.nextLine();
        System.out.println("Select priority (NORMAL, HIGH, HIGHEST):");
        String givenPriorityString = console.next().toUpperCase();
        console.nextLine();
        Priority givenPriority;
        try {
            givenPriority = Priority.valueOf(givenPriorityString);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid priority. Please enter NORMAL, HIGH, or HIGHEST.");
            return;
        }
        System.out.println("Select time (hh:mm):");
        LocalTime givenTime = LocalTime.parse(console.next());
        console.nextLine();
        ArrayList<Activity> meetings = calendar.filterMeetingsDuringADay(givenDay, meeting -> meeting instanceof Meeting && !meeting.getStartTime().isBefore(givenTime) && ((Meeting) meeting).getPriority() == givenPriority);
        for (Activity activity : meetings) {
            if (activity instanceof Meeting meeting) {
                System.out.println(meeting.toString());
            }
        }
    }

    public static void printTasksOfADay(Calendar calendar, Scanner console) {
        System.out.println("Select day (1-7):");
        int givenDay = console.nextInt();
        ArrayList<Activity> meetings = calendar.filterMeetingsDuringADay(givenDay, (meeting) -> meeting instanceof Task);
        for (Activity meeting : meetings) {
            System.out.println(meeting.toString());
        }
    }

    public static void printTasksOfDayWithPriority(Calendar calendar, Scanner console) {
        System.out.println("Select day (1-7):");
        int givenDay = console.nextInt();
        console.nextLine();
        System.out.println("Select priority (PLANNED, CONFIRMED, IN_PROGRESS, DONE):");
        String givenStatusString = console.next().toUpperCase();
        console.nextLine();
        Status givenStatus;
        try {
            givenStatus = Status.valueOf(givenStatusString);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid priority. Please enter (PLANNED, CONFIRMED, IN_PROGRESS, DONE)");
            return;
        }

        ArrayList<Activity> meetings = calendar.filterMeetingsDuringADay(givenDay, (meeting) -> meeting instanceof Task && ((Task) meeting).getStatus() == givenStatus);
        for (Activity activity : meetings) {
            if (activity instanceof Task meeting) {
                System.out.println(meeting.toString());
            }
        }
    }

    public static void printTasksOfDayWithStartTime(Calendar calendar, Scanner console) {
        System.out.println("Select day (1-7):");
        int givenDay = console.nextInt();
        console.nextLine();
        System.out.println("Select time (hh:mm):");
        LocalTime givenTime = LocalTime.parse(console.next());
        console.nextLine();
        ArrayList<Activity> meetings = calendar.filterMeetingsDuringADay(givenDay, (meeting -> meeting instanceof Task && !meeting.getStartTime().isBefore(givenTime)));
        for (Activity activity : meetings) {
            if (activity instanceof Task meeting) {
                int index = meetings.indexOf(meeting);
                System.out.println("Index:" + index + "\n" + meeting.toString());
            }
        }
    }

    public static void printTasksOfDayFromTimeToTime(Calendar calendar, Scanner console) {
        System.out.println("Select day (1-7):");
        int givenDay = console.nextInt();
        console.nextLine();
        System.out.println("Select start time (hh:mm):");
        LocalTime fromTime = LocalTime.parse(console.next());
        console.nextLine();
        System.out.println("Select end time (hh:mm):");
        LocalTime endTime = LocalTime.parse(console.next());
        console.nextLine();
        ArrayList<Activity> meetings = calendar.filterMeetingsDuringADay(givenDay, meeting -> meeting instanceof Task && !meeting.getStartTime().isBefore(fromTime) && !meeting.getEndTime().isAfter(endTime));
        for (Activity activity : meetings) {
            if (activity instanceof Task meeting) {
                System.out.println(meeting.toString());
            }
        }
    }

    public static void printTasksOfDayWithStatusAndStartTime(Calendar calendar, Scanner console) {
        System.out.println("Select day (1-7):");
        int givenDay = console.nextInt();
        console.nextLine();
        System.out.println("Select priority (PLANNED, CONFIRMED, IN_PROGRESS, DONE):");
        String givenStatusString = console.next().toUpperCase();
        console.nextLine();
        Status givenStatus;
        try {
            givenStatus = Status.valueOf(givenStatusString);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid priority. Please enter (PLANNED, CONFIRMED, IN_PROGRESS, DONE).");
            return;
        }
        System.out.println("Select time (hh:mm):");
        LocalTime givenTime = LocalTime.parse(console.next());
        console.nextLine();
        ArrayList<Activity> meetings = calendar.filterMeetingsDuringADay(givenDay, meeting -> meeting instanceof Task && !meeting.getStartTime().isBefore(givenTime) && ((Task) meeting).getStatus() == givenStatus);
        for (Activity activity : meetings) {
            if (activity instanceof Task meeting) {
                System.out.println(meeting.toString());
            }
        }
    }

}