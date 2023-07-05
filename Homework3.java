
/**
 * Напишите приложение, которое будет запрашивать у пользователя следующие данные,
 * разделенные пробелом: Фамилия Имя Отчество номертелефона
 * Форматы данных:
 *   фамилия, имя, отчество - строки
 *   номертелефона - целое беззнаковое число без форматирования
 * Ввод всех элементов через пробел.
 * Приложение должно проверить введенные данные по количеству.
 * Если количество не совпадает с требуемым, вернуть код ошибки, обработать его и показать
 * пользователю сообщение, что он ввел меньше и больше данных, чем требуется.
 * Приложение должно попытаться распарсить полученные значения и выделить из них требуемые
 * параметры. Если форматы данных не совпадают, нужно бросить исключение, соответствующее
 * типу проблемы. Можно использовать встроенные типы java и создать свои. Исключение должно
 * быть корректно обработано, пользователю выведено сообщение с информацией, что именно неверно.
 * Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии,
 * в него в одну строку должны записаться полученные данные, вида
 * <Фамилия><Имя><Отчество><номер_телефона>
 * Однофамильцы должны записаться в один и тот же файл, в отдельные строки.
 * Не забудьте закрыть соединение с файлом.
 * При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно
 * обработано, пользователь должен увидеть стектрейс ошибки.
 */

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Homework3 {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("Введите: Фамилия Имя Отчество Телефон (через пробел):");
            String data = scan.nextLine();

            int check = checkAmountOfData(data);
            if (check == -1)
                System.out.println("Недостаточно данных. Повоторите попытку.\n");
            else if (check == -2)
                System.out.println("Лишние данные. Повоторите попытку.\n");
            else {
                if (parseData(data)) {
                    try {
                        writeData(data);
                        System.out.println("Ваши данные успешно записаны в файл.\n");
                        break;
                    } catch (IOException ex) {
                        System.out.println("Ошибка записи в файл: " + ex.getMessage());
                    }
                }
            }
        }
        scan.close();
    }

    static int checkAmountOfData(String data) {
        String[] dataParts = data.split(" ");
        if (dataParts.length < 4)
            return -1;
        else if (dataParts.length > 4)
            return -2;
        else
            return 0;
    }

    static boolean parseData(String data) {
        String[] dataParts = data.split(" ");
        try {
            Long.parseLong(dataParts[3]);
            return true;
        } catch (NumberFormatException ex) {
            System.out.println("Недопустимый формат данных для телефона: " + ex.getMessage().split(" ")[3] + "\n");
            return false;
        }
    }

    static void writeData(String data) throws IOException {
        String[] dataParts = data.split(" ");
        try (FileWriter writer = new FileWriter(dataParts[0], true)) {
            for (String string : dataParts) {
                writer.append("<" + string + ">");
            }
            writer.append("\n");
        }
    }
}
