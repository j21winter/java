import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.text.*;

public class CafeUtil{

    public int getStreakGoal(int numWeeks){
        int sum = 0;
        for(int i = 0; i <= numWeeks; i ++){
            sum += i;
        }
        return sum;
    }

    public double getOrderTotal(double[] prices) {
        double sum = 0;
        for(double price : prices){
            sum += price;
        }
        return sum;
    }

    public void displayMenu(ArrayList<String> menuItems){
        for(int i = 0; i < menuItems.size(); i++){
            String drink = menuItems.get(i);
            System.out.printf("%s %s \n\n", i, drink);
            }
        }

    public ArrayList addCustomer(ArrayList<String> customers){
        System.out.println("Please enter your name: ");
        String username = System.console().readLine();
        int length = customers.size();
        System.out.printf("Hello, %s! \n", username);
        System.out.printf("There are %s people in front of you!", length);
        customers.add(username);
        return customers;
    }

    public void printPriceChart(String product, double price, int maxQuantity){
        System.out.println(product);
        DecimalFormat myFormat = new DecimalFormat("$###.00");
        for(int i = 1; i <= maxQuantity; i++){
            // String priceFormat = myFormat.format(i * price);
            System.out.printf("%s - %s \n\n", i, myFormat.format((i * price) - ((i-1) * 0.5)));
        }
    }

    public boolean displayMenu(ArrayList<String> menuItems, ArrayList<Double> prices){
        DecimalFormat myFormat = new DecimalFormat("$###.00");
        if(menuItems.size() == prices.size()){
            for(int i = 0; i < menuItems.size(); i++){
                System.out.printf((i + 1) + " " + menuItems.get(i) + " -- " + myFormat.format(prices.get(i)) + "\n\n");
            }
        }
        else{
            return false;
        }
        return true;
    }

    public ArrayList addCustomer(){
        ArrayList<String> customerList = new ArrayList<String>();
        // System.out.print("Enter customer name:");
        System.out.print("Enter customer names: \n(When finished just type 'end') \n");
        String customer  = System.console().readLine();
        while( !customer.equals("end")){
            customerList.add(customer);
            customer = System.console().readLine();
        }
        System.out.println(customerList);
        return customerList;
    }
}



