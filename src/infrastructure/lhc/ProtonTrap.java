package infrastructure.lhc;

import infrastructure.Configuration;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ProtonTrap implements IProtonTrap {
    private ProtonTrapID id;

    private List<Proton> protons;
    private IRing ring;

    public ProtonTrap(ProtonTrapID trapID, boolean odd) {
        this.id = trapID;
        this.protons = new ArrayList<>();
        for (int i = odd ? 1 : 2; i <= 50; i += 2) {
            loadData(Configuration.instance.protonData + "proton_" + String.format("%02d", i) + ".txt");
        }
    }

    public void loadData(String dataFilePath) {
        try {
            String content = new String(Files.readAllBytes(Paths.get(dataFilePath)));
            int[][][] structure = new int[100][100][100];
            int pos = 0;
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    for (int k = 0; k < 100; k++) {
                        structure[i][j][k] = content.charAt(pos);
                        pos++;
                    }
                }
            }
            protons.add(new Proton(structure));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void release() {

    }
}
