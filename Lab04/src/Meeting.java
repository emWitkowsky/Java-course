import java.time.DateTimeException;
import java.time.LocalTime;

public final class Meeting extends Activity {
    private Priority priority;

    private static final LocalTime MIN_POSSIBLE_TIME = LocalTime.of(7, 59, 59);

    public Meeting(String description, LocalTime startTime, LocalTime endTime, Priority priority) {
        super(description, startTime, endTime);
        this.priority = priority;
        if (startTime.isBefore(MIN_POSSIBLE_TIME))
            throw new IllegalArgumentException("Czas początkowy musi być później niż 8:00");
    }

    @Override
    public String toString() {
        return this.startTime.toString() + " - " + this.endTime.toString() + "\n" +
                "Priority: " + this.priority.stringValue + "\n" +
                "Description: " + this.description + "\n";
    }

    public Priority getPriority() {
        return this.priority;
    }

}