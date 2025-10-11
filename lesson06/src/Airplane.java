import java.io.*;
import java.util.*;

public class Airplane implements Serializable {
    private List<Seat> seats;

    public Airplane() {
        seats = new ArrayList<>();
        initSeats();
    }

    private void initSeats() {
        for (int row = 1; row <= 5; row++) {
            for (char col = 'A'; col <= 'D'; col++) {
                seats.add(new Seat(row + String.valueOf(col), "Business"));
            }
        }

        for (int row = 6; row <= 21; row++) {
            for (char col = 'A'; col <= 'F'; col++) {
                seats.add(new Seat(row + String.valueOf(col), "Economy"));
            }
        }
    }

    public void showSeats() {
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
        if (seat.isBooked()) {
            System.out.println("❌ Место уже занято!");
            return;
        }
        seat.book(new Passenger(name));
        System.out.println("✅ Место " + number + " успешно забронировано!");
    }

    public void cancelBooking(String number) {
        Seat seat = findSeat(number);
        if (seat == null) {
            System.out.println("❌ Место не найдено!");
            return;
        }
        if (!seat.isBooked()) {
            System.out.println("❌ Место не было забронировано!");
            return;
        }
        seat.cancel();
        System.out.println("✅ Бронь на место " + number + " отменена.");
    }

    public void showInfo(String number) {
        Seat seat = findSeat(number);
        if (seat == null) {
            System.out.println("❌ Место не найдено!");
            return;
        }
        System.out.println(seat);
    }

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
            System.out.println("Создаётся новая база мест...");
            return new Airplane();
        }
    }
}
