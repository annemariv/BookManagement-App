import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    private static ArrayList<Book> books = new ArrayList<Book>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Book Manager");

        while(true){
            System.out.println("\nPress 1 to add a book");
            System.out.println("Press 2 to remove a book");
            System.out.println("Press 3 to see the current book list");
            System.out.println("Press any other key to exit");

            var userInput = scanner.nextLine();
            if (userInput.equals("1")) {
                userBook();
            } else if (userInput.equals("2")) {
                System.out.println("\nWhich book you want to remove? Please write the title: ");
                var title = scanner.nextLine();
                removeBook(title);
            } else if (userInput.equals("3")) {
                showBooks();
            } else{
                System.out.println("\nYou exited Book Manager!");
                break;
            }
        }
        scanner.close();
    }
    public static void addBook(Book book){
        books.add(book);
    }

    public static void userBook(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nPlease enter the title of the book you want to add: ");
        var title = scanner.nextLine();

        System.out.println("Please enter the author of the book you want to add: ");
        var author = scanner.nextLine();

        var book = new Book(title, author);
        addBook(book);
        System.out.println("Book added!");
    }

    public static void removeBook(String bookTitle){
        boolean isRemoved = false;

        for(Book book : books) {
            if (book.title.equals(bookTitle)) {
                books.remove(book);
                isRemoved = true;
                break;
            }
        }
        if (isRemoved) {
            System.out.println("Book removed!");
        } else{
            System.out.println("Book not found!");
        }
    }

    public static ArrayList<Book> getBooks(){
        return books;
    }

    public static void showBooks(){
       var booksList = getBooks();
       boolean foundBooks = false;

       System.out.println("\nYour list: ");
       for(Book book : booksList){

           System.out.println("\nThe title of the book: " + book.title);
           System.out.println("The author of the book: " + book.author);
           foundBooks = true;
       }
       if (!foundBooks){
           System.out.println("You have no books in the list.");
       }
    }
}