/*
Realization from https://javarush.com/groups/posts/3111-strukturih-dannihkh-dvoichnoe-derevo-v-java
but with generic.
 */

package Task_03_2;

import java.util.Stack;

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
			BinTreeNode<T> heir = receiveHeir(currentNode);									// Search heir for deleting node
			if (currentNode == rootNode) {
				rootNode = heir;
			} else if (isLeftChild) {
				parentNode.setLeftChild(heir);
			} else {
				parentNode.setRightChild(heir);
			}
		}

		return true;	// Element deleted successfully
	}

	// This method returns a node with the next value after the passed argument.
	// To do this, we first move to the right child, and then track the chain
	// of left descendants of this node.
	private BinTreeNode<T> receiveHeir(BinTreeNode<T> node) {
		BinTreeNode<T> parentNode = node;
		BinTreeNode<T> heirNode = node;
		BinTreeNode<T> currentNode = node.getRightChild();		// Go to right child

		while (currentNode != null) {							// As long as there are left descendants
			parentNode = heirNode;								// Set the heir as current node
			heirNode = currentNode;
			currentNode = currentNode.getLeftChild();			// Go to left child
		}

		if (heirNode != node.getRightChild()) {    				// If descendants is not right child
			parentNode.setLeftChild(heirNode.getRightChild());	// Then create connections between nodes
			heirNode.setRightChild(node.getRightChild());
		}

		return heirNode;										// Return heir
	}

	public void printTree() {				// Method to print tree to the terminal
		Stack globalStack = new Stack();	// Global stack for tree nodes
		globalStack.push(rootNode);

		int gaps = 32;						// Start value for distance between nodes
		boolean isRowEmpty = false;
		String separator = "-----------------------------------------------------------------";

		System.out.println(separator);		// A dash to indicate the beginning of a new tree

		while (!isRowEmpty) {
			Stack localStack = new Stack();	// Local stack for setting the descendants of the element
			isRowEmpty = true;

			for (int j = 0; j < gaps; j++) {
				System.out.print(' ');
			}

			while (!globalStack.isEmpty()) {								// While global stack has elements
				BinTreeNode<T> temp = (BinTreeNode<T>) globalStack.pop();	// Take the next element and delete it
				if (temp != null) {
					System.out.print(temp.getValue());						// Print it's value
					localStack.push(temp.getLeftChild());					// Save to local stack
					localStack.push(temp.getRightChild());

					if (temp.getLeftChild() != null || temp.getRightChild() != null) {
						isRowEmpty = false;
					}
				} else {
					System.out.print("__");	// If elements is empty
					localStack.push(null);
					localStack.push(null);
				}

				for (int j = 0; j < gaps * 2 - 2; j++) {
					System.out.print(' ');
				}
			}

			System.out.println();
			gaps /= 2; 								// When moving to the next level, the distance between the elements decreases each time

			while (!localStack.isEmpty()) {
				globalStack.push(localStack.pop());	// Move all elements from local stack to the global one
			}
		}
		System.out.println(separator);	// Print dash
	}
}
