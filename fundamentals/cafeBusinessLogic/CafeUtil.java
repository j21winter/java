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
}