package infrastructure;

import human_resources.IReceptionStaff;
import infrastructure.security.*;

public interface IReception {
    void setReceptionStaff(IReceptionStaff receptionStaff);
    IReceptionStaff getReceptionStaff();
    IIDCard getBlankIDCard();
    IWriter getWriter();
    void addVisitorIDCard(IIDCard idCard);
}
