// From Reges and Stepp
// Modified by LFW

import java.text.DecimalFormat;

public class Stock 
{
    private static DecimalFormat fmt = new DecimalFormat("$0.00");

    private String symbol;    // stock symbol, e.g. "YHOO"
    private double totalShares;  // total shares purchased
    private double totalCost;

    public Stock(String theSymbol) 
    {
        if (theSymbol == null) 
        {
            throw new IllegalArgumentException(
                "null symbol in constructor");
        }
        symbol = theSymbol;
        totalShares = 0;
        totalCost = 0.0;
    }
    
    public String getSymbol()
    {
        return symbol;
    }
    
    public double getTotalCost()
    {
        return totalCost;
    }
    
    public double getTotalShares()
    {
        return totalShares;
    }
    
    public double getProfit(double currentPrice) 
    {
        if (currentPrice < 0.0) 
        {
            throw new IllegalArgumentException("Cannot have negative price");
        }

        double marketValue = totalShares * currentPrice;
        return marketValue - totalCost;
    }
    
    public void purchase(double shares, double pricePerShare) {
        if (shares < 0 || pricePerShare < 0.0) {
            throw new IllegalArgumentException(
                "Invalid number of shares or price per share");
        }
    
        totalShares += shares;
        totalCost += shares * pricePerShare;
    }

    public String toString()
    {
        return totalShares + " shares of " + symbol + " at a total cost of "
            + fmt.format(totalCost);
    }
}
