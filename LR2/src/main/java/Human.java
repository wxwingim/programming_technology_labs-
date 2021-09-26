public class Human implements Movement {
    private int maxRun = 20;
    private int maxJump = 1;

    public Human(){}

    public int getMaxRun() {
        return maxRun;
    }

    public int getMaxJump() {
        return maxJump;
    }

    public void run(int goRun) {


        if (goRun <= maxRun){
            System.out.println("Человек успешно пробежал длину " + goRun + " ед");
        }
        else System.out.println("Человек не смог пробежать длину в " + goRun + " ед");
    }

    public void jump(int goJump) {
        if (goJump <= maxJump){
            System.out.println("Человек успешно перепрыгнул препятствие высотой " + goJump);
        }
        else System.out.println("Человек не смог препятствие высотой " + goJump);
    }
}
