package Task_02_2;

// Класс узла связного списка
public class LinkedListNode {
	public Object value;		// Объект
	public LinkedListNode next;	// Ссылка на объект этого же класса

	public LinkedListNode(Object value, LinkedListNode next) {
		this.value = value;
		this.next = next;
	}

	// Метод вывода связного списка на экран
	public void printNode() {
		System.out.print(value + " ");			// Вывод значения
		if (next != null) next.printNode();	// Если ссылка не равна null, то выводится следующий элемент списка
		else System.out.printf("end\n");		// В конце выводится End.
	}
}
