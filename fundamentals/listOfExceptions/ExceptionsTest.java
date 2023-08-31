import java.util.ArrayList;

public class ExceptionsTest{
    public static void main(String[] args){
        
        ArrayList<Object> myList = new ArrayList<Object>();
        myList.add("13");
        myList.add("hello world");
        myList.add(48);
        myList.add("Goodbye World");

        for(int i = 0; i < myList.size(); i++) {
            try{
                Integer castedValue = (Integer) myList.get(i);
            } 
            catch (ClassCastException e){
                System.out.printf("Type Casting Error\nIndex : %s\nValue: %s\n\n\n", i, myList.get(i));
            }
        }
    }
}