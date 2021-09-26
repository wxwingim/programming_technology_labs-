public class Cat implements Movement {
    private int maxRun = 10;
    private int maxJump = 3;

    public Cat(){}

    public int getMaxRun() {
        return maxRun;
    }

    public int getMaxJump() {
        return maxJump;
    }

    public void run(int goRun) {
        if (goRun <= maxRun){
            System.out.println("Кот успешно пробежал длину " + goRun + " ед");
        }
        else System.out.println("Кот не смог пробежать длину в " + goRun + " ед");
    }

    public void jump(int goJump) {
        if (goJump <= maxJump){
            System.out.println("Кот успешно перепрыгнул препятствие высотой " + goJump);
        }
        else System.out.println("Кот не смог преодолеть препятствие высотой " + goJump);
    }
}
