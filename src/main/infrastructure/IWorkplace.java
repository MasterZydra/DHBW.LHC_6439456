package main.infrastructure;

import main.human_resources.*;

public interface IWorkplace {
    IResearchGroup getResearchGroup();
    void setResearchGroup(IResearchGroup researchGroup);
}
