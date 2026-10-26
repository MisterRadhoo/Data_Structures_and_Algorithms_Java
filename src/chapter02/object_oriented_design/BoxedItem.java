package chapter02.object_oriented_design;

/** CLass for objects that can be sold, packed, and shipped. */
public class BoxedItem implements  Sellable, Transportable {

    private String description;        // description of this item
    private int price;                 // list price in cents
    private int weight;                // weight in grams
    private boolean hazardous;          // true if object is hazardous
    private int height = 0;             // box height in centimeters
    private int width = 0;              // box width in centimeters
    private int depth = 0;              // box depth in centimeters

    /** Constructor */
    public BoxedItem(String description, int price, int weight, boolean hazardous) {
        this.description = description;
        this.price = price;
        this.weight = weight;
        this.hazardous = hazardous;
    }

    @Override
    public String description () {
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

    @Override
    public int weight() {
        return this.weight;
    }

    @Override
    public boolean isHazardous() {
        return this.hazardous;
    }

    public int insuredValue() {
        return this.price * 2;
    }

    public void setBox(int height, int width, int depth) {
        this.height = height;
        this.width = width;
        this.depth = depth;
    }

    // main
    public static void main(String[] args) {

        BoxedItem boxedItem = new BoxedItem("DSA Book", 200, 450, false);
        System.out.println(boxedItem.description());
        System.out.println(boxedItem.listPrice() + " cents");
        System.out.println(boxedItem.weight() + " grams");
        System.out.println("Is hazardous: " + boxedItem.isHazardous());
        System.out.println("Insured value: " + boxedItem.insuredValue() + " cents");

        boxedItem.setBox(10, 9, 7);
    }

}
