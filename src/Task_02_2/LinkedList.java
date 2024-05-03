package Task_02_2;

// Класс связного списка
public class LinkedList {
	public LinkedListNode head = null;

	// Метод вставляет элемент в начало списка
	public void add(Object value) {
		head = new LinkedListNode(value, head);
	}

	// Метод вставляет элемент value в позицию index
	public void insert(int index, Object value) {
		if (head == null) {									// Вставка в конце списка
			head = new LinkedListNode(value, null);
		} else if (index == 0) {							// Вставка в начало списка
			add(value);
		} else {
			var current = head;
			while (current.next != null && index > 1) {
				current = current.next;
				index = index - 1;
			}

			current.next = new LinkedListNode(value, current.next);
		}
	}

	// Метод для проверки, содержится ли элемент в списке
	public boolean contains(Object value) {
		var current = head;
		while (current != null) {
			if (current.value.equals(value)) {
				return true;
			}
			current = current.next;
		}

		return false;
	}

	// Метод вычисления длины списка
	public int length() {
		var result = 0;
		var current = this.head;

		while (current != null) {
			result = result + 1;
			current = current.next;
		}

		return result;
	}

	// Метод удаления первого элемента
	public Object remove() {
		if (head == null) {
			return null;
		}

		var value = head.value;
		head = head.next;

		return value;
	}

	// Метод удаления элемента под индексом index
	public Object removeAt(int index) {
		if (head == null) {								// Если список пустой
			return null;
		} else if (index == 0 || head.next == null) {	// Удаление первого элемента
			return remove();
		} else {
			var current = this.head;
			while (current.next.next != null && index > 1) {
				current = current.next;
				index = index - 1;
			}

			var value = current.next.value;
			current.next = current.next.next;

			return value;
		}
	}
}
