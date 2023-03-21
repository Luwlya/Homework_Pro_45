package java_task.hw3;


import java.util.Random;

public class EmployeeGenerator {
    private final Random random = new Random();

    public Employee generate() {
        return new Employee(generateRandomString(), random.nextInt(18, 60), generateRandomRating(),
                random.nextDouble(2000.0, 15000.0), generateRandomDepartment());
    }

    private String generateRandomString() {
        char[] alphabet = {'А', 'Б', 'В', 'Г', 'Ґ', 'Д', 'Е', 'Є', 'Ж', 'З',
                'И', 'І', 'Ї', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С',
                'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ь', 'Ю', 'Я',};
        String result = "";
        for (int i = 0; i < 5; i++) {
            int index = random.nextInt(alphabet.length);
            result += alphabet[index];
        }
        return result;
    }

    private Rating generateRandomRating() {
        Rating[] ratings = Rating.values();
        int i = random.nextInt(0, ratings.length);
        return ratings[i];
    }

    private Department generateRandomDepartment() {
        Department[] departments = Department.values();
        int i = random.nextInt(0, departments.length);
        return departments[i];
    }
}
