package DSA;

class Node {
	int value;
	Node left;
	Node right;

	Node(int value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}
}

class BinaryTree {
	Node root;

	public void add(int value) {
		root = addNode(root, value);
	}

	private Node addNode(Node root, int value) {
		if (root == null) {
			root = new Node(value);
			return root;
		}

		if (value < root.value) {
			root.left = addNode(root.left, value);
		} else if (value > root.value) {
			root.right = addNode(root.right, value);
		}

		return root;
	}

	public void delete(int value) {
		root = deleteNode(root, value);
	}

	private Node deleteNode(Node root, int value) {
		if (root == null) {
			return root;
		}

		if (value < root.value) {
			root.left = deleteNode(root.left, value);
		} else if (value > root.value) {
			root.right = deleteNode(root.right, value);
		} else {
			if (root.left == null) {
				return root.right;
			} else if (root.right == null) {
				return root.left;
			}

			root.value = minValue(root.right);

			root.right = deleteNode(root.right, root.value);
		}

		return root;
	}

	private int minValue(Node root) {
		int minValue = root.value;
		while (root.left != null) {
			minValue = root.left.value;
			root = root.left;
		}
		return minValue;
	}

	public boolean get(int value) {
		return getValue(root, value);
	}

	private boolean getValue(Node root, int value) {
		if (root == null) {
			return false;
		}

		if (value < root.value) {
			return getValue(root.left, value);
		} else if (value > root.value) {
			return getValue(root.right, value);
		} else {
			return true;
		}
	}
}

public class BalancedBinarySearchTree {
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.add(4);
		tree.add(2);
		tree.add(6);
		tree.add(1);
		tree.add(3);
		tree.add(5);
		tree.add(7);

		int valueToGet = 3;
		if (tree.get(valueToGet)) {
			System.out.println("Value " + valueToGet + " exists in the tree.");
		} else {
			System.out.println("Value " + valueToGet + " does not exist in the tree.");
		}

		int valueToDelete = 2;
		tree.delete(valueToDelete);
		if (tree.get(valueToDelete)) {
			System.out.println("Value " + valueToDelete + " exists in the tree.");
		} else {
			System.out.println("Value " + valueToDelete + " does not exist in the tree.");
		}
		
		int valueToAdd = 8;
		tree.add(valueToAdd);
		if (tree.get(valueToAdd)) {
			System.out.println("Value " + valueToAdd + " exists in the tree.");
		} else {
			System.out.println("Value " + valueToAdd + " does not exist in the tree.");
		}
		
	}
}
