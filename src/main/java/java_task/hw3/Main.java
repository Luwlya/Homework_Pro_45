package java_task.hw3;
/*+1. class Company имя и лист департаментов
+2. Энам Департаменты с 5 макисмум департаментами
+3. Класс Эплои с полями имя позраст зарплата и рейтинг
+4. Энам рейтинг
если рейтинг A то +20%
B +15%
C +5%
D 0%
E -5%
+5. Класс генератор который создает Эмплои и засовывет его в рандомный департамент с рандомным рейтингом и зарплатой
Эмплои должен иметьспособность сравниматься по всем полям кроме ретинга
+6. Сделать отдельный компаратор который сортирует по рейтингу
7. В классе Мэйн надо прописать только один метод с параметрок количеством сотрудников который с генерирует весь этот
процесс и выведет на экран Сотрудника с зп ДО и После

Повышать за надо пройдясь по листу сотрудников итератором
 */

public class Main {
    public static void main(String[] args) {
        Company company = createCompany(10, "Tomato");
        for (Employee employee : company.getEmployeeList()) {
            System.out.println(employee);
        }

        System.out.println("*****************");

        company.applyRatingCoefficients();
        for (Employee employee : company.getEmployeeList()) {
            System.out.println(employee);
        }


    }

    private static Company createCompany(int employeeCount, String name) {
        Company company = new Company(name);
        EmployeeGenerator employeeGenerator = new EmployeeGenerator();
        for (int i = 0; i < employeeCount; i++) {
            company.addEmployee(employeeGenerator.generate());
        }
        company.getEmployeeList().sort(new EmployeeComparator());
        return company;
    }

}
