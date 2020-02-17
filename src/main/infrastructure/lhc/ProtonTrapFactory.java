package main.infrastructure.lhc;

import main.infrastructure.Configuration;

public class ProtonTrapFactory {
    private static void fillTraps(IProtonTrap protonTrap, int startIndex) {
        for (int i = startIndex; i <= 50; i += 2) {
            protonTrap.loadData(i, Configuration.instance.protonData + "proton_" + String.format("%02d", i) + ".txt");
        }
    }

    public static IProtonTrap buildProtonTrapA() {
        IProtonTrap protonTrap = new ProtonTrap(ProtonTrapID.A);
        ProtonTrapFactory.fillTraps(protonTrap, 1);
        return protonTrap;
    }

    public static IProtonTrap buildProtonTrapB() {
        IProtonTrap protonTrap = new ProtonTrap(ProtonTrapID.B);
        ProtonTrapFactory.fillTraps(protonTrap, 2);
        return protonTrap;
    }
}
