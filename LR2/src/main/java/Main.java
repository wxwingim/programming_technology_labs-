public class Main {
    public static void main(String[] args) {

        // массив участников
        Movement[] creature = new Movement[3];
        creature[0] = new Human();
        creature[1] = new Robot();
        creature[2] = new Cat();

        // массив препятствий
        Let[] lets = new Let[6];
        for (int i =0; i< lets.length; i++){
            lets[i] = Let.values()[i];
        }

        // прохождение
        for (int i = 0; i< creature.length; i++){
            for (int j = 0; j < lets.length; j+=2){
                if (lets[j].getSize() <= creature[i].getMaxRun()){
                    creature[i].run(lets[j].getSize());
                }
                else {
                    creature[i].run(lets[j].getSize());
                    System.out.println("Выбыл с полосы препятствий.");
                    i++;
                    j = -2;
                    break;
                }
                if (lets[j+1].getSize() <= creature[i].getMaxJump()){
                    creature[i].jump(lets[j+1].getSize());
                }
                else {
                    creature[i].jump(lets[j+1].getSize());
                    System.out.println("Выбыл с полосы препятствий.");
                    i++;
                    j = -2;
                }
                if (j + 2 == lets.length) {
                    System.out.println("Полоса препятствий пройдена.");
                }
            }
        }

    }
}
