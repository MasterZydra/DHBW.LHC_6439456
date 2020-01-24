package human_resources;

public abstract class Person {
    protected int id;
    protected String name;
    protected int[][] iris;

    protected IDCard idCard;
    protected Passport passport;

    public Person() {
        this.iris = new int[10][10];
    }
}
