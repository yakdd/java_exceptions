import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Реализуйте метод, который запрашивает у пользователя ввод дробного числа
 * (типа float), и возвращает введенное значение. Ввод текста вместо числа не
 * должно приводить к падению приложения, вместо этого, необходимо повторно
 * запросить у пользователя ввод данных.
 */

public class Homework21 {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println(getFloat());
        scan.close();
    }

    static float getFloat() {
        while (true) {
            try {
                System.out.print("Введите дробное число: ");
                Float number = scan.nextFloat();
                return number;
            } catch (InputMismatchException ex) {
                System.out.println("Неверные данные. Повторите ввод числа.");
                scan.nextLine();
            }
        }
    }
}