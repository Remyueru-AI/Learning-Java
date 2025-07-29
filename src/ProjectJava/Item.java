package ProjectJava;

public class Item {

    private int id, amount;
    private String name;

    public Item(int id, String name, int amount) {
        this.id = id;
        this.name = name;
        this.amount = amount;
    }

    public Item(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public Item() {
        this.id = 0;
        this.name = null;
        this.amount = 0;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getAmount() {
        return this.amount;
    }

}
