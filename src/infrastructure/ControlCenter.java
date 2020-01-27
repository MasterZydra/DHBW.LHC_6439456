package infrastructure;

public enum ControlCenter {
    instance;

    private final String roomID;

    private Workplace workplace;

    ControlCenter() {
        this.roomID = "C01";
    }
}
