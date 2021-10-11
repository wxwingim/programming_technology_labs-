public class Apple extends Fruit {
    private double weight = 1.0;

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public void PrintFruit(){
        System.out.println("яблоки");
    }
}
