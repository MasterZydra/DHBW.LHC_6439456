package infrastructure.security;

import human_resources.Person;

public class VisitorIDCard extends IDCard {
    private Chip passwordChip;

    public VisitorIDCard(Person person) {
        super(person);
        this.passwordChip = new Chip();
    }
}
