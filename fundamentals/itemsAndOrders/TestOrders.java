import java.util.ArrayList;
public class TestOrders {
    public static void main(String[] args) {
        // Menu items
            Item item1 = new Item();
                item1.name = "Hot Chocolate";
                item1.price = 2.5;
            
            Item item2 = new Item();
                item2.name = "Coke";
                item2.price = 1.2;
            
            Item item3 = new Item();
                item3.name = "Coffee";
                item3.price = 1.75;
            
            Item item4 = new Item();
                item4.name = "Mocha";
                item4.price = 5.5;
            
            Item item5 = new Item();
                item5.name = "Milk";
                item5.price = 3.75;
    
        // Order variables -- order1, order2 etc.
            Order order1 = new Order();
                order1.name = "Cindhuri";
                order1.ready = true;

            Order order2 = new Order();
                order2.name = "Jimmy";
                order2.items.add(item1);
                order2.total += item1.price;
                order2.ready = true;

            Order order3 = new Order();
                order3.name = "Noah";
                order3.items.add(item3);
                order3.total += item3.price;

            Order order4= new Order();
                order4.name = "Sam";
                order4.items.add(item5);
                order4.total += item5.price;
                order4.items.add(item2);
                order4.total += item2.price;
                order4.items.add(item2);
                order4.total += item2.price;
    
        // Application Simulations
        // Use this example code to test various orders' updates
        System.out.printf("Name: %s\n", order1.name);
        System.out.printf("Total: %s\n", order1.total);
        System.out.printf("Ready: %s\n", order1.ready);
        System.out.printf("Name: %s\n", order2.name);
        System.out.printf("Total: %s\n", order2.total);
        System.out.printf("Ready: %s\n", order2.ready);
        System.out.printf("Name: %s\n", order3.name);
        System.out.printf("Total: %s\n", order3.total);
        System.out.printf("Ready: %s\n", order3.ready);
        System.out.printf("Name: %s\n", order4.name);
        System.out.printf("Total: %s\n", order4.total);
        System.out.printf("Ready: %s\n", order4.ready);
    }
}
