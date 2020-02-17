package main.infrastructure.lhc;

import main.infrastructure.energy.IUSP;

public interface ILargeHadronCollider {
    IRing getRing();
    IUSP[] getUSPs();
}
