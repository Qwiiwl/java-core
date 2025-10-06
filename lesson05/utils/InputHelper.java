package utils;
import java.util.Scanner;

public class InputHelper {
    private Scanner sc;

    public InputHelper(Scanner sc) {
        this.sc = sc;
    }

    public String readLine() {
        return sc.nextLine().trim();
    }

    public int readInt() {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Введите число: ");
            }
        }
    }

    public double readDouble() {
        while (true) {
            try {
                return Double.parseDouble(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Введите корректное число: ");
            }
        }
    }
}
