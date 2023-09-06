import java.util.ArrayList;

public class Order{
    String name;
    ArrayList<Item> items = new ArrayList<Item>();
    double total;
    boolean ready = false;
}