package gr.teicm.game.model;

public class Item {
    private String itemName;
    private String itemDescription;
    private ItemType type;
    private Boolean takable;
    private String ItemLocation;

    public Item(String itemName, String itemDescription, ItemType type, Boolean takable, String ItemLocation) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.type = type;
        this.takable = takable;
        this.ItemLocation =ItemLocation;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public ItemType getType() {
        return type;
    }

    public Boolean isTakable() {
        return takable;
    }

    public String getItemLocation() {
        return ItemLocation ;
    }
}
