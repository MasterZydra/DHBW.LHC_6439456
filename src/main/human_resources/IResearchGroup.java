package main.human_resources;

import main.infrastructure.IWorkplace;

import java.util.List;

public interface IResearchGroup {
    IWorkplace getWorkplace();
    void setWorkplace(IWorkplace workplace);
    List<Researcher> getResearchers();
}
