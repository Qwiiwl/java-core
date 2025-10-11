import java.io.Serializable;

public enum BookingStatus implements Serializable {
    FREE("Свободно"),
    BOOKED("Забронировано"),
    PAID("Оплачено");

    private final String displayName;

    BookingStatus(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
