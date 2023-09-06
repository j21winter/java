import java.util.ArrayList;
public class TestOrders {
    public static void main(String[] args) {
        // Menu items
            Item item1 = new Item("Hot Chocolate", 2.5);
            Item item2 = new Item("Coke", 1.2);
            Item item3 = new Item("Coffee", 1.75 );
            Item item4 = new Item("Mocha", 5.5);
            Item item5 = new Item("Milk", 3.75);
    
        // Order variables -- order1, order2 etc.
            Order order1 = new Order("Cindhuri");
                order1.setReady(true);

            Order order2 = new Order("Jimmy");
                order2.addItem(item1);
                // order2.total += item1.price;
                order2.setReady(true);

            Order order3 = new Order("Noah");
                order3.addItem(item3);
                // order3.total += item3.price;

            Order order4= new Order("Sam");
                order4.addItem(item5);
                // order4.total += item5.price;
                order4.addItem(item2);
                // order4.total += item2.price;
                order4.addItem(item2);
                // order4.total += item2.price;
            
            Order order5 = new Order();
                order5.addItem(item3);
    
        // Application Simulations
        // Use this example code to test various orders' updates
        System.out.printf("Name: %s\n", order1.getName());
        System.out.printf("Total: %s\n", order1.getOrderTotal());
        System.out.printf("Ready: %s\n", order1.getStatusMessage());
        System.out.printf("Name: %s\n", order2.getName());
        System.out.printf("Total: %s\n", order2.getOrderTotal());
        System.out.printf("Ready: %s\n", order2.getStatusMessage());
        System.out.printf("Name: %s\n", order3.getName());
        System.out.printf("Total: %s\n", order3.getOrderTotal());
        System.out.printf("Ready: %s\n", order3.getStatusMessage());
        System.out.printf("Name: %s\n", order4.getName());
        System.out.printf("Total: %s\n", order4.getOrderTotal());
        System.out.printf("Ready: %s\n", order4.getStatusMessage());
        order1.displayOrder();
        order2.displayOrder();
        order3.displayOrder();
        order4.displayOrder();
        order5.displayOrder();
    }
}
