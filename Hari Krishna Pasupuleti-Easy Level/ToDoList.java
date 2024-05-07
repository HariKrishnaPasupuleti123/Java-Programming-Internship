
import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {
    private static ArrayList<String> tasks = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("ToDo List Menu:");
            System.out.println("1. Add Task");
            System.out.println("2. Delete Task");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. View Tasks");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addTask(scanner);
                    break;
                case 2:
                    deleteTask(scanner);
                    break;
                case 3:
                    markTaskAsCompleted(scanner);
                    break;
                case 4:
                    viewTasks();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 5);

        scanner.close();
    }

    private static void addTask(Scanner scanner) {
        System.out.print("Enter the task to add: ");
        String task = scanner.nextLine();
        tasks.add(task);
        System.out.println("Task added successfully!");
    }

    private static void deleteTask(Scanner scanner) {
        System.out.print("Enter the index of the task to delete: ");
        int index = scanner.nextInt();
        if (index >= 0 && index < tasks.size()) {
            String deletedTask = tasks.remove(index);
            System.out.println("Task \"" + deletedTask + "\" deleted successfully!");
        } else {
            System.out.println("Invalid index!");
        }
    }

    private static void markTaskAsCompleted(Scanner scanner) {
        System.out.print("Enter the index of the task to mark as completed: ");
        int index = scanner.nextInt();
        if (index >= 0 && index < tasks.size()) {
            String completedTask = tasks.get(index);
            tasks.remove(index);
            System.out.println("Task \"" + completedTask + "\" marked as completed!");
        } else {
            System.out.println("Invalid index!");
        }
    }

    private static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks in the list.");
        } else {
            System.out.println("Tasks:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }
}
