package main.infrastructure.security;

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
        StringBuilder ret = new StringBuilder("'" + this.getId() + "', '");
        ret.append(this.getValidFrom().toString() + "', '");
        ret.append(this.getValidUntil().toString() + "', '");
        for (int i = 0; i < this.getIrisStructure().length; i++) {
            for (int j = 0; j < this.getIrisStructure()[i].length; j++) {
                ret.append(Integer.toString(this.getIrisStructure()[i][j]) + ",");
            }
        }
        ret.append("', " + this.getIsLocked() + ", ");
        this.getPermissionList().forEach((e) -> {
            ret.append(e.toString() + ',');
        });
        ret.append("', " + Integer.toString(this.getInvalidPasswordCounter()) + ", " + this.getPerson().getID());
        ret.append(", '" + this.passwordChip + "', '" + this.fingerPrintChip + "'");

        return ret.toString();
    }
}
