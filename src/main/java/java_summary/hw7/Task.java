package java_summary.hw7;
/*
Допустим, у нас есть коллекция состоящая из строк. Arrays.asList(«Highload», «High», «Load», «Highload»).
Посчитайте, сколько раз объект «High» встречается в коллекции. Используйте Stream API.
*/

import java.util.List;
import java.util.function.Predicate;

public class Task {
    public static void main(String[] args) {
        List<String> list = List.of("Highload", "High", "Load", "Highload");
        int count = 0;
        for (String s : list) {
            if (s.equals("High")) {
                count++;
            }
        }
        System.out.println(count);
        long countStream = list.stream().filter(s -> s.equals("High")).count();
        System.out.println(countStream);
    }
}
