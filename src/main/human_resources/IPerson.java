package main.human_resources;

import main.infrastructure.security.IIDCard;

public interface IPerson
{
    void setIDCard(IIDCard idCard);
    String getName();
    String enterPassword();
    IIDCard getIdCard();
    int[][] getIris();
    String getFingerPrint();
    int getID();
}
