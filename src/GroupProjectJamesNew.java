
/*
 * GroupProjectJamesNew(thrilling name I know) is designed to utilize the methods and 
 * structure ToDoList.java from the extra file. this provides a UI and applications/ management. 
 * both ToDoList.java and GroupProjectJamesNew.java are in the same default package so no imports needed.
 */
import java.util.Scanner;

public class GroupProjectJamesNew {
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
		boolean running = true;
		while (running) {
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

			input = scanner.nextLine();// fetch the user choice

			if (input.equals("1")) {
				System.out.println("--------------------------------");
				System.out.println("Enter a name for the task:");
				System.out.println("--------------------------------");
				String title = scanner.nextLine();// take all three fields
				System.out.print(" enter some info about it : ");
				String content = scanner.nextLine();
				System.out.print(" next, enter a due date : ");
				String deadline = scanner.nextLine();
				if (tasks.addNode(title, content, deadline)) {// create an object with those definitions
					System.out.println("--------------------------------");
					System.out.println("Task added.");
					System.out.println("--------------------------------");
				}
			} else if (input.equals("2")) {
				System.out.println("--------------------------------");
				System.out.println("Enter the index of the task to remove (from 1) :");
				System.out.println("--------------------------------");
				int index = scanner.nextInt();
				scanner.nextLine(); // consume newline left-over
				index--; // adjust index to start from 0
				try { // if the user input or program input is incorrect, catch any exceptions that
						// occur and continue the program.
					Node taskDeleted = tasks.getTask(index);// fetch task before it is removed
					tasksDone.addNode(taskDeleted.title, taskDeleted.content, taskDeleted.deadline);
					tasks.removeNode(index);// ONLY remove node after the deleted node has been successfully added to
											// history
					System.out.println("Task removed.");
					System.out.println("--------------------------------");
				} catch (IndexOutOfBoundsException R) {// catch numbers beyond list
					System.out.println("--------------------------------");
					System.out.println("there is no accessible task at that index.");
					System.out.println("--------------------------------");
				}
			} else if (input.equals("3")) {
				System.out.println("--------------------------------");
				System.out.println("All tasks:");
				System.out.println("--------------------------------");
				if (!tasks.isEmpty()) {
					for (int i = 0; i < tasks.size(); i++) {
						Node listTask = tasks.getTask(i);
						// Check if the task is null before trying to access its properties(saves an unneeded exception)
						if (listTask != null) {
							System.out.println("|Task:");
							System.out.println("| " + (i + 1) + ". " + listTask.title);
							System.out.println("|    :" + listTask.content);
							System.out.println("|        Due by: " + listTask.deadline);
							System.out.println("--------------------------------");
						}
					}
					System.out.println(" ~end of todo list! ~");
					System.out.println("--------------------------------");

				} else {
					System.out.println(" List is empty! ");
					System.out.println("--------------------------------");

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
						System.out.println("--------------------------------");
					}
					System.out.println(" ~ that's all you've done! look at you go! ~");
					System.out.println("--------------------------------");

				} else {
					System.out.println(" List is empty! ");
					System.out.println("--------------------------------");

				}
			} else if (input.equals("5")) {
				System.out.println("--------------------------------");
				System.out.println("Exiting.");
				System.out.println("--------------------------------");
				scanner.close();//eclipse was mad about this
				running = false;//cuts the program while statement
			} else {
				System.out.println("--------------------------------");
				System.out.println("Invalid option, try again.");
				System.out.println("--------------------------------");
				// throw new IllegalArgumentException("Not one of the choices, enter a numbers
				// between 1 and 5."); THIS WAS THE OLD EXCEPTION THROWER, now has been turned
				// into a not-frag grenade. it should continue the program despite incorrect
				// input
			}
		}
	}
}
