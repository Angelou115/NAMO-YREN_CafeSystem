public class Customer {
    private String name;
    private boolean student;
    private int loyaltyPoints;

    public Customer() {
        this("Guest", false);
    }

    public Customer(String name) {
        this(name, false);
    }


    public Customer(String name, boolean student) {
        this.name = "Guest";
        setName(name);
        this.student = student;
        loyaltyPoints = 0;
    }

    public void addPoints(int points) {
        if (points >= 0) {
            loyaltyPoints += points;
        } else {
            System.out.println("Error: points cannot be negative.");
        }
    }

    public void addPoints(double amountSpent) {
        if (amountSpent >= 0) {
            loyaltyPoints += (int) (amountSpent / 50);
        } else {
            System.out.println(
                    "Error: amount spent cannot be negative."
            );
        }
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name.trim();
        } else {
            System.out.println(
                    "Error: customer name cannot be empty."
            );
        }
    }

    public boolean isStudent() {
        return student;
    }

    public void setStudent(boolean student) {
        this.student = student;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(int loyaltyPoints) {
        if (loyaltyPoints >= 0) {
            this.loyaltyPoints = loyaltyPoints;
        } else {
            System.out.println(
                    "Error: loyalty points cannot be negative."
            );
        }
    }
}