
public class LinkedList<T> {
	private Node<T> head, current;

	public void insert(T n) {
		Node<T> tmp = new Node<T>(n);
		if (head == null)
			head = current = tmp;
		else {
			tmp.next = current.next;
			tmp.prev = current;
			if (current.next!= null)
				current.next.prev = tmp;
			current.next = tmp;
			current = tmp;
		}
	}

	public void insertFirst(T n) {
		current = new Node<T>(n);
		current.next = head;
		head.prev = current;
		head = current;
	}

	public void remove() {
		if (current == head) {
			head = head.next;
			if (head != null)
				head.prev = null;
		} else {
			current.prev.next = current.next;
			if (current.next != null)
				current.next.prev = current.prev;
		}

		if (current.next == null)
			current = head;
		else
			current = current.next;

	}

	public void search(T d) {

	}

	public void findFirst() {
		current = head;
	}

	public void findNext() {
		current = current.next;
	}

	public void findPrev() {
		current = current.prev;
	}

	public void findLast() {
		current = head;
		while (current.next != null)
			current = current.next;
	}

	public boolean empty() {
		return head == null;
	}

	public boolean first() {
		return current.prev == null;
	}

	public boolean last() {
		return current.next == null;
	}

	public T retrieve() {
		return current.data;
	}

}
