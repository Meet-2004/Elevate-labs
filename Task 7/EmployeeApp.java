import java.sql.*;
import java.util.*;

public class EmployeeApp {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1. Add Employee\n2. View Employees\n3. Update Employee\n4. Delete Employee\n5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> addEmployee();
                case 2 -> viewEmployees();
                case 3 -> updateEmployee();
                case 4 -> deleteEmployee();
                case 5 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    public static void addEmployee() {
        try (Connection con = DBConnection.getConnection()) {
            String query = "INSERT INTO employees (name, email, salary) VALUES (?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(query);
            System.out.print("Enter name: ");
            String name = sc.next();
            System.out.print("Enter email: ");
            String email = sc.next();
            System.out.print("Enter salary: ");
            double salary = sc.nextDouble();

            pst.setString(1, name);
            pst.setString(2, email);
            pst.setDouble(3, salary);
            pst.executeUpdate();
            System.out.println("Employee added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void viewEmployees() {
        try (Connection con = DBConnection.getConnection()) {
            String query = "SELECT * FROM employees";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            System.out.println("\nEmployee List:");
            while (rs.next()) {
                System.out.printf("ID: %d | Name: %s | Email: %s | Salary: %.2f\n",
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getDouble("salary"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateEmployee() {
        try (Connection con = DBConnection.getConnection()) {
            System.out.print("Enter Employee ID to update: ");
            int id = sc.nextInt();

            String query = "UPDATE employees SET name=?, email=?, salary=? WHERE id=?";
            PreparedStatement pst = con.prepareStatement(query);
            System.out.print("New name: ");
            String name = sc.next();
            System.out.print("New email: ");
            String email = sc.nextLine();
            System.out.print("New salary: ");
            double salary = sc.nextDouble();

            pst.setString(1, name);
            pst.setString(2, email);
            pst.setDouble(3, salary);
            pst.setInt(4, id);
            int updated = pst.executeUpdate();
            if (updated > 0)
                System.out.println("Employee updated successfully!");
            else
                System.out.println("Employee ID not found!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteEmployee() {
        try (Connection con = DBConnection.getConnection()) {
            System.out.print("Enter Employee ID to delete: ");
            int id = sc.nextInt();
            String query = "DELETE FROM employees WHERE id=?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, id);
            int deleted = pst.executeUpdate();
            if (deleted > 0)
                System.out.println("Employee deleted successfully!");
            else
                System.out.println("Employee ID not found!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
