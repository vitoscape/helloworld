/*
Еще одна задача, которую я часто даю — реализация связного списка. Её можно давать в самом простом
виде (реализовать только add() и get()), а можно попросить реализовать java.util.List.
 */

package Task_02_2;

public class Main {
	public static void main(String args[]) {
		// Создание связного списка вручную
		var head = new LinkedListNode(1,
				new LinkedListNode(2,
						new LinkedListNode(3, null)));

		head.printNode();	// Вывод списка

		// Создание такого же связного списка через класс LinkedList
		LinkedList linkedList = new LinkedList();
		linkedList.add(3);
		linkedList.add(2);
		linkedList.add(1);

		linkedList.head.printNode();	// Вывод списка

		linkedList.insert(2, 90);	// Вставка элемента во второе место

		linkedList.head.printNode();	// Вывод списка

		System.out.println(linkedList.contains(2));	// Содержится ли в списке число 2

		System.out.printf("Linked list length: %d\n", linkedList.length());	// Вывод длины списка

		linkedList.remove();	// Удаление первого элемента

		linkedList.head.printNode();	// Вывод списка

		linkedList.removeAt(1);	// Удаление элемента с индексом 1 (2-й элемент)

		linkedList.head.printNode();	// Вывод списка
	}
}
