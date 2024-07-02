import java.time.LocalTime;

public sealed abstract class Activity permits Meeting, Task {
    protected String description;
    protected LocalTime startTime;
    protected LocalTime endTime;

    public Activity(String description, LocalTime startTime, LocalTime endTime) {
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    protected LocalTime getStartTime() {
        return this.startTime;
    }
    protected LocalTime getEndTime() {
        return this.endTime;
    }
}
