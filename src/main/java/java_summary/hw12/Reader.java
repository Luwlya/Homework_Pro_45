package java_summary.hw12;

import java.util.List;

public record Reader(String fullName, EmailAddress email, List<Book> booksTaken, boolean isSubscribed) {
}
