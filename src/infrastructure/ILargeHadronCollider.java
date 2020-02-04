package infrastructure;

import infrastructure.energy.IUSP;
import infrastructure.lhc.*;

public interface ILargeHadronCollider {
    void setBuilding(IBuilding building);
    void setRing(IRing ring);
    void setUSPs(IUSP usp1, IUSP usp2);
}
