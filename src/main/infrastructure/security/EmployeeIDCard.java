package main.infrastructure.security;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class EmployeeIDCard extends IDCard {
    private IChip fingerPrintChip;
    private IChip passwordChip;

    public EmployeeIDCard(String id) {
        super(id);
        this.fingerPrintChip = new Chip();
        this.passwordChip = new Chip();
    }

    public void setPassword(String password) {
        this.passwordChip.setData(password);
        this.communication.setData(password);
    }

    @Override
    public String toString() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        StringBuilder ret = new StringBuilder("'" + this.getId() + "', DATE '");
        ret.append(dateFormat.format(this.getValidFrom()) + "', DATE '");
        ret.append(dateFormat.format(this.getValidUntil()) + "', '");
        for (int i = 0; i < this.getIrisStructure().length; i++) {
            for (int j = 0; j < this.getIrisStructure()[i].length; j++) {
                ret.append(Integer.toString(this.getIrisStructure()[i][j]) + ",");
            }
        }
        ret.append("', " + this.getIsLocked() + ", '");
        this.getPermissionList().forEach((e) -> {
            ret.append(e.toString() + ',');
        });
        ret.append("', " + Integer.toString(this.getInvalidPasswordCounter()) + ", " + this.getPerson().getID());
        ret.append(", '" + this.passwordChip + "', '" + this.fingerPrintChip + "'");

        return ret.toString();
    }
}
