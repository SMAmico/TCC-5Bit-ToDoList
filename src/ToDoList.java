
/*
1. Create constructor to initialize tasks with description, priority, and deadline 
2.Create scanner object to read the users input -quit-James
3.Display options (Adding a task, remove a task, display all tasks, display completed tasks, or exit). -quit-James
4.Create cases for each option. 
5.Create doubly linked list to store all tasks -rexie
6.Have each task be represented by a node with properties like description, priority level, and due date -rexie
7.Create method to add a new task -hjam
8.Create method to remove a task  -hjam
9.Create method to display the current tasks -seth
10.Create method to view completed task history -seth
*/ 

class Node{
	String content;
	String title;
	String deadline;
	Node prev;
	Node next;
	
	
	public Node(String title, String content, String deadline) {
		this.content = content;
		this.title = title;
		this.deadline = deadline;

		this.prev = null;
		this.next = null;
	}
}

class ToDoList {
	Node head;
	Node tail;
	private int size = 0;
//this comment is just a test for my pc being able to edit files and push properly.
	//another test
	//Test
	public boolean addNode(String title, String content, String deadline) {
		Node newNode = new Node(title, content, deadline);
			if (head == null) {
				head = newNode;
			} else {
				tail.next = newNode;
				newNode.prev = tail;
			}
			tail = newNode;
			size++;
			return true;
	}
	
	public boolean removeNode(int index) {
		if (head == null || index < 0) {
				return false;
			}
			if (index == 0) {
				head = head.next;
				if (head != null) {
					head.prev = null;
				} else {
					tail = null;
				}
				return true;
			}
			Node current = head;
			int currentIndex = 0;

			while (current != null && currentIndex < 0) {
				current = current.next;
				currentIndex++;
			}

			if (current == null) {
				// index out of bounds
				return false;
			}
			// Remove the node
			Node prevNode = current.prev;
			Node nextNode = current.next;

			if (prevNode != null) {
				prevNode.next = nextNode;
			} else {
				head = nextNode;
			}
			if (nextNode != null) {
				nextNode.prev = prevNode;
			} else {
				tail = prevNode;
			}
			size--;
			return true;
		}
	    
	public double size() {
		return size;
	}
	
	public Node getTask(int index) {//returns a selected node
		if(index <= size/2) {
		Node walker = head;
		for(int i = 0; i < index; i++) {
			walker = walker.next;
		}
		return walker;
		} else {
			Node walker = tail;
			for(int i = size; i > index; i--) {
				walker = walker.next;
			}
			return walker;
		}
	}
	
	public boolean isEmpty() {
		if(head == null && tail == null && size == 0) {
			return true;
		}
		return false;
	}
	
	public String getTitle(Node r) {
		return r.title;
	}
	
	public String getContent(Node r) {
		return r.content;
	}
	public String getDeadline(Node r) {
		return r.deadline;
	}
	
}

