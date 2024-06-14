/*
Realization from https://javarush.com/groups/posts/3111-strukturih-dannihkh-dvoichnoe-derevo-v-java
but with generic.
 */

package Task_03_2;

public class BinTreeNode<T extends Comparable<T>> implements Comparable<BinTreeNode<T>> {
	private T value;
	private BinTreeNode<T> leftChild;
	private BinTreeNode<T> rightChild;

	public void printNode() {
		System.out.printf("Value of this node: %s", value.toString());
	}

	public T getValue() {
		return this.value;
	}

	public void setValue(final T value) {
		this.value = value;
	}

	public BinTreeNode<T> getLeftChild() {
		return this.leftChild;
	}

	public void setLeftChild(final BinTreeNode<T> leftChild) {
		this.leftChild = leftChild;
	}

	public BinTreeNode<T> getRightChild() {
		return this.rightChild;
	}

	public void setRightChild(final BinTreeNode<T> rightChild) {
		this.rightChild = rightChild;
	}

	@Override
	public String toString() {
		return "Node{ " +
				"value = " + value +
				", leftChild = " + leftChild +
				", rightChild = " + rightChild +
				'}';
	}

	/*
	 * Return difference between this object and another object
	 * Examples:
	 * 1) value21.compareTo(value20) = 1
	 * 2) value20.compareTo(value20) = 0
	 * 3) value19.compareTo(value20) = -1
	 */
	@Override
	public int compareTo(BinTreeNode<T> another) {
		return value.compareTo(another.value);
	}
}
