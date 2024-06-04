import java.util.ArrayList;
import java.util.Scanner;

class Book {
    private int id;
    private String title;
    private String author;
    private boolean isBorrowed;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isBorrowed = false;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void borrow() {
        isBorrowed = true;
    }

    public void returnBook() {
        isBorrowed = false;
    }

    @Override
    public String toString() {
        return "Book ID: " + id + ", Title: " + title + ", Author: " + author + ", Borrowed: " + isBorrowed;
    }
}

public class CollegeLibrary {
    private static ArrayList<Book> books = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\nCollege Library Management System");
            System.out.println("1. Add Book");
            System.out.println("2. List Books");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    listBooks();
                    break;
                case 3:
                    borrowBook();
                    break;
                case 4:
                    returnBook();
                    break;
                case 5:
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }

    private static void addBook() {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter book author: ");
        String author = scanner.nextLine();
        int id = books.size() + 1;
        books.add(new Book(id, title, author));
        System.out.println("Book added successfully.");
    }

    private static void listBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available in the library.");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    private static void borrowBook() {
        System.out.print("Enter book ID to borrow: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        Book book = findBookById(id);
        if (book != null && !book.isBorrowed()) {
            book.borrow();
            System.out.println("Book borrowed successfully.");
        } else if (book == null) {
            System.out.println("Book not found.");
        } else {
            System.out.println("Book is already borrowed.");
        }
    }

    private static void returnBook() {
        System.out.print("Enter book ID to return: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        Book book = findBookById(id);
        if (book != null && book.isBorrowed()) {
            book.returnBook();
            System.out.println("Book returned successfully.");
        } else if (book == null) {
            System.out.println("Book not found.");
        } else {
            System.out.println("Book is not borrowed.");
        }
    }

    private static Book findBookById(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }
}
1