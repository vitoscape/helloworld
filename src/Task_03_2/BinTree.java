/*
Realization from https://javarush.com/groups/posts/3111-strukturih-dannihkh-dvoichnoe-derevo-v-java
but with generic.
 */

package Task_03_2;

public class BinTree<T extends Comparable<T>> {
	private BinTreeNode<T> rootNode;

	public BinTree() {
		rootNode = null;
	}

	public BinTreeNode<T> findNode(T value) {	// Find node by value

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

	public boolean deleteNode(T value) {	// Delete node by value

		BinTreeNode<T> currentNode = rootNode;
		BinTreeNode<T> parentNode = rootNode;
		boolean isLeftChild = true;

		// Search the value
		while (currentNode.getValue() != value) {				// Condition of finding node with value
			parentNode = currentNode;

			if (value.compareTo(currentNode.getValue()) < 0) {	// Is moving to the left is needed
				isLeftChild = true;
				currentNode = currentNode.getLeftChild();
			} else {											// Or moving to the right
				isLeftChild = false;
				currentNode = currentNode.getRightChild();
			}

			if (currentNode == null) return false;				// The node with value was not found
		}

		// Delete found node
		if (currentNode.getLeftChild() == null && currentNode.getRightChild() == null) {	// Node has no children. Just delete this node

			if (currentNode == rootNode) rootNode = null;			// If this node is root node then the tree is clearing
			else if (isLeftChild) parentNode.setLeftChild(null);	// If not then node disconnects from parent
			else parentNode.setRightChild(null);

		} else if (currentNode.getRightChild() == null) {									// Node is replaced by left sub-tree if no right child

			if (currentNode == rootNode) rootNode = currentNode.getLeftChild();
			else if (isLeftChild) parentNode.setLeftChild(currentNode.getLeftChild());
			else parentNode.setRightChild(currentNode.getLeftChild());

		} else if (currentNode.getLeftChild() == null) {                                    // Node is replaced by right sub-tree if no left child

			if (currentNode == rootNode) rootNode = currentNode.getRightChild();
			else if (isLeftChild) parentNode.setLeftChild(currentNode.getRightChild());
			else parentNode.setRightChild(currentNode.getRightChild());

		} else {																			// If node has both children then the node is replaced by heir
			// TODO: Continue with heir
		}
	}
}
