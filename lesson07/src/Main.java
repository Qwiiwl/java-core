import java.util.Scanner;

public class Main {
    private static final String FILE_NAME = "seats.dat";

    public static void main(String[] args) {
        Airplane airplane = Airplane.loadFromFile(FILE_NAME);
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== МЕНЮ =====");
            System.out.println("1. Показать все места");
            System.out.println("2. Забронировать место");
            System.out.println("3. Оплатить бронь");
            System.out.println("4. Снять бронь/оплату");
            System.out.println("5. Информация по месту");
            System.out.println("6. Выход");

            System.out.print("Выберите пункт: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    airplane.showSeats();
                    break;
                case "2":
                    System.out.print("Введите номер места (например, 3B): ");
                    String seatNum = sc.nextLine().trim().toUpperCase();
                    System.out.print("Введите ФИО пассажира: ");
                    String name = sc.nextLine().trim();
                    airplane.bookSeat(seatNum, name);
                    break;
                case "3":
                    System.out.print("Введите номер места: ");
                    airplane.payForSeat(sc.nextLine().trim().toUpperCase());
                    break;
                case "4":
                    System.out.print("Введите номер места: ");
                    airplane.cancelBooking(sc.nextLine().trim().toUpperCase());
                    break;
                case "5":
                    System.out.print("Введите номер места: ");
                    airplane.showInfo(sc.nextLine().trim().toUpperCase());
                    break;
                case "6":
                    airplane.saveToFile(FILE_NAME);
                    System.out.println("Все данные сохранены. До свидания!");
                    return;
                default:
                    System.out.println("❌ Неверный пункт меню!");
            }
        }
    }
}
