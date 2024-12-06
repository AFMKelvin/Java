public class BookBilling {

    // tax rate
    private static final double TAX_RATE = 0.0825; // 8.25%

    public static void main(String[] args) {

        BookBilling billing = new BookBilling();

        // Single book without discount
        System.out.println("Bill for a single photo book: $" + String.format("%.2f", billing.computeBill(50.0)));

        // Multiple books without discount
        System.out.println("Bill for 3 photo books: $" + String.format("%.2f", billing.computeBill(50.0, 3)));

        // Multiple books with discount
        System.out.println("Bill for 3 photo books with $20 discount: $" + String.format("%.2f", billing.computeBill(50.0, 3, 20.0)));
    }



    // one parameter, price of book plus tax returns total

    public double computeBill(double priceOfBook) {

        double taxAmount;

        taxAmount = priceOfBook * TAX_RATE;
        return priceOfBook + taxAmount;
    }


    // two parameters, price of book times quantity ordered, tax and returns total

    public double computeBill(double priceOfBook, int quantity) {

        double totalCost;
        double taxAmount;

        totalCost = priceOfBook * quantity;
        taxAmount = totalCost * TAX_RATE;
        return totalCost + taxAmount;
    }


    // three parameters, price of book times quanity minus coupon, tax and returns total

    public double computeBill(double priceOfBook, int quantity, double couponDiscount) {

        double totalCost;
        double taxAmount;

        totalCost = (priceOfBook * quantity) - couponDiscount;
        taxAmount = totalCost * TAX_RATE;
        return totalCost + taxAmount;
    }
}
