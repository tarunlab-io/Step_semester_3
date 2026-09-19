package session_7.class_problems;

public class M1_PiggyBank {

    static class PiggyBank {

        private double savings;
        private final String id;

        // Constructor
        PiggyBank(String id) {
            this.id = id;
            this.savings = 0;
        }

        // Deposit money
        void deposit(double amount) {
            savings += amount;
        }

        // Withdraw money
        void withdraw(double amount) {

            if (amount > savings) {
                System.out.println(
                    "Withdrawal rejected: insufficient savings"
                );
            } else {
                savings -= amount;
            }
        }

        // Getter for savings
        double getSavings() {
            return savings;
        }

        // Getter for ID
        String getId() {
            return id;
        }
    }

    public static void main(String[] args) {

        PiggyBank pb = new PiggyBank("PB-1");

        pb.deposit(100);

        System.out.println(
            "After deposit: " + pb.getSavings()
        );

        pb.withdraw(30);

        System.out.println(
            "After withdrawal: " + pb.getSavings()
        );

        pb.withdraw(500);

        System.out.println(
            "Final savings: " + pb.getSavings()
        );
    }
}
