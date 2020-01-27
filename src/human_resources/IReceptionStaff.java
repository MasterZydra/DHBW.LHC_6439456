package human_resources;

import infrastructure.IReception;

public interface IReceptionStaff {
    void createIDCard(Visitor visitor);
    void setReception(IReception reception);
}
