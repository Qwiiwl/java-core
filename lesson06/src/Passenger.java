import java.io.Serializable;

public class Passenger implements Serializable {
    private String name;

    public Passenger(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
