public class Robot implements Movement {
    private int maxRun = 30;
    private int maxJump = 3;

    public Robot(){}

    public int getMaxRun() {
        return maxRun;
    }

    public int getMaxJump() {
        return maxJump;
    }

    public void run(int goRun) {
        if (goRun <= maxRun){
            System.out.println("Робот успешно пробежал длину " + goRun + " ед");
        }
        else System.out.println("Робот не смог пробежать длину в " + goRun + " ед");
    }

    public void jump(int goJump) {
        if (goJump <= maxJump){
            System.out.println("Робот успешно перепрыгнул препятствие высотой " + goJump);
        }
        else System.out.println("Робот не смог преодолеть препятствие высотой " + goJump);
    }
}
