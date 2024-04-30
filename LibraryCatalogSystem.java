package WeeklyAssignment2;
import java.time.LocalDate;

// Main class to test the library catalog system
public class LibraryCatalogSystem {
    public static void main(String[] args) {
        // Example usage
        Book book1 = new Book("Java Programming", "William Son", LocalDate.of(2020, 5, 15));
        DVD dvd1 = new DVD("Inception", "Christopher Nolan", LocalDate.of(2010, 7, 16));
        Journal journal1 = new Journal("Scientific American", "Various", LocalDate.of(2021, 1, 1), 123);

        book1.borrowItem();
        book1.borrowItem(); // Trying to borrow the same book again

        dvd1.borrowItem();
        dvd1.returnItem();

        journal1.getType(); // Trying to return a journal that hasn't been borrowed
    }
}

// Abstract class for Library Item
abstract class LibraryItem {
    private String title;
    private String author;
    private LocalDate publicationDate;

    public LibraryItem(String title, String author, LocalDate publicationDate) {
        this.title = title;
        this.author = author;
        this.publicationDate = publicationDate;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    // Abstract method to be implemented by subclasses
    public abstract String getType();
}

// Interface for borrowable items
interface Borrowable {
    void borrowItem();
    void returnItem();
}

// Concrete subclass for Book
class Book extends LibraryItem implements Borrowable {
    private boolean isBorrowed;

    public Book(String title, String author, LocalDate publicationDate) {
        super(title, author, publicationDate);
        this.isBorrowed = false;
    }

    @Override
    public String getType() {
        return "Book";
    }

    @Override
    public void borrowItem() {
        if (!isBorrowed) {
            isBorrowed = true;
            System.out.println(getType() + " '" + getTitle() + "' has been borrowed.");
        } else {
            System.out.println(getType() + " '" + getTitle() + "' is already borrowed.");
        }
    }

    @Override
    public void returnItem() {
        if (isBorrowed) {
            isBorrowed = false;
            System.out.println(getType() + " '" + getTitle() + "' has been returned.");
        } else {
            System.out.println(getType() + " '" + getTitle() + "' is not borrowed.");
        }
    }
}

// Concrete subclass for Journal
class Journal extends LibraryItem {
    private int issueNumber;

    public Journal(String title, String author, LocalDate publicationDate, int issueNumber) {
        super(title, author, publicationDate);
        this.issueNumber = issueNumber;
    }

    @Override
    public String getType() {
        return "Journal";
    }

    public int getIssueNumber() {
        return issueNumber;
    }
}

// Concrete subclass for DVD
class DVD extends LibraryItem implements Borrowable {
    private boolean isBorrowed;

    public DVD(String title, String author, LocalDate publicationDate) {
        super(title, author, publicationDate);
        this.isBorrowed = false;
    }

    @Override
    public String getType() {
        return "DVD";
    }

    @Override
    public void borrowItem() {
        if (!isBorrowed) {
            isBorrowed = true;
            System.out.println(getType() + " '" + getTitle() + "' has been borrowed.");
        } else {
            System.out.println(getType() + " '" + getTitle() + "' is already borrowed.");
        }
    }

    @Override
    public void returnItem() {
        if (isBorrowed) {
            isBorrowed = false;
            System.out.println(getType() + " '" + getTitle() + "' has been returned.");
        } else {
            System.out.println(getType() + " '" + getTitle() + "' is not borrowed.");
        }
    }
}


