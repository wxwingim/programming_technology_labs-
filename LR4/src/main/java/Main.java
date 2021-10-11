public class Main {
    public static void main(String[] args) {
//        SwapMas<String> swapMas = new SwapMas<String>();
//        String masStr[] = {"a", "b", "c"};
//        swapMas.Swap(masStr, 0, 2);
//        Integer masInt[] = {1, 2, 3};
//        SwapMas<Integer> swapMas2 = new SwapMas<Integer>();
//        swapMas2.Swap(masInt, 0, 2);
//        swapMas2.MakeList(masInt);

        // создание фруктов
        Orange orange = new Orange();
        Apple apple = new Apple();

        // создание коробок
        Box<Orange> boxOrange4 = new Box(orange, 4);
        Box<Apple> boxApple2 = new Box(apple, 2);
        Box<Orange> boxOrange6 = new Box(orange, 6);
        Box<Apple> boxApple10 = new Box(apple, 10);
        Box<Apple> boxApple0 = new Box(apple, 0);


        // вес
//        System.out.println("Вес коробки = " + boxOrange4.getWeight());
//        System.out.println("Вес коробки = " + boxApple2.getWeight());

        // сравнение
//        boxOrange4.Compare(boxOrange4);
//        boxApple2.Compare(boxOrange4);

        // print
//        boxOrange6.PrintBox();
//        boxOrange4.PrintBox();
//        boxApple10.PrintBox();
//        boxApple2.PrintBox();
//        boxApple10.PrintBox();
//        boxApple0.PrintBox();

        // пересыпание
//        boxApple2.PourFruit(boxOrange4, 2);
//        boxApple2.PourFruit(boxApple10, 4);
//        boxOrange4.PourFruit(boxOrange6, 3);
//        boxApple10.PourFruit(boxApple2, 4);
//        boxApple2.PourFruit(boxApple2, 2);
//        boxApple10.PourFruitAll(boxApple0);

        //print
//        boxOrange6.PrintBox();
//        boxOrange4.PrintBox();

//        boxApple10.PrintBox();
//        boxApple2.PrintBox();

//        boxApple10.PrintBox();
//        boxApple0.PrintBox();
    }
}
