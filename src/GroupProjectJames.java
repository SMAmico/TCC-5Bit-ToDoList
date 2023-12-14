import java.util.ArrayList;
import java.util.Scanner;

/*
 * Create scanner object to read the users input 
 * Display options (Adding a task, remove a task, display all tasks, display completed tasks, or exit). 
 * Change my method to double linked list, throw and exception that say you can only do 1 through 5.
 * had this code checked out by the proffsor anderson, if anything need to be changed lmk, used marvin code and made some changes 
 * to it, so marvin code is back bone of this code. Also made it start at 0 instead of 1.
 */
public class GroupProjectJames {
	public static void main(String[] args) {
		// -------------------------------------------
		// Used a arraylist to show as and example but we need it to be changed to
		// doublylinked so please change code if need be
		// ArrayList<String> tasks = new ArrayList<>();
		// ArrayList<String> tasksDone = new ArrayList<>();
		ToDoList tasks = new ToDoList();// these aren't generic
		ToDoList tasksDone = new ToDoList();
		// -------------------------------------------
		Scanner scanner = new Scanner(System.in);
		String input = "";

		while (!input.equals("5")) {
			// System.out.println("--------------------------------"); for style if you
			// wanted to add
			System.out.println("Please select an option number:");
			System.out.println("Task added will be in numbers to be able to call");
			System.out.println("--------------------------------");
			System.out.println("1. Add task");
			System.out.println("2. Remove task");
			System.out.println("3. Display all tasks");
			System.out.println("4. Display completed tasks");
			System.out.println("5. Exit");
			System.out.println("--------------------------------");

			input = scanner.nextLine();

			if (input.equals("1")) {
				System.out.println("--------------------------------");
				System.out.println("Enter a name for the task:");
				System.out.println("--------------------------------");
				String title = scanner.nextLine();
				System.out.print(" enter some info about it : ");
				String content = scanner.nextLine();
				System.out.print(" next, enter a due date : ");
				String deadline = scanner.nextLine();
				if (tasks.addNode(title, content, deadline)) {
					System.out.println("--------------------------------");
					System.out.println("Task added.");
					System.out.println("--------------------------------");
				}
			} else if (input.equals("2")) {
				System.out.println("--------------------------------");
				System.out.println("Enter the index of the task to remove:");
				System.out.println("--------------------------------");
				int index = scanner.nextInt();
				scanner.nextLine(); // consume newline left-over
				index--; // adjust index to start from 0
				if (index >= 0 && index < tasks.size()) {
					Node taskDeleted = tasks.getTask(index);
					tasksDone.addNode(taskDeleted.title, taskDeleted.content, taskDeleted.deadline);
					tasks.removeNode(index);
					System.out.println("--------------------------------");
					System.out.println("Task removed.");
					System.out.println("--------------------------------");
				} else {
					System.out.println("--------------------------------");
					System.out.println("Task not found or does not Exist.");
					System.out.println("--------------------------------");
					throw new IllegalArgumentException("No index was found or does not exist!");
				}
			} else if (input.equals("3")) {
				System.out.println("--------------------------------");
				System.out.println("All tasks:");
				System.out.println("--------------------------------");
				if (!tasks.isEmpty()) {
					for (int i = 0; i < tasks.size(); i++) {
						Node listTask = tasks.getTask(i);
						System.out.println("|Task:");
						System.out.println("| " + (i + 1) + ". " + listTask.title);
						System.out.println("|    :" + listTask.content);
						System.out.println("|        Due by: " + listTask.deadline);
						System.out.println("--------------------------------");
					}
					System.out.println(" ~end of todo list! ~");
				} else {
					System.out.println(" List is empty! ");
				}
			} else if (input.equals("4")) {
				System.out.println("--------------------------------");
				System.out.println("Here's what you've completed:");
				System.out.println("--------------------------------");
				if (!tasksDone.isEmpty()) {
					for (int i = 0; i < tasksDone.size(); i++) {
						Node listTask = tasksDone.getTask(i);
						System.out.println("Task:");
						System.out.println("| " + (i + 1) + ". " + listTask.title);
						System.out.println("|    :" + listTask.content);
						System.out.println("|        Due by: " + listTask.deadline);
						System.out.println("|--------------------------------");
					}
				System.out.println(" ~ that's all you've done! look at you go! ~");
			} else {
				System.out.println(" List is empty! ");
			}
			} else if (input.equals("5")) {
				System.out.println("--------------------------------");
				System.out.println("Exiting.");
				System.out.println("--------------------------------");
			} else {
				System.out.println("--------------------------------");
				System.out.println("Invalid option, try again.");
				System.out.println("--------------------------------");
				throw new IllegalArgumentException("Not one of the choices, enter a numbers between 1 and 5.");
			}
		}
	}
}
