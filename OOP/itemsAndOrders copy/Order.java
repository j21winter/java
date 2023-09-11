import java.util.ArrayList;

public class Order{
    private String name;
    private ArrayList<Item> items;
    // private double total;
    private boolean ready;

    public Order(){
        this.name = "Guest";
        this.items = new ArrayList<Item>();
    }

    public Order(String name){
        this.name = name;
        this.items = new ArrayList<Item>();
    }

    public ArrayList<Item> getItems(){
        return items;
    }
    public void setItems(ArrayList<Item> items){
        this.items = items;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public boolean getReady(){
        return ready;
    }
    public void setReady(boolean ready){
        this.ready = ready;
    }

    public void addItem(Item item){
        this.items.add(item);
    }

    public String getStatusMessage(){
        if(this.ready){
            return "Your order is ready";
        }
        else{
            return "Thank you for waiting. Your order will be ready soon.";
        }
    }

    public double getOrderTotal(){
        double total = 0; 
        for(Item item : items){
            total += item.getPrice();
        }
        return total;
    }

    public void displayOrder(){
        System.out.printf("\n\nCustomer name: %s\n", name);
        for(Item item : items){
            System.out.printf("%s - %s\n", item.getName(), item.getPrice());
        }
        System.out.printf("Total: %s\n", this.getOrderTotal());
    }
}