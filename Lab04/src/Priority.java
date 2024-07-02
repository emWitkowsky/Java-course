public enum Priority {
    NORMAL("normalny"),
    HIGH("wysoki"),
    HIGHEST("najwyższy");

    public final String stringValue;

    Priority(String priority) {
        this.stringValue = priority;
    }
}