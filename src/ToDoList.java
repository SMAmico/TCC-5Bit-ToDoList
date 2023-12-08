
/*
1. Create constructor to initialize tasks with description, priority, and deadline 
2.Create scanner object to read the users input -quit-James
3.Display options (Adding a task, remove a task, display all tasks, display completed tasks, or exit). -quit-James
4.Create cases for each option. 
5.Create doubly linked list to store all tasks -rexie
6.Have each task be represented by a node with properties like description, priority level, and due date -rexie
7.Create method to add a new task -hjam
8.Create method to remove a task  -hjam
9.Create method to display the current tasks 
10.Create method to view completed task history
*/ 

class Node{
	String content;
	String priority;
	String deadline;
	boolean completed;
	Node prev;
	Node next;
	
	
	public Node(String content, String priority, String deadline) {
		this.content = content;
		this.priority = priority;
		this.deadline = deadline;
		this.completed = false;
		this.prev = null;
		this.next = null;
	}
}

class ToDoList {
	Node head;
	Node tail;
//this comment is just a test for my pc being able to edit files and push properly.
	//another test
	//Test
	private void addNode(String content, String priority, String deadline) {
		Node newNode = new Node(content, priority, deadline);
			if (head == null) {
				head = newNode;
			} else {
				tail.next = newNode;
				newNode.prev = tail;
			}
			tail = newNode;
			System.out.println("Task added to list!");
	}
	
	private boolean removeNode(int index) {
		//perhaps removes node from current ToDoList
		//and adds it to the deleted/completed ToDoList ?
		return false;
	}
	
	private void displayToDoList() {
		//shows current ToDoList
	}
	
	private ToDoList deletedItems() {
		//returns deleted ToDoList with displayToDoList
	}
	
	private void completedTask() {
		
	}
}

