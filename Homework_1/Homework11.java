import java.util.Random;

/**
 * Реализуйте 3 метода, чтобы в каждом из них получить разные исключения
 */

public class Homework11 {
    public static void main(String[] args) {
        int rnd = new Random().nextInt(10);

        System.out.println(method1(rnd, rnd + 1));
        System.out.println(method2(rnd, rnd + 1));
        System.out.println(method3(rnd + "abc"));

    }

    static int method1(int length, int index) {
        System.out.printf("Длина массива: %d\n", length);
        System.out.printf("Искомый индекс: %d\n", index);
        int[] array = new int[length];
        return array[index]; // ArrayIndexOutOfBoundsException
    }

    static int method2(int length, int index) {
        System.out.printf("Содать массив из %d элементов\n", length - index);
        int[] array = new int[length - index]; // NegativeArraySizeException
        return array.length;
    }

    static int method3(String string) {
        return Integer.parseInt(string); // NumberFormatException
    }
}
