public enum Status {
    PLANNED("planowane"),
    CONFIRMED("potwierdzone"),
    IN_PROGRESS("realizowane"),
    DONE("wykonane");

    public final String stringValue;

    Status(String priority) {
        this.stringValue = priority;
    }
}
