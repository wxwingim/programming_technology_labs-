public class Main {
    public static void main(String[] args) {

        // массив участников
        Movement[] creature = {
                new Human(),
                new Robot(),
                new Cat()
        };

        // массив препятствий
        Let[] lets = new Let[6];
        for (Let o: lets) {
            lets = Let.values();
        }

        // прохождение
        for (Movement create: creature) {
            for (int j = 0; j < lets.length; j+=2) {
                if (lets[j].getSize() <= create.getMaxRun()) {
                    create.run(lets[j].getSize());
                } else {
                    create.run(lets[j].getSize());
                    System.out.println("Выбыл с полосы препятствий.");

                    j = -2;
                    break;
                }
                if (lets[j + 1].getSize() <= create.getMaxJump()) {
                    create.jump(lets[j + 1].getSize());
                } else {
                    create.jump(lets[j + 1].getSize());
                    System.out.println("Выбыл с полосы препятствий.");
                    j = -2;
                    break;
                }
                if (j + 2 == lets.length) {
                    System.out.println("Полоса препятствий пройдена.");
                }
            }
        }

    }
}
