import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static int count = 0;
    static String[] surnames = new String[100];
    static String[] initials = new String[100];
    static int[] ages = new int[100];
    static String[] genders = new String[100];

    public static void main(String[] args) {
        boolean isExit = false;
        while (!isExit) {
            System.out.println("1. Ввод нового пользователя");
            System.out.println("2. Вывод списка пользователей");
            System.out.println("3. Вывод отсортированного списка по возрасту");
            System.out.println("4. Вывод отсортированного списка по возрасту и полу");
            System.out.println("5. Выход");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    addUser();
                    break;
                case 2:
                    printUsers();
                    break;
                case 3:
                    printUsersSortedByAge();
                    break;
                case 4:
                    printUsersSortedByAgeAndGender();
                    break;
                case 5:
                    isExit = true;
                    break;
                default:
                    System.out.println("Неверный выбор");
                    break;
            }
        }
    }

    private static void addUser() {
        sc.nextLine();
        System.out.println("Введите фамилию:");
        String surname = sc.nextLine();
        System.out.println("Введите инициалы:");
        String initials = sc.nextLine();
        System.out.println("Введите возраст:");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.println("Введите пол:");
        String gender = sc.nextLine();
        surnames[count] = surname;
        Main.initials[count] = initials;
        ages[count] = age;
        genders[count] = gender;
        count++;
    }

    private static void printUsers() {
        System.out.println("Фамилия И.О. Возраст Пол");
        for (int i = 0; i < count; i++) {
            System.out.println(surnames[i] + " " + initials[i] + " " + ages[i] + " " + genders[i]);
        }
    }

    private static void printUsersSortedByAge() {
        int[] sortedIndexes = new int[count];
        for (int i = 0; i < count; i++) {
            sortedIndexes[i] = i;
        }
        for (int i = 0; i < count; i++) {
            for (int j = i + 1; j < count; j++) {
                if (ages[sortedIndexes[i]] > ages[sortedIndexes[j]]) {
                    int temp = sortedIndexes[i];
                    sortedIndexes[i] = sortedIndexes[j];
                    sortedIndexes[j] = temp;
                }
            }
        }
        System.out.println("Фамилия И.О. Возраст Пол");
        for (int i = 0; i < count; i++) {
            int index = sortedIndexes[i];
            System.out.println(surnames[index] + " " + initials[index] + " " + ages[index] + " " + genders[index]);
        }
    }

    private static void printUsersSortedByAgeAndGender() {
        int[] sortedIndexes = new int[count];
        for (int i = 0; i < count; i++) {
            sortedIndexes[i] = i;
        }
        for (int i = 0; i < count; i++) {
            for (int j = i + 1; j < count; j++) {
                int compareResult = Integer.compare(ages[sortedIndexes[i]], ages[sortedIndexes[j]]);
                if (compareResult > 0 || (compareResult == 0 && genders[sortedIndexes[i]].compareTo(genders[sortedIndexes[j]]) > 0)) {
                    int temp = sortedIndexes[i];
                    sortedIndexes[i] = sortedIndexes[j];
                    sortedIndexes[j] = temp;
                }
            }
        }
        System.out.println("Фамилия И.О. Возраст Пол");
        for (int i = 0; i < count; i++) {
            int index = sortedIndexes[i];
            System.out.println(surnames[index] + " " + initials[index] + " " + ages[index] + " " + genders[index]);
        }
    }

}