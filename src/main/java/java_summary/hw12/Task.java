package java_summary.hw12;
//1 уровень сложности: Необходимо смоделировать библиотеку.
// +Для каждой книги библиотечного фонда известны автор, название и год издания.
// +Для читателя библиотеки будем хранить ФИО и электронный адрес (объекты типа EmailAddress).
// + Каждый читатель может взять в библиотеке одну или несколько книг - их тоже сохраним.
//+ Ещё нам понадобится флаг читательского согласия на уведомления по электронной почте.
// Рассылки организуют сотрудники библиотеки: напоминают о сроке возврата книг, сообщают новости.
//    Разработайте соответствующие классы.

import com.github.javafaker.Faker;

import java.util.*;
import java.util.stream.Collectors;

//   + Task 1. Получить список всех книг библиотеки, отсортированных по году издания.
//   +Task 2. Требуется создать список рассылки (объекты типа EmailAddress) из адресов всех читателей библиотеки.
//    При этом флаг согласия на рассылку учитывать не будем: библиотека закрывается, так что хотим оповестить всех.
//   +Task 3. Снова нужно получить список рассылки. Но на этот раз включаем в него только адреса читателей,
//    которые согласились на рассылку. Дополнительно нужно проверить, что читатель взял из библиотеки больше одной книги.
//   + Task 4. Получить список всех книг, взятых читателями. Список не должен содержать дубликатов
//    (книг одного автора, с одинаковым названием и годом издания).
//    +Task 5. Проверить, взял ли кто-то из читателей библиотеки какие-нибудь книги Оруэлла.
//    +Task 6. Узнать наибольшее число книг, которое сейчас на руках у читателя.
//
//    Task 7*. Вернёмся к нашим email-рассылкам. Теперь нужно не просто отправить письма всем,
//    кто согласился на рассылку, — будем рассылать разные тексты двум группам:
// - тем, у кого взято меньше двух книг, просто расскажем о новинках библиотеки;
// - тем, у кого две книги и больше, напомним о том, что их нужно вернуть в срок.
// То есть надо написать метод, который вернёт два списка адресов (типа EmailAddress):
// с пометкой OK — если книг не больше двух, или TOO_MUCH — если их две и больше. Порядок групп не важен.
//
//
//    Можно решить любое количество задач. Все задачи будем разбирать на занятии.
//    Единственное условие: попробуйте решить все задачи с помощью Stream API.
public class Task {
    public static void main(String[] args) {
        Faker faker = new Faker(new Random(50));
        List<Book> bookList = generateBookList(20, faker);
        List<Reader> readerList = generateReadersList(10, faker, bookList);
        for (Book book : bookList) {
            System.out.println(book);
        }
        System.out.println("************");

        for (Reader reader : readerList) {
            System.out.println(reader);
        }
        System.out.println("************");

        bookList.stream().sorted(Comparator.comparing(Book::getYearOfPublishing)).forEach(System.out::println);
        System.out.println("************");

        readerList.stream()
                .map(Reader::email)
                .forEach(System.out::println);
        System.out.println("************");

        readerList.stream()
                .filter(reader -> reader.isSubscribed() && reader.booksTaken().size() > 0)
                .map(Reader::email)
                .forEach(System.out::println);
        System.out.println("************");

        readerList.stream()
                .flatMap(reader -> reader.booksTaken().stream())
                .collect(Collectors.toSet())
                .forEach(System.out::println);
        System.out.println("************");

        System.out.println(readerList.stream()
                .flatMap(reader -> reader.booksTaken().stream())
                .anyMatch(book -> book.getAuthor().equals("George Oruell")));
        System.out.println("************");

        System.out.println(readerList.stream()
                .max(Comparator.comparing(reader -> reader.booksTaken().size()))
                .get().booksTaken().size());

        System.out.println(readerList.stream()
                .mapToInt(reader1 -> reader1.booksTaken().size())
                .max()
                .getAsInt());
        System.out.println("************");

        var groups = groupReaders(readerList);
        groups.forEach(System.out::println);

        groupReaders2(readerList).forEach(System.out::println);

    }

    public static List<Book> generateBookList(int size, Faker faker) {
        List<Book> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(new Book(faker.book().title(), faker.book().author(), faker.random().nextInt(1900, 2023)));
        }
        return list;
    }

    public static List<Reader> generateReadersList(int size, Faker faker, List<Book> bookList) {
        List<Reader> readers = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Collections.shuffle(bookList);
            readers.add(new Reader(faker.hobbit().character(),
                    new EmailAddress(faker.internet().emailAddress()),
                    new ArrayList<>(bookList.subList(0, faker.random().nextInt(10))),
                    faker.random().nextBoolean()));
        }
        return readers;
    }

    public static List<List<Reader>> groupReaders(List<Reader> input) {
        List<Reader> readersWithLessThenTwo = new ArrayList<>();
        List<Reader> readersWhoReallyRead = new ArrayList<>();
        for (Reader reader : input) {
            if (reader.isSubscribed()) {
                if (reader.booksTaken().size() > 2) {
                    readersWhoReallyRead.add(reader);
                } else {
                    readersWithLessThenTwo.add(reader);
                }
            }
        }
        return List.of(readersWhoReallyRead, readersWithLessThenTwo);
    }

    public static List<List<Reader>> groupReaders2(List<Reader> input) {
        Map<Boolean, List<Reader>> group = input.stream()
                .filter(Reader::isSubscribed)
                .collect(Collectors.partitioningBy(reader -> reader.booksTaken().size() > 2));
        return List.of(group.get(true), group.get(false));
    }
}
