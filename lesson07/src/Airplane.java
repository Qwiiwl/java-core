import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

public class Airplane implements Serializable {
    private List<Seat> seats;
    private LocalDateTime flightDate;

    public Airplane(LocalDateTime flightDate) {
        this.flightDate = flightDate;
        this.seats = new ArrayList<>();
        initSeats();
    }

    private void initSeats() {
        // Бизнес-класс
        for (int row = 1; row <= 5; row++)
            for (char col = 'A'; col <= 'D'; col++)
                seats.add(new Seat(row + String.valueOf(col), "Business"));

        // Эконом-класс
        for (int row = 6; row <= 21; row++)
            for (char col = 'A'; col <= 'F'; col++)
                seats.add(new Seat(row + String.valueOf(col), "Economy"));
    }

    private void checkExpiredBookings() {
        for (Seat seat : seats) {
            if (seat.isExpired()) {
                seat.cancel();
                System.out.println("⏰ Бронь " + seat.getSeatNumber() + " истекла (снята автоматически).");
            }
        }
    }

    public void showSeats() {
        checkExpiredBookings();
        System.out.println("\nДата вылета: " + flightDate);
        for (Seat seat : seats) {
            System.out.println(seat);
        }
    }

    public Seat findSeat(String number) {
        for (Seat seat : seats) {
            if (seat.getSeatNumber().equalsIgnoreCase(number)) {
                return seat;
            }
        }
        return null;
    }

    public void bookSeat(String number, String name) {
        Seat seat = findSeat(number);
        if (seat == null) {
            System.out.println("❌ Такого места не существует!");
            return;
        }
        if (!seat.isFree()) {
            System.out.println("❌ Место уже занято!");
            return;
        }
        seat.book(new Passenger(name));
        System.out.println("✅ Место " + number + " забронировано на 24 минуты!");
    }

    public void payForSeat(String number) {
        Seat seat = findSeat(number);
        if (seat == null) {
            System.out.println("❌ Место не найдено!");
            return;
        }
        if (seat.getStatus() == BookingStatus.BOOKED) {
            seat.pay();
            System.out.println("💳 Место " + number + " оплачено!");
        } else if (seat.getStatus() == BookingStatus.PAID) {
            System.out.println("❗ Это место уже оплачено.");
        } else {
            System.out.println("❌ Сначала нужно забронировать место.");
        }
    }

    public void cancelBooking(String number) {
        Seat seat = findSeat(number);
        if (seat == null) {
            System.out.println("❌ Место не найдено!");
            return;
        }
        if (seat.getStatus() == BookingStatus.FREE) {
            System.out.println("❌ Место не забронировано.");
            return;
        }
        seat.cancel();
        System.out.println("✅ Бронь/оплата на место " + number + " отменена.");
    }

    public void showInfo(String number) {
        Seat seat = findSeat(number);
        if (seat == null) {
            System.out.println("❌ Место не найдено!");
            return;
        }
        System.out.println(seat);
    }

    // --- Сохранение и загрузка состояния ---
    public void saveToFile(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(this);
        } catch (IOException e) {
            System.out.println("Ошибка сохранения данных: " + e.getMessage());
        }
    }

    public static Airplane loadFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (Airplane) ois.readObject();
        } catch (Exception e) {
            System.out.println("Создаётся новый рейс...");
            // По умолчанию — через 3 часа
            return new Airplane(LocalDateTime.now().plusHours(3));
        }
    }
}
