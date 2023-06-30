import java.util.Arrays;
import java.util.Random;

/**
 * Реализуйте метод, принимающий в качестве аргументов два целочисленных
 * массива, и возвращающий новый массив, каждый элемент которого равен разности
 * элементов двух входящих массивов в той же ячейке.
 * Если длины массивов не равны, необходимо как-то оповестить пользователя.
 */

public class Homework12 {
    public static void main(String[] args) {

        int[] arr1 = new int[new Random().nextInt(10) + 1];
        int[] arr2 = new int[arr1.length + new Random().nextInt(2)];
        int[] result = processArray(arr1, arr2);
        if (result.length == 0)
            System.out.println("Размерности массивов не совпадают.");
        else
            System.out.println(Arrays.toString(result));
    }

    static int[] processArray(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length)
            return new int[0];

        fillArray(arr1);
        fillArray(arr2);

        int[] result = new int[arr1.length];
        for (int i = 0; i < result.length; i++)
            result[i] = arr1[i] - arr2[i];
        return result;
    }

    static void fillArray(int[] array) {
        Random rndNumber = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rndNumber.nextInt(20);
        }
        System.out.println(Arrays.toString(array));
    }
}
