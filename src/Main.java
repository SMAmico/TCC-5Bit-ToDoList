// Importing the Scanner class to take user input
import java.util.Scanner;

// Main class that contains the main method to run the ToDoList program
public class Main {
    // Main method where the program execution starts
    public static void main(String[] args) {
        // Creating an instance of the ToDoList class to manage tasks
        ToDoList2 toDoList2 = new ToDoList2();
        // Creating a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Infinite loop to keep the program running until the user chooses to exit
        while (true) {
            // Displaying the menu options for the user
            System.out.println("Choose an option:");
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. View Tasks");
            System.out.println("4. View Task History");
            System.out.println("5. Exit");

            // Reading the user's choice
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline

            // Switch statement to perform actions based on user's choice
            switch (choice) {
                case 1:
                    // Prompting the user to enter task details and adding the task to the list
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter priority (low, medium, high): ");
                    String priority = scanner.nextLine();
                    System.out.print("Enter deadline: ");
                    String deadline = scanner.nextLine();
                    toDoList.addTask(description, priority, deadline);
                    break;

                case 2:
                    // Removing a task from the list
                    toDoList2.removeTask();
                    break;

                case 3:
                    // Displaying the current tasks in the list
                    toDoList2.viewTasks();
                    break;

                case 4:
                    // Displaying the history of completed tasks
                    toDoList2.viewTaskHistory();
                    break;

                case 5:
                    // Exiting the program
                    System.out.println("Exiting the program.");
                    System.exit(0);
                    break;

                default:
                    // Handling an invalid choice by the user
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        }
    }
}


