import java.util.ArrayList;
import java.util.Scanner;

public class CoffeeKiosk {
	private ArrayList<Item> menu;
	private ArrayList<Order> orders;
	
	
	public CoffeeKiosk() {
		this.menu = new ArrayList<Item>();
		this.orders = new ArrayList<Order>();
	}

	public ArrayList<Item> getMenu() {
		return menu;
	}

	public void setMenu(ArrayList<Item> menu) {
		this.menu = menu;
	}

	public ArrayList<Order> getOrders() {
		return orders;
	}

	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}

	public void addMenuItem(String name, double price) {
		Item newItem = new Item(name, price);
		newItem.setIndex(menu.size());
		menu.add(newItem);	
	}
	
	public void displayMenu (){
		for(Item item : menu){
			System.out.printf("%s %s -- $%s\n", item.getIndex(), item.getName(), item.getPrice());
		}
	}
	
	public void newOrder() {
		Scanner scanner = new Scanner(System.in);
    	// Shows the user a message prompt and then sets their input to a variable, name
        System.out.println("Please enter customer name for new order:");
        String name = scanner.nextLine();
        
    	// Your code:
        // Create a new order with the given input string
        Order newOrder = new Order(name);
        // Show the user the menu, so they can choose items to add.
        System.out.printf("\nHello %s. Please see our menu:\n\n", name);
        this.displayMenu();
    	// Prompts the user to enter an item number
        System.out.println("Please enter a menu item index or q to quit:");
        String itemNumber = "";
        
        // Write a while loop to collect all user's order items
        while(!itemNumber.equals("q")) {
        	itemNumber = scanner.nextLine();
            // Get the item object from the menu, and add the item to the order
        	try {
        		int indexNumber = Integer.parseInt(itemNumber);
        		
        		if(indexNumber >= 0 && indexNumber< menu.size()){
        			newOrder.addItem(menu.get(indexNumber));
        			System.out.println("Next item:");
        		}
        		else {
        			System.out.println("Invalid Selection. Please pick again:");
        		}
            // Ask them to enter a new item index or q again, and take their input
        	}
        	catch (NumberFormatException e) {
        		
        	}
        
        }	
        // After you have collected their order, print the order details 
        newOrder.displayOrder();
        scanner.close();
	}
}
