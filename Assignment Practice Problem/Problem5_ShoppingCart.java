public class Problem5_ShoppingCart {
    public static void main(String[] args) {
        Cart cart = new Cart("CART-5", 20);
        System.out.println("Cart ID: " + cart.getCartId());

        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);

        System.out.println("Total: " + cart.getTotal());
        System.out.println("Item count: " + cart.getItemCount());
    }
}

class Cart {
    private final String cartId;
    private final double[] prices;
    private int itemCount;

    Cart(String cartId, int maxItems) {
        this.cartId = cartId;
        this.prices = new double[maxItems];
        this.itemCount = 0;
    }

    void addItem(double price) {
        if (itemCount >= prices.length) {
            System.out.println("Rejected: cart is full");
            return;
        }
        prices[itemCount] = price;
        itemCount++;
    }

    double getTotal() {
        double total = 0;
        for (int i = 0; i < itemCount; i++) {
            total += prices[i];
        }
        return total;
    }

    int getItemCount() {
        return itemCount;
    }

    String getCartId() {
        return cartId;
    }
}
