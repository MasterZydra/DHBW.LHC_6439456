package main.infrastructure;

import main.human_resources.IReceptionStaff;
import main.infrastructure.security.*;

public interface IReception {
    void setReceptionStaff(IReceptionStaff receptionStaff);
    IReceptionStaff getReceptionStaff();
    IIDCard getBlankIDCard();
    IWriter getWriter();
    void addVisitorIDCard(IIDCard idCard);
}
