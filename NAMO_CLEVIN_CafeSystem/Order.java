public class Order {
    private Customer customer;
    private MenuItem item1;
    private MenuItem item2;
    private MenuItem item3;
    private int itemCount;
    private String orderId;

    public Order(String orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;

        item1 = null;
        item2 = null;
        item3 = null;

        itemCount = 0;
    }

    public boolean addItem(MenuItem item) {
        if (item == null) {
            System.out.println("Cannot add an empty item.");
            return false;
        }

        if (itemCount >= 3) {
            System.out.println(
                    "Order is full. Cannot add "
                            + item.getDescription() + "."
            );
            return false;
        }

        if (item1 == null) {
            item1 = item;
        } else if (item2 == null) {
            item2 = item;
        } else {
            item3 = item;
        }

        itemCount++;
        return true;
    }

    public double computeSubtotal() {
        double subtotal = 0;

        if (item1 != null) {
            subtotal += item1.computePrice();
        }

        if (item2 != null) {
            subtotal += item2.computePrice();
        }

        if (item3 != null) {
            subtotal += item3.computePrice();
        }

        return subtotal;
    }

    public double computeTotal() {
        double subtotal = computeSubtotal();

        if (customer != null && customer.isStudent()) {
            return subtotal - (subtotal * 0.10);
        }

        return subtotal;
    }

    public double computeTotal(double voucher) {
        double total = computeTotal();

        if (voucher > 0) {
            total -= voucher;
        }

        if (total < 0) {
            total = 0;
        }

        return total;
    }

    public void printReceipt() {
        printReceiptDetails(0);
    }

    public void printReceipt(double voucher) {
        printReceiptDetails(voucher);
    }

    private void printReceiptDetails(double voucher) {
        System.out.println("Order #" + orderId + " - "
                + customer.getName()
                + (customer.isStudent()
                ? " (Student)" : " (Regular)"));

        if (item1 != null) printItem(item1);
        if (item2 != null) printItem(item2);
        if (item3 != null) printItem(item3);

        double subtotal = computeSubtotal();

        double studentDiscount =
                customer.isStudent() ? subtotal * 0.10 : 0;

        double beforeVoucher = computeTotal();
        double total = computeTotal(voucher);

        System.out.printf("  Subtotal: %.2f%n", subtotal);

        if (studentDiscount > 0) {
            System.out.printf(
                    "  Student discount (10%%): -%.2f%n",
                    studentDiscount
            );
        }

        if (voucher > 0) {
            System.out.printf(
                    "  Voucher: -%.2f%n",
                    Math.min(voucher, beforeVoucher)
            );
        }

        System.out.printf("  TOTAL: %.2f%n", total);

        customer.addPoints(total);

        System.out.println(
                "  Loyalty points: " + customer.getLoyaltyPoints()
        );

        System.out.println();
    }

    private void printItem(MenuItem item) {
        System.out.printf(
                "  %-42s %.2f%n",
                item.getDescription(),
                item.computePrice()
        );
    }


    public String getOrderId() {
        return orderId;
    }


    public void setOrderId(String orderId) {
        if (orderId != null && !orderId.trim().isEmpty()) {
            this.orderId = orderId.trim();
        } else {
            System.out.println(
                    "Error: order ID cannot be empty."
            );
        }
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        if (customer != null) {
            this.customer = customer;
        } else {
            System.out.println(
                    "Error: customer cannot be null."
            );
        }
    }

    public int getItemCount() {
        return itemCount;
    }
}