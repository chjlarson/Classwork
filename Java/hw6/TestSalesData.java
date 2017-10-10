// TestSalesData.java

public class TestSalesData
{
    public static void main(String[] args)
    {
        double[] arr1 = {1150, 1132.5, 1005.75, 1278.03, 992.1, 1089.56};
        double[] arr2 = {3900.2, 3008.98, 2879.2, 3510, 2705.2};

        System.out.println("This program tests the SalesData class.\n");

        SalesData sales1 = new SalesData(arr1);
        SalesData sales2 = new SalesData(arr2);

        System.out.println("sales1 data:");
        System.out.println(sales1);

        System.out.println("sales2 data:");
        System.out.println(sales2);

        if (sales1.getNumDays() == 6)
            System.out.println("Correct: sales1 contains 6 days "
                + "of information");
        else
        {
            System.out.println("ERROR: sales1.getNumDays() should return 6");
            System.out.println("  but it returns " + sales1.getNumDays());
        }
        if (sales2.getNumDays() == 5)
            System.out.println("Correct: sales2 contains 5 days "
                + "of information\n");
        else
        {
            System.out.println("ERROR: sales2.getNumDays() should return 5");
            System.out.println("  but it returns " + sales2.getNumDays() + "\n");
        }

        System.out.println("The total value for sales1 should be $6647.94.");
        System.out.printf("The total value for sales1 is $%.2f.\n\n",
            sales1.getTotal());

        System.out.println("The total value for sales2 should be $16003.58.");
        System.out.printf("The total value for sales2 is $%.2f.\n\n",
            sales2.getTotal());

        System.out.println("The minimum value for sales1 should be $992.10.");
        System.out.printf("The minimum value for sales1 is $%.2f.\n\n",
            sales1.getLowest());

        System.out.println("The minimum value for sales2 should be $2705.20.");
        System.out.printf("The minimum value for sales2 is $%.2f.\n\n",
            sales2.getLowest());

        System.out.println("The maximum value for sales1 should be $1278.03.");
        System.out.printf("The maximum value for sales1 is $%.2f.\n\n",
            sales1.getHighest());

        System.out.println("The maximum value for sales2 should be $3900.20.");
        System.out.printf("The maximum value for sales2 is $%.2f.\n\n",
            sales2.getHighest());

        if (sales1.getNumDaysAtOrOver(1250) == 1)
            System.out.println("Correct: sales1 had 1 day at 1250 or over");
        else
            System.out.println("ERROR in getNumDaysAtOrOver");
        if (sales1.getNumDaysAtOrOver(1150) == 2)
            System.out.println("Correct: sales1 had 2 days at 1150 or over");
        else
            System.out.println("ERROR in getNumDaysAtOrOver");
        if (sales2.getNumDaysAtOrOver(3000) == 3)
            System.out.println("Correct: sales2 had 3 days at 3000 or over");
        else
            System.out.println("ERROR in getNumDaysAtOrOver");

        // Making sure that the array was copied instead of copying
        // the reference. If array was copied correctly, the total
        // will be the same before and after changing arr2.
        double total = sales2.getTotal();
        arr2[0] = 1500;
        if (sales2.getTotal() != total)
            System.out.println("\nERROR: SalesData did not make a copy"
                + " of the data");
    }
}
