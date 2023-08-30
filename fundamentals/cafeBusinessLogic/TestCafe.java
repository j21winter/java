import java.util.ArrayList;
import java.util.Arrays;

public class TestCafe {
    public static void main(String[] args) {

        CafeUtil cafeUtil = new CafeUtil();

        int streakWeek = 10;
        int testStreak = cafeUtil.getStreakGoal(streakWeek);
        System.out.println(testStreak);

        /* ============ App Test Cases ============= */
    
        System.out.println("\n----- Streak Goal Test -----");
        System.out.printf("Purchases needed by week %s: %s \n\n", streakWeek, cafeUtil.getStreakGoal(10));
    
        System.out.println("----- Order Total Test-----");
        double[] lineItems = {3.5, 1.5, 4.0, 4.5};
        System.out.printf("Order total: %s \n\n", cafeUtil.getOrderTotal(lineItems));
        
        System.out.println("----- Display Menu Test-----");
        
        ArrayList<String> menu = new ArrayList<String>();
        menu.add("drip coffee");
        menu.add("cappuccino");
        menu.add("latte");
        menu.add("mocha");
        cafeUtil.displayMenu(menu);
    
        System.out.println("\n----- Add Customer Test-----");
        ArrayList<String> customers = new ArrayList<String>();
        // --- Test 4 times ---
        for (int i = 0; i < 4; i++) {
            cafeUtil.addCustomer(customers);
            System.out.println("\n");
        }

        System.out.println("\n----- Price Chart Test-----");
        String product = "Columbian Coffee Grounds";
        double price = 2;
        int maxQuantity = 4;

        cafeUtil.printPriceChart(product, price, maxQuantity);

        System.out.println("\n----- Display Menu Test-----");
        ArrayList<String> drinks = new ArrayList<String>();
        drinks.add("coffee");
        drinks.add("tea");
        drinks.add("water");
        ArrayList<Double> pricingList = new ArrayList<Double>();
        pricingList.add(1.50);
        pricingList.add(2.07);
        pricingList.add(3.90);
        cafeUtil.displayMenu(drinks, pricingList);

        System.out.println("\n----- Add Customers Test-----");
        cafeUtil.addCustomer();

    }
}



