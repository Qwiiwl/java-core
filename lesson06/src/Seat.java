import java.io.Serializable;

public class Seat implements Serializable {
    private String seatNumber;
    private String seatClass;
    private boolean isBooked;
    private Passenger passenger;

    public Seat(String seatNumber, String seatClass) {
        this.seatNumber = seatNumber;
        this.seatClass = seatClass;
        this.isBooked = false;
    }

    public String getSeatNumber() { return seatNumber; }
    public String getSeatClass() { return seatClass; }
    public boolean isBooked() { return isBooked; }
    public Passenger getPassenger() { return passenger; }

    public void book(Passenger passenger) {
        this.passenger = passenger;
        this.isBooked = true;
    }

    public void cancel() {
        this.passenger = null;
        this.isBooked = false;
    }

    @Override
    public String toString() {
        return String.format("%s [%s] - %s",
            seatNumber, seatClass,
            isBooked ? "ЗАНЯТО (" + passenger.getName() + ")" : "свободно");
    }
}
