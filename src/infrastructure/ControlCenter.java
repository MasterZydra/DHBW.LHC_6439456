package infrastructure;

public enum ControlCenter {
    instance;

    private String roomID;

    private Workplace workplace;

    ControlCenter() {
        this.roomID = "C01";
    }
}
