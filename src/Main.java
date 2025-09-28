import model.Abiturient;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Головний клас програми для управління абітурієнтами
 * Реалізує функціонал пошуку та сортування абітурієнтів
 */
public class Main {

    /**
     * Точка входу в програму
     * @param args аргументи командного рядка
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Abiturient> abiturients = createAbiturientsList();
        runApplication(scanner, abiturients);
    }

    /**
     * Запускає головний цикл програми
     * @param scanner об'єкт для зчитування введених даних
     * @param abiturients список абітурієнтів
     */
    private static void runApplication(Scanner scanner, List<Abiturient> abiturients) {
        System.out.println("=== СИСТЕМА УПРАВЛІННЯ АБІТУРІЄНТАМИ ===");

        while (true) {
            printMenu();
            int choice = getIntInput(scanner, "Оберіть пункт меню: ");

            if (!processUserChoice(scanner, abiturients, choice)) {
                break;
            }

            System.out.println("\n" + "=".repeat(50) + "\n");
        }

        scanner.close();
    }

    /**
     * Обробляє вибір користувача з меню
     * @param scanner об'єкт для зчитування введених даних
     * @param abiturients список абітурієнтів
     * @param choice вибір користувача
     * @return true - продовжити роботу програми, false - завершити роботу
     */
    private static boolean processUserChoice(Scanner scanner, List<Abiturient> abiturients, int choice) {
        switch (choice) {
            case 1:
                searchByName(scanner, abiturients);
                return true;
            case 2:
                searchByMinScore(scanner, abiturients);
                return true;
            case 3:
                showTopN(scanner, abiturients);
                return true;
            case 4:
                showAllAbiturients(abiturients);
                return true;
            case 0:
                System.out.println("Дякуємо за використання програми!");
                return false;
            default:
                System.out.println("Невірний вибір! Спробуйте ще раз.");
                return true;
        }
    }

    /**
     * Виконує пошук абітурієнтів за іменем
     * @param scanner об'єкт для зчитування введених даних
     * @param abiturients список абітурієнтів
     */
    private static void searchByName(Scanner scanner, List<Abiturient> abiturients) {
        System.out.print("Введіть ім'я для пошуку: ");
        String name = scanner.nextLine();
        printAbiturientsByName(abiturients, name);
    }

    /**
     * Виконує пошук абітурієнтів з середнім балом вище заданого
     * @param scanner об'єкт для зчитування введених даних
     * @param abiturients список абітурієнтів
     */
    private static void searchByMinScore(Scanner scanner, List<Abiturient> abiturients) {
        double minScore = getDoubleInput(scanner, "Введіть мінімальний бал: ");
        printAbiturientsWithScoreAbove(abiturients, minScore);
    }

    /**
     * Виводить топ-N абітурієнтів за середнім балом
     * @param scanner об'єкт для зчитування введених даних
     * @param abiturients список абітурієнтів
     */
    private static void showTopN(Scanner scanner, List<Abiturient> abiturients) {
        int n = getIntInput(scanner, "Введіть кількість абітурієнтів: ");
        printTopNAbiturients(abiturients, n);
    }

    /**
     * Виводить всіх абітурієнтів
     * @param abiturients список абітурієнтів
     */
    private static void showAllAbiturients(List<Abiturient> abiturients) {
        System.out.println("Всі абітурієнти:");
        printAbiturients(abiturients);
    }

    /**
     * Виводить головне меню програми
     */
    public static void printMenu() {
        System.out.println("МЕНЮ:");
        System.out.println("1. Пошук абітурієнтів за іменем");
        System.out.println("2. Пошук абітурієнтів з балом вище заданого");
        System.out.println("3. Топ-n абітурієнтів за середнім балом");
        System.out.println("4. Показати всіх абітурієнтів");
        System.out.println("0. Вийти з програми");
    }

    /**
     * Безпечно зчитує ціле число з консолі
     * @param scanner об'єкт для зчитування введених даних
     * @param message повідомлення для користувача
     * @return введене ціле число
     */
    public static int getIntInput(Scanner scanner, String message) {
        while (true) {
            try {
                System.out.print(message);
                int value = Integer.parseInt(scanner.nextLine());
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Помилка! Будь ласка, введіть ціле число.");
            }
        }
    }

    /**
     * Безпечно зчитує дробове число з консолі
     * @param scanner об'єкт для зчитування введених даних
     * @param message повідомлення для користувача
     * @return введене дробове число
     */
    public static double getDoubleInput(Scanner scanner, String message) {
        while (true) {
            try {
                System.out.print(message);
                double value = Double.parseDouble(scanner.nextLine());
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Помилка! Будь ласка, введіть число (наприклад: 85.5).");
            }
        }
    }

    /**
     * Створює та ініціалізує список абітурієнтів
     * @return список абітурієнтів
     */
    public static List<Abiturient> createAbiturientsList() {
        List<Abiturient> abiturients = new ArrayList<>();

        abiturients.add(new Abiturient(1, "Петренко", "Іван", "Олександрович",
                "м. Київ, вул. Хрещатик, 1", "+380501234567", 92.5));
        abiturients.add(new Abiturient(2, "Іваненко", "Марія", "Петрівна",
                "м. Львів, вул. Свободи, 15", "+380671234568", 88.3));
        abiturients.add(new Abiturient(3, "Коваленко", "Іван", "Михайлович",
                "м. Одеса, вул. Дерибасівська, 10", "+380631234569", 95.2));
        abiturients.add(new Abiturient(4, "Шевченко", "Олександр", "Іванович",
                "м. Харків, вул. Сумська, 25", "+380501234570", 79.8));
        abiturients.add(new Abiturient(5, "Бондаренко", "Наталія", "Сергіївна",
                "м. Дніпро, вул. Набережна, 5", "+380671234571", 91.7));
        abiturients.add(new Abiturient(6, "Мельник", "Іван", "Васильович",
                "м. Вінниця, вул. Соборна, 30", "+380631234572", 86.4));
        abiturients.add(new Abiturient(7, "Кравченко", "Ольга", "Андріївна",
                "м. Запоріжжя, вул. Перемоги, 12", "+380501234573", 94.1));
        abiturients.add(new Abiturient(8, "Ткаченко", "Сергій", "Олегович",
                "м. Чернівці, вул. Українська, 8", "+380671234574", 82.9));

        return abiturients;
    }

    /**
     * Виводить інформацію про всіх абітурієнтів у списку
     * @param abiturients список абітурієнтів для виведення
     */
    public static void printAbiturients(List<Abiturient> abiturients) {
        if (abiturients.isEmpty()) {
            System.out.println("Список абітурієнтів порожній.");
            return;
        }

        for (Abiturient abiturient : abiturients) {
            System.out.println(abiturient.toString());
        }
    }

    /**
     * Виводить абітурієнтів з вказаним іменем
     * @param abiturients список абітурієнтів для пошуку
     * @param firstName ім'я для пошуку
     */
    public static void printAbiturientsByName(List<Abiturient> abiturients, String firstName) {
        if (abiturients == null || firstName == null) {
            System.out.println("Помилка: некоректні вхідні дані");
            return;
        }

        boolean found = false;
        System.out.println("Абітурієнти з іменем '" + firstName + "':");

        for (Abiturient abiturient : abiturients) {
            if (abiturient.getFirstName().equalsIgnoreCase(firstName)) {
                System.out.println(abiturient.toString());
                found = true;
            }
        }

        if (!found) {
            System.out.println("Абітурієнтів з іменем '" + firstName + "' не знайдено.");
        }
    }

    /**
     * Виводить абітурієнтів з середнім балом вище заданого
     * @param abiturients список абітурієнтів для пошуку
     * @param minScore мінімальний середній бал
     */
    public static void printAbiturientsWithScoreAbove(List<Abiturient> abiturients, double minScore) {
        if (abiturients == null) {
            System.out.println("Помилка: некоректні вхідні дані");
            return;
        }

        boolean found = false;
        System.out.println("Абітурієнти з середнім балом вище " + minScore + ":");

        for (Abiturient abiturient : abiturients) {
            if (abiturient.getAverageScore() > minScore) {
                System.out.println(abiturient.toString());
                found = true;
            }
        }

        if (!found) {
            System.out.println("Абітурієнтів з середнім балом вище " + minScore + " не знайдено.");
        }
    }

    /**
     * Виводить n абітурієнтів з найвищим середнім балом
     * @param abiturients список абітурієнтів для сортування
     * @param n кількість абітурієнтів для виведення
     */
    public static void printTopNAbiturients(List<Abiturient> abiturients, int n) {
        if (abiturients == null) {
            System.out.println("Помилка: некоректні вхідні дані");
            return;
        }

        if (n <= 0) {
            System.out.println("Кількість абітурієнтів повинна бути більше 0.");
            return;
        }

        if (n > abiturients.size()) {
            n = abiturients.size();
            System.out.println("Увага: кількість абітурієнтів менша за запитувану. Буде показано " + n + " абітурієнтів.");
        }

        // Створюємо копію списку для сортування
        List<Abiturient> sortedList = new ArrayList<>(abiturients);

        // Сортуємо за середнім балом у спадному порядку
        sortedList.sort((a1, a2) -> Double.compare(a2.getAverageScore(), a1.getAverageScore()));

        System.out.println("Топ-" + n + " абітурієнтів з найвищим середнім балом:");
        for (int i = 0; i < n; i++) {
            System.out.println((i + 1) + ". " + sortedList.get(i).toString());
        }
    }
}
