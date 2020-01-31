package infrastructure.security;

public class Slot implements ICommunication {
    private String curData;

    public String getData() {
        return this.curData;
    }

    public void setData(String data) {
        this.curData = data;
    }
}
