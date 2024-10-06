import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        int size, maxValue, threshold;
        logger.log("Запускаем программу");

        logger.log("Просим пользователя ввести входные данные для списка");
        size = intDialog("Введите размер списка: ", 0);
        maxValue = intDialog("Введите верхнюю границу для значений: ", 0);
        logger.log("Создаём и наполняем список");
        List<Integer> list = new ArrayList<>(size);
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            list.add(random.nextInt(maxValue + 1));
        }
        System.out.println("Вот случайный список: " + list);

        logger.log("Просим пользователя ввести входные данные для фильтрации");
        threshold = intDialog("Введите порог для фильтра: ", maxValue);

        logger.log("Запускаем фильтрацию");
        Filter filter = new Filter(threshold);
        List<Integer> result = filter.filterOut(list);
        logger.log("Выводим результат на экран");
        System.out.println("Отфильтрованный список: " + result);
        logger.log("Завершаем программу");

    }

    private static int intDialog(String s, int max) {
        while (true) {
            System.out.print(s);
            if (scanner.hasNextInt()) {
                int result = scanner.nextInt();
                if (result > 0) {
                    if (max == 0 || result <= max) {
                        return result;
                    } else {
                        System.out.println("Требуется число меньше " + (max + 1));
                    }
                } else {
                    System.out.println("Данные введены не коректно. " +
                            "Требуется положительное число, " +
                            "больше нуля.");
                }
            } else {
                System.out.println("Данные введены не коректно. " +
                        "Требуется число.");
                scanner.nextLine();
            }
        }
    }
}