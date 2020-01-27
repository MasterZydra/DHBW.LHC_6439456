package human_resources;

import infrastructure.security.IDCard;
import infrastructure.security.IIDCard;

import java.util.Random;

public abstract class Person {
    protected int id;
    protected String name;
    protected int[][] iris;

    protected IIDCard idCard;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;

        this.iris = new int[10][10];

        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                this.iris[i][j] = random.nextInt();
            }
        }
    }

    public void setIDCard(IIDCard idCard) {
        this.idCard = idCard;
        this.idCard.setPerson(this);
    }

    public String getName() {
        return this.name;
    }

    public String enterPassword() {
        return "12345";
        // TODO Von Konsole oder NAme+Id mit max. 5 Stellen
    }

    public IIDCard getIdCard() {
        return this.idCard;
    }

    @Override
    public String toString() {
        return Integer.toString(this.id) + " - " + this.name;
    }
}
