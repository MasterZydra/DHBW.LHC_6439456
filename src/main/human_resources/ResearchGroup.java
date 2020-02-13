package main.human_resources;

import main.infrastructure.*;

import java.util.ArrayList;
import java.util.List;

public class ResearchGroup implements IResearchGroup {
    private IWorkplace workplace;
    private List<Researcher> researchers;
    private List<ScientificAssistant> scientificAssistants;

    public ResearchGroup(Researcher researcher) {
        this.researchers = new ArrayList<>();
        this.scientificAssistants = new ArrayList<>();

        this.researchers.add(researcher);
    }

    public IWorkplace getWorkplace()
    {
        return workplace;
    }

    public void setWorkplace(IWorkplace workplace)
    {
        this.workplace = workplace;
    }

    public List<Researcher> getResearchers()
    {
        return this.researchers;
    }
}
