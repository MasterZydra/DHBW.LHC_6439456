package human_resources;

import infrastructure.Workplace;

import java.util.ArrayList;

public class ResearchGroup {
    private Workplace workplace;
    private ArrayList<Researcher> researchers;
    private ArrayList<ScientificAssistant> scientificAssistants;

    public ResearchGroup(Researcher researcher) {
        this.researchers = new ArrayList<>();
        this.scientificAssistants = new ArrayList<>();

        this.researchers.add(researcher);
    }
}
