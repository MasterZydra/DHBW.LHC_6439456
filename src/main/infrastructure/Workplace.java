package main.infrastructure;

import main.human_resources.*;

public class Workplace implements IWorkplace {
    private IControlCenter controlCenter;
    private IResearchGroup researchGroup;

    public Workplace() {
        this.controlCenter = ControlCenter.instance;
    }

    public IResearchGroup getResearchGroup()
    {
        return researchGroup;
    }

    public void setResearchGroup(IResearchGroup researchGroup)
    {
        this.researchGroup = researchGroup;
    }
}
