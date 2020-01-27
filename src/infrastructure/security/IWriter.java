package infrastructure.security;

import java.util.ArrayList;
import java.util.Date;

public interface IWriter {
    void setIDCard(IIDCard idCard);
    void setValidFrom(Date date);
    void setValidUntil(Date date);
    void setIrisStructure(int[][] irisStructure);
    void setPermissionList(ArrayList<Permission> permissionList);
    void setPassword(String password);
    void setIsLocked(Boolean isLocked);
}
