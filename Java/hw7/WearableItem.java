// Christopher Larson
// CSCI 239 Homework #7 Problem #1
// WearableItem.java
// 3/3/14
//
// This program will classifies an item in the TLU Bookstore as a wearable
// item.

public class WearableItem extends Item
{

    private String size;

    public static void main(String[] args)
    {
        System.out.println("This program demonstrates minimal testing of "
             + "the WearableItem class.\n");

        WearableItem tshirt = new WearableItem("Yellow T-shirt", 11.99, "XL");
        WearableItem sweatshirt = new WearableItem("Black Sweatshirt", 24.99,
            "Medium");

        System.out.println("Created two wearable items: ");
        System.out.println("Item 1: " + tshirt);
        System.out.println("Item 2: " + sweatshirt + "\n");

        String size = tshirt.getSize();
        if (size.equals("XL"))
            System.out.println("CORRECT: The T-shirt size is XL.\n");
        else
            System.out.println("ERROR: The T-shirt size is " + size + ".\n");

        // Make sure that a WearableItem is also an Item
        if (tshirt instanceof Item)
            System.out.println("CORRECT: A WearableItem is also an Item.\n");
        else
            System.out.println("ERROR: A WearableItem is not an Item.\n");

        // Rare case of calling toString directly, to make sure the format 
        // is correct
        String output = tshirt.toString();
        if (output.equals("Yellow T-shirt, $11.99, XL"))
            System.out.println("CORRECT: The format of toString is correct.");
        else
            System.out.println("ERROR: The format of toString is NOT correct.");
    }
    
    // Initializes the object with parameters for all data
    // relevant for a WearableItem
    public WearableItem(String name, double price, String size)
    {
        super(name, price);
        this.size = size;
    }


    // Returns the size
    public String getSize()
    {
        return size;
    }

    // Sets the size with the parameter
    public void setSize(String size)
    {
        this.size = size;
    }

    // Returns a String representation of a WearableItem
    public String toString()
    {
        return super.toString() + ", " +  size;
    }

}
