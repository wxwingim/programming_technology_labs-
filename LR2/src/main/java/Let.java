public enum Let {
    TRACK10(10),
    WALL1(1),
    TRACK20(20),
    WALL2(2),
    TRACK30(30),
    WALL3(3);

    private int size;

    private Let(int size){
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}
