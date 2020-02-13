package main.infrastructure;

import main.infrastructure.energy.IUSP;
import main.infrastructure.lhc.*;

public interface ILargeHadronCollider {
    void setBuilding(IBuilding building);
    void setRing(IRing ring);
    void setUSPs(IUSP usp1, IUSP usp2);
    IRing getRing();
    IUSP[] getUSPs();
}
