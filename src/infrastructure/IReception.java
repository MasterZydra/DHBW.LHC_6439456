package infrastructure;

import human_resources.IReceptionStaff;
import infrastructure.security.*;

public interface IReception {
    void setReceptionStaff(IReceptionStaff receptionStaff);
    IReceptionStaff getReceptionStaff();
    IDCard getBlankIDCard();
    IWriter getWriter();
    void addVisitorIDCard(IIDCard idCard);
}
