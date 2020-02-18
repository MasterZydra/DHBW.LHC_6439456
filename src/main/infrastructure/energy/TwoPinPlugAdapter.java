package main.infrastructure.energy;

public class TwoPinPlugAdapter extends TwoPinPlug implements IThreePinPlug {
    public void giveEnergyOnThreePins() {
        super.giveEnergyOnTwoPins();
    }
}
