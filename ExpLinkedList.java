package DSA;

class Node {
	int value;
	Node next;

	public Node(int value) {
		this.value = value;
		this.next = null;
	}
}

class MyLinkedList {
	Node head;
	Node tail;
	int size = 0;

	public void add(int value) {
		Node newNode = new Node(value);
		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
		size++;
	}

	public Node getValue(int value) {
		Node currentNode = head;
		while (currentNode != null) {
			if (currentNode.value == value) {
				return currentNode;
			}
			currentNode = currentNode.next;
		}
		return null;
	}

	public Node getIndex(int index) {
		int currentIndex = 0;
		Node currentNode = head;
		while (currentNode != null) {
			if (currentIndex == index) {
				return currentNode;
			}
			currentNode = currentNode.next;
			currentIndex++;
		}
		return null;
	}

	public void addNewNode(int value, int index) {
		if (index < 0 || index > size - 1) {
			System.out.println("Invalid index.");
			return;
		}
		Node newNode = new Node(value);
		if (index == 0) {
			newNode.next = head;
			head = newNode;
		} else if (index == size - 1) {
			tail.next = newNode;
			tail = newNode;
		} else {
			Node currentNode = head;
			for (int i = 0; i < size - 1; i++) {
				currentNode = currentNode.next;
			}
			newNode.next = currentNode.next;
			currentNode.next = newNode;
		}
		size++;

	}

	public void print() {
		Node currentNode = head;
		while (currentNode != null) {
			System.out.println(currentNode.value);
			currentNode = currentNode.next;
		}
	}
}

public class ExpLinkedList {
	public static void main(String[] args) {
		MyLinkedList linkedList = new MyLinkedList();

		linkedList.add(3);
		linkedList.add(5);
		linkedList.add(12);
		linkedList.add(17);
		linkedList.add(18);
		linkedList.add(19);
		linkedList.print();

		Node nodeWithValue5 = linkedList.getValue(5);
		System.out.println("Node with value 5: " + nodeWithValue5.value);

		Node nodeAtIndex4 = linkedList.getIndex(4);
		System.out.println("Node at index 4: " + nodeAtIndex4.value);

		linkedList.addNewNode(65, 5);
		linkedList.print();
	}
}
