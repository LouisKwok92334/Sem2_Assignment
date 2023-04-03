public class LinkedList {

	private ListNode head;
	private ListNode tail;
	private int length;        // the length of the list
	private Comparator comparator;

	public LinkedList(Comparator comparator) {
		head = tail = null;
		length = 0;
		this.comparator = comparator;
	}

	public boolean isEmpty() { return head == null; }

	public void addToHead(Object item) {
		if (isEmpty())
			head = tail = new ListNode(item);
		else
			head = new ListNode(item, head);
		length++;
	}

	public void addToTail(Object item) {
		if (isEmpty())
			head = tail = new ListNode(item);
		else {
			tail.setNext(new ListNode(item));
			tail = tail.getNext();
		}
		length++;
	}

	public Object removeFromHead() throws EmptyListException {
		Object item = null;
		if (isEmpty())
			throw new EmptyListException();
		item = head.getData();
		if (head == tail)
			head = tail = null;
		else
			head = head.getNext();
		length--;
		return item;
	}

	public Object removeFromTail() throws EmptyListException {
		Object item = null;
		if (isEmpty())
			throw new EmptyListException();
		item = tail.getData();
		if (head == tail)
			head = tail = null;
		else {
			ListNode current = head;
			while (current.getNext() != tail)
				current = current.getNext();
			tail = current;
			current.setNext(null);
		}
		length--;
		return item;
	}

	public int count() {
		return length;
	}

	//students need to revise toString method
	public String toString() {
		String str = "--------------------------------------\n";
		ListNode current = head;
		while (current != null) {
			str += current.getData() + "\n";
			current = current.getNext();
		}
		return str + "--------------------------------------";
	}

	//to be completed ...
	// Method remove(int) is to remove a ListNode from the LinkedList with a specific Member ID
	public void remove(int targetID) throws EmptyListException{
		if (isEmpty()) {
			throw new EmptyListException();
		}
		if (((FoodOrder)head.getData()).getMemberID() == targetID) {
			removeFromHead();
		} else if (((FoodOrder)tail.getData()).getMemberID() == targetID) {
			removeFromTail();
		} else {
			ListNode current = head;
			while (current.getNext() != null){
				if (((FoodOrder)current.getNext().getData()).getMemberID() == targetID) {
					current.setNext(current.getNext().getNext());
					length--;
					return;
				}
				current = current.getNext();
			}
			throw new EmptyListException();
		}
	}

	//to be completed ...
    // Method add(Object) is to insert a new ListNode into the LinkedList in a correct position
	public void add(Object item) throws InvalidInputException {
		if (isEmpty()){
			addToHead(item);
		} else {
			if (comparator.isLessThan(item, head.getData())){
				addToHead(item);
			} else if (comparator.isGreaterThanOrEqualTo(item, tail.getData())) {
				addToTail(item);
			} else {
				ListNode current = head;
				while (current.getNext() != null){
					if (comparator.isLessThan(item, current.getNext().getData())){
						ListNode newNode = new ListNode(item);
						newNode.setNext(current.getNext());
						current.setNext(newNode);
						length++;
						return;
					}
					current = current.getNext();
				}
				throw new InvalidInputException();
			}
		}
	}
} // class LinkedList
