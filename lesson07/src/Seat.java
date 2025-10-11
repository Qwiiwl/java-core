import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;

public class Seat implements Serializable {
    private String seatNumber;
    private String seatClass;
    private BookingStatus status;
    private Passenger passenger;

    public Seat(String seatNumber, String seatClass) {
        this.seatNumber = seatNumber;
        this.seatClass = seatClass;
        this.status = BookingStatus.FREE;
    }

    public String getSeatNumber() { return seatNumber; }
    public String getSeatClass() { return seatClass; }
    public BookingStatus getStatus() { return status; }
    public Passenger getPassenger() { return passenger; }

    public void book(Passenger passenger) {
        this.passenger = passenger;
        this.status = BookingStatus.BOOKED;
    }

    public void pay() {
        if (status == BookingStatus.BOOKED) {
            this.status = BookingStatus.PAID;
        }
    }

    public void cancel() {
        this.passenger = null;
        this.status = BookingStatus.FREE;
    }

    public boolean isFree() { return status == BookingStatus.FREE; }

    public boolean isExpired() {
        if (status == BookingStatus.BOOKED && passenger != null) {
            long minutes = Duration.between(passenger.getBookingTime(), LocalDateTime.now()).toMinutes();
            return minutes >= 24;
        }
        return false;
    }

    @Override
    public String toString() {
        if (status == BookingStatus.FREE)
            return String.format("%s [%s] - %s", seatNumber, seatClass, status.getDisplayName());
        else
            return String.format("%s [%s] - %s (%s, забронировано: %s)",
                seatNumber, seatClass, status.getDisplayName(),
                passenger.getName(),
                passenger.getBookingTime());
    }
}
