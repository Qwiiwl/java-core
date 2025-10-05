import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // ================== Первая программа ==================

        // 1. Вывести числа от 1 до 100 (по 10 в строке)
        for (int i = 1; i <= 100; i++) {
            System.out.print(i + "\t");
            if (i % 10 == 0) System.out.println();
        }

        System.out.print("\nВведите N: ");
        int N = sc.nextInt();

        // 2. Сумма чисел от 1 до N
        int sum = 0;
        for (int i = 1; i <= N; i++) sum += i;
        System.out.println("Сумма: " + sum);

        // 3. Произведение чисел от 1 до N
        long prod = 1;
        for (int i = 1; i <= N; i++) prod *= i;
        System.out.println("Произведение: " + prod);

        // 4. Сумма четных чисел от 1 до N
        int evenSum = 0;
        for (int i = 2; i <= N; i += 2) evenSum += i;
        System.out.println("Сумма четных: " + evenSum);

        // 5. Сумма цифр числа
        int num = 124;
        int digitSum = 0;
        int temp = num;
        while (temp > 0) {
            digitSum += temp % 10;
            temp /= 10;
        }
        System.out.println("Сумма цифр " + num + ": " + digitSum);

        // 6. Разворот числа
        int number = 1234, rev = 0;
        while (number > 0) {
            rev = rev * 10 + number % 10;
            number /= 10;
        }
        System.out.println("Разворот: " + rev);

        // 7. Факториал
        int factN = 5;
        long fact = 1;
        for (int i = 1; i <= factN; i++) fact *= i;
        System.out.println("Факториал " + factN + ": " + fact);

        // 8. Первое число > 1000, которое делится на 7
        int x = 1001;
        while (x % 7 != 0) x++;
        System.out.println("Первое число > 1000 делящееся на 7: " + x);

        // 9. Простые числа до N
        System.out.println("Простые числа до " + N + ":");
        for (int i = 2; i <= N; i++) {
            boolean prime = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    prime = false;
                    break;
                }
            }
            if (prime) System.out.print(i + " ");
        }
        System.out.println();

        // 10. Треугольник из звездочек
        int rows = 5;

        // 1. Прямой треугольник
        System.out.println("Треугольник 1:");
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        System.out.println();

        // 2. Обратный треугольник
        System.out.println("Треугольник 2:");
        for (int i = rows; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        System.out.println();

        // 3. Обратный треугольник со сдвигом вправо
        System.out.println("Треугольник 3:");
        for (int i = rows; i >= 1; i--) {
            for (int s = 0; s < rows - i; s++) { // пробелы перед звёздами
                System.out.print("  ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        System.out.println();

        // 4. Прямой треугольник со сдвигом вправо
        System.out.println("Треугольник 4:");
        for (int i = 1; i <= rows; i++) {
            for (int s = 0; s < rows - i; s++) { // пробелы перед звёздами
                System.out.print("  ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        // ================== Вторая программа ==================

        // Обмен значений
        System.out.println("\nВведите два числа:");
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println("До обмена: a=" + a + ", b=" + b);
        int tmp = a;
        a = b;
        b = tmp;
        System.out.println("После обмена: a=" + a + ", b=" + b);

        // Таблица умножения
        System.out.println("\nТаблица умножения:");
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.print((i * j) + "\t");
            }
            System.out.println();
        }

        // Конвертер валют
        double exchange = 12500; // курс
        System.out.println("\nВведите сумму в долларах:");
        double usd = sc.nextDouble();
        System.out.println("Сумма в сумах: " + (usd * exchange));

        // Четное или нечетное
        System.out.println("\nВведите число:");
        int n = sc.nextInt();
        if (n % 2 == 0) System.out.println("Четное");
        else System.out.println("Нечетное");

        // Максимум из трёх
        System.out.println("\nВведите три числа:");
        int xx = sc.nextInt();
        int yy = sc.nextInt();
        int zz = sc.nextInt();
        int max = Math.max(xx, Math.max(yy, zz));
        System.out.println("Максимум: " + max);

        // Калькулятор
        System.out.println("\nКалькулятор: введите два числа и операцию (+, -, *, /):");
        double num1 = sc.nextDouble();
        double num2 = sc.nextDouble();
        char op = sc.next().charAt(0);

        switch (op) {
            case '+': System.out.println("Результат: " + (num1 + num2)); break;
            case '-': System.out.println("Результат: " + (num1 - num2)); break;
            case '*': System.out.println("Результат: " + (num1 * num2)); break;
            case '/':
                if (num2 != 0) System.out.println("Результат: " + (num1 / num2));
                else System.out.println("Деление на ноль!");
                break;
            default: System.out.println("Неизвестная операция!");
        }

        // Среднее арифметическое
        System.out.println("\nВведите количество чисел:");
        int m = sc.nextInt();
        int[] arr = new int[m];
        int sumArr = 0;
        System.out.println("Введите элементы массива:");
        for (int i = 0; i < m; i++) {
            arr[i] = sc.nextInt();
            sumArr += arr[i];
        }
        System.out.println("Среднее арифметическое: " + (double) sumArr / m);

        // Поиск элемента
        System.out.println("\nВведите число для поиска:");
        int target = sc.nextInt();
        boolean found = false;
        for (int val : arr) {
            if (val == target) {
                found = true;
                break;
            }
        }
        System.out.println(found ? "Элемент найден" : "Элемент не найден");

        // Мини-игра "Угадай число"
        Random rnd = new Random();
        int secret = rnd.nextInt(100) + 1; // от 1 до 100
        int tries = 5;
        System.out.println("\nУгадайте число от 1 до 100. У вас " + tries + " попыток.");
        boolean win = false;

        while (tries > 0) {
            int guess = sc.nextInt();
            if (guess == secret) {
                win = true;
                break;
            } else if (guess > secret) {
                System.out.println("Меньше!");
            } else {
                System.out.println("Больше!");
            }
            tries--;
       }
       if (win) System.out.println("Поздравляем! Вы угадали.");
        else System.out.println("Вы проиграли. Загаданное число: " + secret);
    }
}
