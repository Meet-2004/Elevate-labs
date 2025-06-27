import java.io.*;
import java.util.Scanner;

public class main {
    static final String FILE_NAME = "notes.txt";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Notes App Menu ---");
            System.out.println("1. Add Note");
            System.out.println("2. View Notes");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addNote(sc);
                    break;
                case 2:
                    viewNotes();
                    break;
                case 3:
                    System.out.println("Exiting... Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 3);

        sc.close();
    }

    static void addNote(Scanner sc) {
        try {
            System.out.print("Enter your note: ");
            String note = sc.nextLine();

            FileWriter writer = new FileWriter(FILE_NAME, true); // append mode
            writer.write(note + "\n");
            writer.close();

            System.out.println("Note saved successfully!");
        } catch (IOException e) {
            System.out.println("Error writing to file.");
            e.printStackTrace();
        }
    }

    static void viewNotes() {
        try {
            FileReader reader = new FileReader(FILE_NAME);
            BufferedReader br = new BufferedReader(reader);
            String line;

            System.out.println("\n--- Your Notes ---");
            while ((line = br.readLine()) != null) {
                System.out.println("- " + line);
            }

            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("No notes found. Add a note first.");
        } catch (IOException e) {
            System.out.println("Error reading file.");
            e.printStackTrace();
        }
    }
}
