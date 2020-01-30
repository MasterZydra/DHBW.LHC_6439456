package infrastructure.lhc;

public class Magnet implements IMagnet {
    private boolean isActivated;
    private MagneticDirection direction;
    private int fieldStrength;

    public Magnet() {
        this.isActivated = false;
        this.direction = MagneticDirection.N;
        this.fieldStrength = 1;
    }

    @Override
    public void activate() {
        this.isActivated = true;
    }

    @Override
    public void deactivated() {
        this.isActivated = false;
    }
}
