import java.util.Scanner;

/**
 * Разработайте программу, которая выбросит Exception, когда пользователь вводит
 * пустую строку. Пользователю должно показаться сообщение, что пустые строки
 * вводить нельзя.
 */

public class Homework24 {

    static Scanner scan = new Scanner(System.in, "ibm866");

    public static void main(String[] args) {

        System.out.print("Введите строку: ");
        String input = scan.nextLine();
        if (input.length() == 0)
            throw new EmptyString("Пустые строки вводить нельзя.");
        else
            System.out.println(input);
    }
}

class EmptyString extends RuntimeException {
    public EmptyString(String messege) {
        super(messege);
    }
}
