public interface Movement {
    public void run(int goRun);
    public void jump(int goJump);
    public int getMaxRun();
    public int getMaxJump();
    int maxJump = 0;
    int maxRun = 0;
}
