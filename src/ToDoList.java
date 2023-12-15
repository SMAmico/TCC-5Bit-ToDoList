
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

/*
 * ToDoList class defines a Doubly linked list object. it has the ability to store three strings, access 
 * and return any node in the list, remove any node in the list, and return data for any extracted node. 
 * additionally, there is an O(1) size and an isEmpty checker.
 */

class Node {// node object definition
	String content;
	String title;
	String deadline;
	Node prev;
	Node next;

	public Node(String title, String content, String deadline) {// individual node constructor, O(1)
		this.content = content;
		this.title = title;
		this.deadline = deadline;
		this.prev = null;
		this.next = null;
	}
}

class ToDoList {// creates a todolist object with a head and a tail node, as well as an overall
				// size
	Node head;
	Node tail;
	private int size = 0;

//this comment is just a test for my pc being able to edit files and push properly.
	// another test
	// Test
	public boolean addNode(String title, String content, String deadline) {// hiba's original code. adds a node within
																			// the todolist object. O(1)
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

	public boolean removeNode(int index) {// O(n)
		// this was original code from hiba. we couldn't debug it properly so we had to
		// replace it.
//		if (head == null || index < 0 || index > size) {
//				return false;
//			}
//			if (index == 0) {
//				head = head.next;
//				if (head != null) {
//					head.prev = null;
//				} else {
//					tail = null;
//				}
//				return true;
//			}
//			Node current = head;
//			int currentIndex = 0;
//
//			while (current != null && currentIndex < 0) {
//				current = current.next;
//				currentIndex++;
//			}
//
//			if (current == null) {
//				// index out of bounds
//				return false;
//			}
//			// Remove the node
//			Node prevNode = current.prev;
//			Node nextNode = current.next;
//
//			if (prevNode != null) {
//				prevNode.next = nextNode;
//			} else {
//				head = nextNode;
//			}
//			if (nextNode != null) {
//				nextNode.prev = prevNode;
//			} else {
//				tail = prevNode;
//			}
//			size--;
//			return true;

		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();// throw an exception if the index isn't in the DLList
		}
		Node walker = head;
		for (int i = 0; i < index; i++) {
			walker = walker.next;// grab the data before it's dereferenced
		}
		if (head == tail) {// if both are the same node, delete their references
			head = tail = null;
		} else if (walker == head) {// if it's the head, delete the head and reassign the head to the previous head
			head = head.next;
			head.prev = null;
		} else if (walker == tail) {// if it's the head, delete the head and reassign the head to the previous head
			tail = tail.prev;
			tail.next = null;
		} else {
			(walker.prev).next = walker.next;// if it's in the middle somewhere, tie the surrounding node's pointers
												// together
			(walker.next).prev = walker.prev;
		}

		size--;// decrease the size and return true
		return true;
	}

	public int size() {// returns size. incredible
		return size;
	}

	public Node getTask(int index) {// returns a selected node,O(n)
//		if(index <= size/2) {
//		Node walker = head;
//		for(int i = 0; i < index; i++) {
//			walker = walker.next;
//		}
//		return walker;
//		} else {
//			Node walker = tail;
//			for(int i = size; i > index; i--) {
//				walker = walker.next;
//			}
//			return walker;
//		}
		// check for the special case of an out of
		// bounds index
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		// if we got this far, the index is in bounds
		// we need to loop to that position in the list
		Node walker = head;
		// loop forwards "index" times
		for (int i = 0; i < index; i++) {
			walker = walker.next;
		}
		// now walker points to the Node at position "index"
		// return that node's data
		return walker;
	}

	public boolean isEmpty() {// returns true if the todolist is empty, O(1)
		if (head == null && tail == null && size == 0) {
			return true;
		}
		return false;
	}

	public String getTitle(Node r) {// returns title for a node O(1)
		return r.title;
	}

	public String getContent(Node r) {// returns content for a node O(1)
		return r.content;
	}

	public String getDeadline(Node r) {// returns deadline/duedate for a node, O(1)
		return r.deadline;
	}

}
