import javax.persistence.*;

@Entity
@Table(name = "items")

public class Items {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "val")
    int val;

    @Version
    long version;

    public Items(int val) {
        this.val = val;
    }

    public Items() {

    }

    public long getVersion() {
        return version;
    }

    public int getId() {
        return id;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
}
