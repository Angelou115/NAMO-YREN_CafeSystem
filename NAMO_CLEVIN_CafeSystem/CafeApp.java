      public static void main(String[] args) {

        // Create two customers using different constructors.
        Customer ana = new Customer("Clevin Yren", true);
        Customer ben = new Customer("Christ Angelou Namo");

        // Create the first order.
        Order order1 = new Order("1001", ana);

        // Add a beverage, pastry, and meal.
        order1.addItem(
                new Beverage("Iced Latte", 95, "B-01", "L")
        );

        order1.addItem(
                new Pastry("Ensaymada", 45, "P-01", true)
        );

        order1.addItem(
                new Meal("Chicken Adobo", 110, "M-01", true, 1)
        );

        // Try adding a fourth item to demonstrate the item limit.
        order1.addItem(
                new Pastry("Cookie", 35, "P-02", false)
        );

        order1.printReceipt();

        // Demonstrate setter validation for a negative price.
        Beverage hotChocolate = new Beverage();

        hotChocolate.setName("Hot Chocolate");
        hotChocolate.setItemCode("B-02");

        hotChocolate.setBasePrice(-5);
        hotChocolate.setBasePrice(80);
        hotChocolate.setSize("M");

        // Create the second order.
        Order order2 = new Order("1002", ben);

        order2.addItem(hotChocolate);

        order2.addItem(
                new Meal("Beef Tapa", 130, "M-02", false, 0)
        );

        // Demonstrate the overloaded computeTotal method.
        System.out.println(
                "Voucher applied to Order #1002: 20.00"
        );

        System.out.printf(
                "Order #1002 total with voucher: %.2f%n",
                order2.computeTotal(20)
        );

        // Print the receipt with the voucher included.
        order2.printReceipt(20);
      }
