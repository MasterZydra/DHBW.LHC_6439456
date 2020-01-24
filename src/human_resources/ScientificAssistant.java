package human_resources;

import java.util.ArrayList;
import java.util.Date;

public class ScientificAssistant extends Employee {
    private Date periodFrom;
    private Date periodUntil;

    private ArrayList<ResearchGroup> researchGroups;

    public ScientificAssistant() {
        this.researchGroups = new ArrayList<>();
    }
}
