/*
Реализовать бинарное дерево поиска.
 */

package Task_03_2;

public class Main {
	public static void main(String args[]) {

		BinTree<Integer> tree = new BinTree<>();
		tree.insertNode(6);
		tree.insertNode(8);
		tree.insertNode(5);
		tree.insertNode(8);
		tree.insertNode(2);
		tree.insertNode(9);
		tree.insertNode(7);
		tree.insertNode(4);
		tree.insertNode(10);
		tree.insertNode(3);
		tree.insertNode(1);

		tree.printTree();

		tree.deleteNode(5);
		tree.printTree();

		BinTreeNode<Integer> foundNode = tree.findNode(7);
		foundNode.printNode();
	}
}
