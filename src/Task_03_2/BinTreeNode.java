package Task_03_2;

public class BinTreeNode<T> {
	private T value;
	private BinTreeNode<T> leftChild;
	private BinTreeNode<T> rightChild;

	BinTreeNode(T value) {
		this.value = value;
	}

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
}
