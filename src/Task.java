// Importing the Scanner class to take user input
import java.util.Scanner;

// Class representing a task with a description, priority, deadline, completion status, and references to the previous and next tasks
class Task {
    String description;
    String priority;
    String deadline;
    boolean completed;
    Task prev;
    Task next;

    // Constructor to initialize the task with given details and default completion status and references
    public Task(String description, String priority, String deadline) {
        this.description = description;
        this.priority = priority;
        this.deadline = deadline;
        this.completed = false;
        this.prev = null;
        this.next = null;
    }
}

// Class representing a to-do list with tasks, a task history, and methods to manipulate the task list
class ToDoList {
    Task head;
    Task tail;
    TaskHistory history;

    // Constructor to initialize an empty to-do list and a task history
    public ToDoList() {
        this.head = null;
        this.tail = null;
        this.history = new TaskHistory();
    }

    // Method to add a new task to the to-do list
    public void addTask(String description, String priority, String deadline) {
        Task newTask = new Task(description, priority, deadline);
        if (head == null) {
            head = newTask;
            tail = newTask;
        } else {
            tail.next = newTask;
            newTask.prev = tail;
            tail = newTask;
        }
        System.out.println("Task added successfully.");
    }

    // Method to remove a task from the to-do list and add it to the task history
    public void removeTask() {
        if (head == null) {
            System.out.println("Task list is empty. Nothing to remove.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the description of the task to remove: ");
        String descriptionToRemove = scanner.nextLine();

        Task current = head;
        while (current != null) {
            if (current.description.equals(descriptionToRemove)) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }

                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev;
                }

                history.addCompletedTask(current);
                System.out.println("Task removed successfully.");
                return;
            }
            current = current.next;
        }

        System.out.println("Task not found. Nothing to remove.");
    }

    // Method to display the current tasks in the to-do list
    public void viewTasks() {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }

        System.out.println("Task List:");
        Task current = head;
        while (current != null) {
            System.out.println("Description: " + current.description);
            System.out.println("Priority: " + current.priority);
            System.out.println("Deadline: " + current.deadline);
            System.out.println("Completed: " + (current.completed ? "Yes" : "No"));
            System.out.println("---------------");
            current = current.next;
        }
    }

    // Method to display the history of completed tasks
    public void viewTaskHistory() {
        history.viewCompletedTasks();
    }
}

// Class representing the history of completed tasks with references to the completed head and tail
class TaskHistory {
    Task completedHead;
    Task completedTail;

    // Constructor to initialize an empty task history
    public TaskHistory() {
        this.completedHead = null;
        this.completedTail = null;
    }

    // Method to add a completed task to the task history
    public void addCompletedTask(Task completedTask) {
        if (completedHead == null) {
            completedHead = completedTask;
            completedTail = completedTask;
        } else {
            completedTail.next = completedTask;
            completedTask.prev = completedTail;
            completedTail = completedTask;
        }
    }

    // Method to display the history of completed tasks
    public void viewCompletedTasks() {
        if (completedHead == null) {
            System.out.println("No completed tasks in history.");
            return;
        }

        System.out.println("Completed Task History:");
        Task current = completedHead;
        while (current != null) {
            System.out.println("Description: " + current.description);
            System.out.println("Priority: " + current.priority);
            System.out.println("Deadline: " + current.deadline);
            System.out.println("---------------");
            current = current.next;
        }
    }
}

import java.util.Scanner;

class Node {
    String description;
    String priority;
    String date;
    Node next;
    Node prev;

    Node(String description, String priority, String date) {
        this.description = description;
        this.priority = priority;
        this.date = date;
        this.next = null;
        this.prev = null;
    }
}

class ToDoList {
    Node head;
    Node tail;

    ToDoList() {
        head = null;
        tail = null;
    }

    void addTask(String description, String priority, String date) {
        Node newTask = new Node(description, priority, date);
        if (head == null) {
            head = newTask;
            tail = newTask;
        } else {
            tail.next = newTask;
            newTask.prev = tail;
            tail = newTask;
        }
    }

    void removeTask(String description) throws Exception {
        if (head == null) {
            throw new Exception("The list is empty.");
        }
        Node current = head;
        while (current != null) {
            if (current.description.equals(description)) {
                if (current.prev == null) {
                    head = current.next;
                } else {
                    current.prev.next = current.next;
                }
                if (current.next == null) {
                    tail = current.prev;
                } else {
                    current.next.prev = current.prev;
                }
                return;
            }
            current = current.next;
        }
        throw new Exception("The task does not exist.");
    }

    void viewTasks() {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.println("Description: " + current.description);
            System.out.println("Priority: " + current.priority);
            System.out.println("Date: " + current.date);
            System.out.println();
            current = current.next;
        }
    }

    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter 1 to add a task.");
            System.out.println("Enter 2 to remove a task.");
            System.out.println("Enter 3 to view tasks.");
            System.out.println("Enter 4 to exit.");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter priority (low, medium, high): ");
                    String priority = scanner.nextLine();
                    System.out.print("Enter date (MM/DD/YYYY): ");
                    String date = scanner.nextLine();
                    toDoList.addTask(description, priority, date);
                    break;
                case 2:
                    System.out.print("Enter description: ");
                    String descriptionToRemove = scanner.nextLine();
                    try {
                        toDoList.removeTask(descriptionToRemove);
                        System.out.println("Task removed successfully.");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    toDoList.viewTasks();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
