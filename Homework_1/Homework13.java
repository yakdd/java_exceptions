import java.util.Arrays;
import java.util.Random;

/**
 * Реализуйте метод, принимающий в качестве аргументов два целочисленных
 * массива, и возвращающий новый массив, каждый элемент которого равен частному
 * элементов двух входящих массивов в той же ячейке. Если длины массивов не
 * равны, необходимо как-то оповестить пользователя.
 * Важно: При выполнении метода единственное исключение, которое пользователь
 * может увидеть - RuntimeException, т.е. ваше.
 */

public class Homework13 {
    public static void main(String[] args) {

        int[] arr1 = new int[new Random().nextInt(10) + 1];
        int[] arr2 = new int[arr1.length + new Random().nextInt(2)];
        int[] result = processArray(arr1, arr2);
        System.out.println(Arrays.toString(result));
    }

    static int[] processArray(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length)
            throw new RuntimeException("Размерности массивов не совпадают.");

        fillArray(arr1);
        fillArray(arr2);

        int[] result = new int[arr1.length];
        for (int i = 0; i < result.length; i++) {
            if (arr2[i] == 0)
                throw new RuntimeException("Деление на ноль недопустимо.");
            else
                result[i] = arr1[i] / arr2[i];
        }
        return result;
    }

    static void fillArray(int[] array) {
        Random rndNumber = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rndNumber.nextInt(10);
        }
        System.out.println(Arrays.toString(array));
    }
}
