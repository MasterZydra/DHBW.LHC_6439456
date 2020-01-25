package infrastructure.security;

import human_resources.Person;

public class EmployeeIDCard extends IDCard {
    private Chip fingerPrintChip;
    private Chip passwordChip;

    public EmployeeIDCard(Person person) {
        super(person);
        this.fingerPrintChip = new Chip();
        this.passwordChip = new Chip();
    }
}
