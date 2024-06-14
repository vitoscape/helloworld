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

	public void insertNode(T value) {
		BinTreeNode<T> newNode = new BinTreeNode<>();
		newNode.setValue(value);

		if (rootNode == null) {							// If there is no root node in tree then new node is root node
			rootNode = newNode;
		} else {										// Root node is occupied
			BinTreeNode<T> currentNode = rootNode;		// Start with root node
			BinTreeNode<T> parentNode;

			while(true) {
				parentNode = currentNode;
				if (value == currentNode.getValue()) {	// If there is same node in tree then return
					return;

				} else if (value.compareTo(currentNode.getValue()) < 0) {    // Move to left child
					currentNode = currentNode.getLeftChild();

					if (currentNode == null) {								// If the end of branch
						parentNode.setLeftChild(newNode);					// Then insert to the left and return
						return;
					}

				} else {													// Move to right child
					currentNode = currentNode.getRightChild();

					if (currentNode == null) {								// If the end of branch
						parentNode.setRightChild(newNode);					// Then insert to the right and return
						return;
					}
				}
			}
		}
	}
}
