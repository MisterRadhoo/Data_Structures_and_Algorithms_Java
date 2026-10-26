package chapter02.object_oriented_design;

public class Photograph implements Sellable {

    private String description;     // description of the photo
    private int price;               // the price we are setting
    private boolean color;           // true if photo is in color

    // Constructor
    public Photograph(String description, int price, boolean color) {
        this.description = description;
        this.price = price;
        this.color = color;
    }

    @Override
    public String description() {
        return this.description;
    }

    @Override
    public int listPrice() {
        return this.price;
    }

    @Override
    public int lowestPrice() {
        return this.price / 2;
    }

    public boolean isColor() {
        return this.color;
    }
}
