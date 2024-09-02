import java.util.ArrayList;
import java.util.Scanner;

// Interface for User
interface User {
    void login();
    void logout();
}

// Superclass for Library Staff
class LibraryStaff implements User {
    public void login() {
        System.out.println(getClass().getSimpleName() + " logged in");
    }

    public void logout() {
        System.out.println(getClass().getSimpleName() + " logged out");
    }

    public void viewBooks() {
        System.out.println("Viewing books");
    }
}

// Admin class extending LibraryStaff
class Admin extends LibraryStaff {
    public void addLibrarian() {
        System.out.println("Librarian added");
    }

    public void viewLibrarian() {
        System.out.println("Viewing librarians");
    }

    public void deleteLibrarian() {
        System.out.println("Librarian deleted");
    }

    public void deleteBooks() {
        System.out.println("Book deleted");
    }
}

// Librarian class extending LibraryStaff
class Librarian extends LibraryStaff {
    public void addBooks() {
        System.out.println("Books added");
    }

    public void issueBooks() {
        System.out.println("Book issued");
    }

    public void viewIssuedBooks() {
        System.out.println("Viewing issued books");
    }

    public void returnBooks() {
        System.out.println("Book returned");
    }
}

// Class for managing books
class BookManager {
    private ArrayList<Book> books;

    public BookManager() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book.getTitle());
    }

    public void viewBooks() {
        System.out.println("Viewing books");
        for (Book book : books) {
            System.out.println(book.getTitle() + " by " + book.getAuthor());
        }
    }

    public void deleteBook(Book book) {
        books.remove(book);
        System.out.println("Book deleted: " + book.getTitle());
    }
}

// Class representing a book
class Book {
    private String title;
    private String author;
    private int yearPublished;

    public Book(String title, String author, int yearPublished) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearPublished() {
        return yearPublished;
    }
}

// Class for managing issued books
class IssueManager {
    private ArrayList<IssuedBook> issuedBooks;

    public IssueManager() {
        this.issuedBooks = new ArrayList<>();
    }

    public void issueBook(Book book, User user) {
        issuedBooks.add(new IssuedBook(book, user));
        System.out.println("Book issued to " + user.getClass().getSimpleName());
    }

    public void viewIssuedBooks() {
        System.out.println("Viewing issued books");
        for (IssuedBook issuedBook : issuedBooks) {
            System.out.println("Book issued to " + issuedBook.getUser().getClass().getSimpleName() +
                    ": " + issuedBook.getBook().getTitle());
        }
    }

    public void returnBook(IssuedBook issuedBook) {
        issuedBooks.remove(issuedBook);
        System.out.println("Book returned: " + issuedBook.getBook().getTitle());
    }
}

// Class representing an issued book
class IssuedBook {
    private Book book;
    private User user;

    public IssuedBook(Book book, User user) {
        this.book = book;
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public User getUser() {
        return user;
    }
}

// Class for managing user data stored in CSV file
class UserDataManager {
    private String csvFilePath;

    public UserDataManager(String csvFilePath) {
        this.csvFilePath = csvFilePath;
    }

    public void loadUserData() {
        System.out.println("Loading user data from " + csvFilePath);
    }

    public void saveUserData() {
        System.out.println("Saving user data to " + csvFilePath);
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Admin admin = new Admin();
        Librarian librarian = new Librarian();
        BookManager bookManager = new BookManager();
        IssueManager issueManager = new IssueManager();
        UserDataManager userDataManager = new UserDataManager("user_data.csv");

        System.out.println("Welcome to Library Management System!");

        // Load user data
        userDataManager.loadUserData();

        // Admin login
        admin.login();

        // Adding a librarian
        admin.addLibrarian();

        // View all librarians
        admin.viewLibrarian();

        // Adding books
        bookManager.addBook(new Book("Book1", "Author1", 2000));
        bookManager.addBook(new Book("Book2", "Author2", 2005));

        // View all books
        bookManager.viewBooks();

        // Issue a book
        librarian.issueBooks();

        // View issued books
        issueManager.viewIssuedBooks();

        // Return a book
        issueManager.returnBook(new IssuedBook(new Book("Book1", "Author1", 2000), librarian));

        // Admin logout
        admin.logout();

        // Save user data
        userDataManager.saveUserData();

        scanner.close();
    }
}
