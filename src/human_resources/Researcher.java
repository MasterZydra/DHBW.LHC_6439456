package human_resources;

import java.util.ArrayList;

public class Researcher extends Employee {
    private boolean isSensior;

    private ArrayList<ResearchGroup> researchGroups;

    public Researcher() {
        this.researchGroups = new ArrayList<>();
    }
}
