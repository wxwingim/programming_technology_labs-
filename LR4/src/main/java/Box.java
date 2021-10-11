import java.util.ArrayList;

public class Box<T extends Fruit> {
    private T fruit;
    private ArrayList<T> froutsBox;
    private double weight;

    public Box(T fruit, int count){
        this.fruit = fruit;
        this.froutsBox = FillBox(fruit, count);
        this.weight = getWeight();
    }

    private ArrayList<T> FillBox(T fruit, int count){
        ArrayList<T> newFruit = new ArrayList<T>(count);
        for (int i=0; i<count; i++){
            newFruit.add(fruit);
        }
        return newFruit;
    }

    // вес
    public double getWeight(){
        double weight = fruit.getWeight() * froutsBox.size();
        return weight;
    }

    // сравнить
    public boolean Compare(Box secondBox){
        if (Math.abs(this.weight - secondBox.getWeight()) < 0.00001){
            System.out.println("Массы коробок равны \n");
            return true;
        }
        else {
            System.out.println("Массы коробок не равны \n");
            return false;
        }
    }

    // пересыпать
    public void PourFruit(Box<? super T> newBox, int count){
                if (this.froutsBox.size() >= count){
                    for (int i = 0; i< count; i++){
                        newBox.AddFruit(this.fruit);
                        froutsBox.remove(0);
                        newBox.weight += newBox.getWeight()/(newBox.froutsBox.size());
                        this.weight -= getWeight()/ (froutsBox.size());
                    }
                }
                else{
                    System.out.println("В коробке не хватает фруктов.");
                }
    }

    // пересыпать все
    public void PourFruitAll(Box<? super T> newBox){
        int size = this.froutsBox.size();
        for (int i =0; i < size; i++){
            newBox.AddFruit(fruit);
            froutsBox.remove(0);
        }
        newBox.weight += newBox.getWeight();
        this.weight = 0.0;
    }

    // добавить
    public void AddFruit(T fruit){
        froutsBox.add(fruit);
    }

    public void PrintBox(){
        System.out.print("В коробке ");
        fruit.PrintFruit();
        System.out.println("Количество фруктов в коробке: " + froutsBox.size() + " шт");
        System.out.println("Вес коробки: " + weight + " f \n");
    }
}