import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        // Sample books and users
        library.addBook(new Book(1, "Java Programming"));
        library.addBook(new Book(2, "Data Structures"));
        library.addUser(new User(1, "Meet"));
        library.addUser(new User(2, "Abhi"));

        while (true) {
            System.out.println("\n=== Library Menu ===");
            System.out.println("1. View Books");
            System.out.println("2. View Users");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    library.viewBooks();
                    break;
                case 2:
                    library.viewUsers();
                    break;
                case 3:
                    System.out.print("Enter Book ID to issue: ");
                    int issueId = sc.nextInt();
                    library.issueBook(issueId);
                    break;
                case 4:
                    System.out.print("Enter Book ID to return: ");
                    int returnId = sc.nextInt();
                    library.returnBook(returnId);
                    break;
                case 5:
                    System.out.println("Exiting system. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
