package infrastructure.security;

public class Chip implements IChip {
    private String data;

    @Override
    public String toString() {
        return this.data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
