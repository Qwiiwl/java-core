import java.io.Serializable;
import java.time.LocalDateTime;

public class Passenger implements Serializable {
    private String name;
    private LocalDateTime bookingTime;

    public Passenger(String name) {
        this.name = name;
        this.bookingTime = LocalDateTime.now();
    }

    public String getName() { return name; }
    public LocalDateTime getBookingTime() { return bookingTime; }
}
