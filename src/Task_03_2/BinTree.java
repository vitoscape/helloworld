package Task_03_2;

public class BinTree<T extends Comparable<T>> {
	private BinTreeNode<T> rootNode;

	public BinTree() {
		rootNode = null;
	}

	public BinTreeNode<T> findNode(T value) {					// Find node by value
		BinTreeNode<T> currentNode = rootNode;					// Start search with root node
		while (currentNode.getValue() != value) {				// Search while element not found or all elements are not discovered
			if (value.compareTo(currentNode.getValue()) < 0) {	// Move to left child if value is less than current node
				currentNode = currentNode.getLeftChild();
			} else {											// Move to right child
				currentNode = currentNode.getRightChild();
			}

			if (currentNode == null) {							// If no children
				return null;
			}
		}

		return currentNode;
	}
}
