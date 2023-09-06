import java.util.ArrayList;

public class Order{
    public String name;
    public ArrayList<Item> items = new ArrayList<Item>();
    public double total;
    public boolean ready = false;
}