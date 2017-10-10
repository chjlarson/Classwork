// Item.java

import java.text.DecimalFormat;

public class Item
{
    private static DecimalFormat fmt = new DecimalFormat("$0.00");

    private String name;
    private double price;

    // Initializes the object with name and price
    public Item(String name, double price)
    {
        this.name = name;
        this.price = price;
    }

    // Returns the name
    public String getName()
    {
        return name;
    }

    // Returns the price
    public double getPrice()
    {
        return price;
    }

    // Sets the name using the parameter
    public void setName(String name)
    {
        this.name = name;
    }

    // Sets the price using the parameter
    public void setPrice(double price)
    {
        this.price = price;
    }

    // Returns the string version of the object
    public String toString()
    {
        return name + ", " + fmt.format(price);
    }
}
