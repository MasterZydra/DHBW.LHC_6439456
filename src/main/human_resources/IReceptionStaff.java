package main.human_resources;

import main.infrastructure.IReception;

public interface IReceptionStaff {
    void createIDCard(Visitor visitor);
    void setReception(IReception reception);
}
