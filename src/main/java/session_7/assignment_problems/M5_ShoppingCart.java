package session_7.assignment_problems;

public class M5_ShoppingCart {

    static class Cart {

        private final String cartId;
        private final double[] prices;
        private int itemCount;

        // Constructor
        Cart(String cartId, int maxItems) {

            this.cartId = cartId;
            this.prices = new double[maxItems];
            this.itemCount = 0;
        }

        // Add item
        void addItem(double price) {

            if (itemCount >= prices.length) {
                System.out.println("Cart is full");
                return;
            }

            prices[itemCount] = price;
            itemCount++;
        }

        // Calculate total when requested
        double getTotal() {

            double total = 0;

            for (int i = 0; i < itemCount; i++) {
                total += prices[i];
            }

            return total;
        }

        // Read-only item count
        int getItemCount() {
            return itemCount;
        }

        // Read-only cart ID
        String getCartId() {
            return cartId;
        }
    }

    public static void main(String[] args) {

        Cart cart =
            new Cart("CART-5", 20);

        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);

        System.out.println(
            "Total: " + cart.getTotal()
        );

        System.out.println(
            "Item count: " + cart.getItemCount()
        );
    }
}