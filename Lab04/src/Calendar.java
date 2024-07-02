import java.time.LocalTime;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class Calendar {
    public ArrayList<ArrayList<Activity>> meetings;

    public final int NUMBER_OF_DAYS_IN_WEEK = 7;
    public int numberOfWeeks;

    public Calendar() {
        this(1);
    }

    public Calendar(int numberOfWeeks) {
        this.numberOfWeeks = numberOfWeeks;
        this.meetings = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_DAYS_IN_WEEK * numberOfWeeks; i++) {
            this.meetings.add(new ArrayList<>());
        }
    }

    public void addMeeting(int day, String description, LocalTime startTime, LocalTime endTime, Priority priority) {
        this.meetings.get(day - 1).add(new Meeting(description, startTime, endTime, priority));
    }

    public void addMeeting(int day, String description, LocalTime startTime, LocalTime endTime, Status status) {
        this.meetings.get(day - 1).add(new Task(description, startTime, endTime, status));
    }

    public void addMockMeetings() {
        this.addMeeting(1, "Spotkanie 1", LocalTime.of(9, 0), LocalTime.of(10, 0), Priority.NORMAL);
        this.addMeeting(1, "Zadanie 1", LocalTime.of(10, 0), LocalTime.of(12, 0), Status.IN_PROGRESS);
        this.addMeeting(1, "Zadanie 2", LocalTime.of(11, 0), LocalTime.of(14, 0), Status.PLANNED);
        this.addMeeting(1, "Spotkanie 2", LocalTime.of(12, 0), LocalTime.of(16, 0), Priority.HIGHEST);

        this.addMeeting(2, "Spotkanie 1", LocalTime.of(9, 0), LocalTime.of(10, 0), Priority.NORMAL);
        this.addMeeting(2, "Spotkanie 2", LocalTime.of(10, 0), LocalTime.of(12, 0), Priority.HIGH);
        this.addMeeting(2, "Spotkanie 3", LocalTime.of(11, 0), LocalTime.of(14, 0), Priority.NORMAL);
        this.addMeeting(2, "Spotkanie 4", LocalTime.of(12, 0), LocalTime.of(16, 0), Priority.NORMAL);
        this.addMeeting(2, "Zadanie 1", LocalTime.of(9, 0), LocalTime.of(10, 0), Status.DONE);
        this.addMeeting(2, "Zadanie 2", LocalTime.of(10, 0), LocalTime.of(12, 0), Status.CONFIRMED);
        this.addMeeting(2, "Zadanie 3", LocalTime.of(11, 0), LocalTime.of(14, 0), Status.IN_PROGRESS);
        this.addMeeting(2, "Zadanie 4", LocalTime.of(12, 0), LocalTime.of(16, 0), Status.PLANNED);

        this.addMeeting(3, "Spotkanie 1", LocalTime.of(9, 0), LocalTime.of(10, 0), Priority.NORMAL);
        this.addMeeting(3, "Spotkanie 2", LocalTime.of(10, 0), LocalTime.of(12, 0), Priority.HIGH);
        this.addMeeting(3, "Spotkanie 3", LocalTime.of(11, 0), LocalTime.of(14, 0), Priority.NORMAL);
        this.addMeeting(3, "Spotkanie 4", LocalTime.of(12, 0), LocalTime.of(16, 0), Priority.NORMAL);

        this.addMeeting(4, "Spotkanie 1", LocalTime.of(9, 0), LocalTime.of(10, 0), Priority.NORMAL);
        this.addMeeting(4, "Spotkanie 2", LocalTime.of(10, 0), LocalTime.of(12, 0), Priority.HIGH);
        this.addMeeting(4, "Spotkanie 3", LocalTime.of(11, 0), LocalTime.of(14, 0), Priority.NORMAL);
        this.addMeeting(4, "Spotkanie 4", LocalTime.of(12, 0), LocalTime.of(16, 0), Priority.NORMAL);

        this.addMeeting(5, "Spotkanie 1", LocalTime.of(9, 0), LocalTime.of(10, 0), Priority.NORMAL);
        this.addMeeting(5, "Spotkanie 2", LocalTime.of(10, 0), LocalTime.of(12, 0), Priority.HIGH);
        this.addMeeting(5, "Spotkanie 3", LocalTime.of(11, 0), LocalTime.of(14, 0), Priority.NORMAL);
        this.addMeeting(5, "Spotkanie 4", LocalTime.of(12, 0), LocalTime.of(16, 0), Priority.NORMAL);

        this.addMeeting(6, "Spotkanie 1", LocalTime.of(9, 0), LocalTime.of(10, 0), Priority.NORMAL);
        this.addMeeting(6, "Spotkanie 2", LocalTime.of(10, 0), LocalTime.of(12, 0), Priority.HIGH);
        this.addMeeting(6, "Spotkanie 3", LocalTime.of(11, 0), LocalTime.of(14, 0), Priority.NORMAL);
        this.addMeeting(6, "Spotkanie 4", LocalTime.of(12, 0), LocalTime.of(16, 0), Priority.NORMAL);

        this.addMeeting(7, "Spotkanie 1", LocalTime.of(9, 0), LocalTime.of(10, 0), Priority.NORMAL);
        this.addMeeting(7, "Spotkanie 2", LocalTime.of(10, 0), LocalTime.of(12, 0), Priority.HIGH);
        this.addMeeting(7, "Spotkanie 3", LocalTime.of(11, 0), LocalTime.of(14, 0), Priority.NORMAL);
        this.addMeeting(7, "Spotkanie 4", LocalTime.of(12, 0), LocalTime.of(16, 0), Priority.NORMAL);
    }

    public void removeMeeting(int day, int index) {
        this.meetings.get(day - 1).remove(index - 1);
        System.out.println("Nie ma spotkania o podanym indeksie tego dnia!");
    }

//    public String printMeetings(ArrayList<Meeting> meetings) {
//        StringBuilder sb = new StringBuilder();
//        for (var i = 0; i < meetings.size(); i++) {
//            var index = i + 1;
//            sb.append(String.format("Index: %d\n" + "%s", index, meetings.get(i).toString()));
//        }
//        return sb.toString();
//    }
//
//    public void printMeetingsDuringADayMock(int day) {
//        for (var i = 0; i < this.meetings.get(day - 1).size(); i++) {
//            var index = i + 1;
//            System.out.printf("Index: %d\n" + "%s", index, this.meetings.get(day - 1).get(i).toString());
//        }
//    }
    public ArrayList<Activity> filterMeetingsDuringADay(int day, Predicate<Activity> predicate) {
        ArrayList<Activity> filteredMeetings = new ArrayList<>();
        var meetingsInADay = this.meetings.get(day-1);

        for (Activity meeting : meetingsInADay)
            if (predicate.test(meeting)) {
                filteredMeetings.add(meeting);
            }
        return filteredMeetings;
    }
}