package java_summary.hw5;
/*Task 3. Дана строка. Вывести количество появлений каждого символа в этой строке. Например:
        Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer eu feugiat tellus.
        Nam molestie diam sed libero egestas pellentesque. Nulla.


        Символ e встречается 20 раз.
        Символ пробел/space встречается 19 раз.
        Символ l встречается 11 раз.
        Символ i встречается 11 раз.
        Символ t встречается 11 раз.
        Символ s встречается 10 раз.
        Символ u встречается 7 раз.
        Символ a встречается 7 раз.
        Символ n встречается 6 раз.
        Символ m встречается 6 раз.
        Символ o встречается 6 раз.
        Символ r встречается 5 раз.
        Символ . встречается 4 раз.
        Символ g встречается 4 раз.
        Символ d встречается 4 раз.
        Символ c встречается 3 раз.
        Символ p встречается 3 раз.
        Символ , встречается 1 раз.
        Символ f встречается 1 раз.
        Символ b встречается 1 раз.
        Символ q встречается 1 раз.*/


import java.util.HashMap;
import java.util.Map;

public class Task3 {
    public static void main(String[] args) {
        printCharacterCounts("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer eu feugiat tellus. " +
                "Nam molestie diam sed libero egestas pellentesque. Nulla.");
    }

    public static void printCharacterCounts(String s) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char character = s.charAt(i);
            Integer count = countMap.get(character);
            if (count == null) {
                count = 0;
            }
            count++;
            countMap.put(character, count);
        }
        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            System.out.println("Символ " + entry.getKey() + " встречается " + entry.getValue() + " раз.");
        }
    }
}
