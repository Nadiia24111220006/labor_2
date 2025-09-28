package model;

/**
 * Клас, що представляє абітурієнта
 * Містить інформацію про особові дані та академічні результати
 */
public class Abiturient {
    private int id;
    private String lastName;
    private String firstName;
    private String middleName;
    private String address;
    private String phone;
    private double averageScore;

    /**
     * Конструктор за замовчуванням
     */
    public Abiturient() {
    }

    /**
     * Конструктор з параметрами
     * @param id унікальний ідентифікатор
     * @param lastName прізвище
     * @param firstName ім'я
     * @param middleName по батькові
     * @param address адреса
     * @param phone телефон
     * @param averageScore середній бал
     */
    public Abiturient(int id, String lastName, String firstName, String middleName,
                      String address, String phone, double averageScore) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.address = address;
        this.phone = phone;
        this.averageScore = averageScore;
    }

    /**
     * Отримує ідентифікатор абітурієнта
     * @return ідентифікатор
     */
    public int getId() {
        return id;
    }

    /**
     * Встановлює ідентифікатор абітурієнта
     * @param id ідентифікатор
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Отримує прізвище абітурієнта
     * @return прізвище
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Встановлює прізвище абітурієнта
     * @param lastName прізвище
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Отримує ім'я абітурієнта
     * @return ім'я
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Встановлює ім'я абітурієнта
     * @param firstName ім'я
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Отримує по батькові абітурієнта
     * @return по батькові
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * Встановлює по батькові абітурієнта
     * @param middleName по батькові
     */
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    /**
     * Отримує адресу абітурієнта
     * @return адреса
     */
    public String getAddress() {
        return address;
    }

    /**
     * Встановлює адресу абітурієнта
     * @param address адреса
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Отримує телефон абітурієнта
     * @return телефон
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Встановлює телефон абітурієнта
     * @param phone телефон
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Отримує середній бал абітурієнта
     * @return середній бал
     */
    public double getAverageScore() {
        return averageScore;
    }

    /**
     * Встановлює середній бал абітурієнта
     * @param averageScore середній бал
     */
    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }

    /**
     * Повертає рядкове представлення об'єкта абітурієнта
     * @return рядок з інформацією про абітурієнта
     */
    @Override
    public String toString() {
        return String.format(
                "Абітурієнт [ID: %d, Прізвище: %s, Ім'я: %s, По батькові: %s, " +
                        "Адреса: %s, Телефон: %s, Середній бал: %.2f]",
                id, lastName, firstName, middleName, address, phone, averageScore
        );
    }

    /**
     * Порівнює два об'єкти абітурієнтів за ідентифікатором
     * @param obj об'єкт для порівняння
     * @return true, якщо об'єкти рівні, false - якщо ні
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Abiturient that = (Abiturient) obj;
        return id == that.id;
    }

    /**
     * Повертає хеш-код об'єкта на основі ідентифікатора
     * @return хеш-код
     */
    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
}
