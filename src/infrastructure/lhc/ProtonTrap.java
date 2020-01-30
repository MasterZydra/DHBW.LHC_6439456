package infrastructure.lhc;

import infrastructure.Configuration;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.Queue;

public class ProtonTrap implements IProtonTrap {
    private ProtonTrapID id;

    private Queue<IProton> protons;
    private IRing ring;

    public ProtonTrap(ProtonTrapID trapID) {
        this.id = trapID;
        this.protons = new ArrayDeque<>();
        for (int i = trapID.equals(ProtonTrapID.A) ? 1 : 2; i <= 50; i += 2) {
            loadData(i, Configuration.instance.protonData + "proton_" + String.format("%02d", i) + ".txt");
        }
    }

    public void loadData(int id, String dataFilePath) {
        try {
            String content = new String(Files.readAllBytes(Paths.get(dataFilePath)));
            int[][][] structure = new int[100][100][100];
            int pos = 0;
            for (int i = 0; i < structure.length; i++) {
                for (int j = 0; j < structure[i].length; j++) {
                    for (int k = 0; k < structure[i][j].length; k++) {
                        structure[i][j][k] = content.charAt(pos);
                        pos++;
                    }
                }
            }
            protons.add(new Proton(id, structure));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public IProton release() {
        return this.protons.poll();
    }
}
