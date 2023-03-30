class ListNode {

    private Object data;
    private ListNode next;

    public ListNode(Object o) { data = o; next = null; }
    public ListNode(Object o, ListNode nextNode)
    { data = o; next = nextNode; }

    public Object getData() { return data; }
    public void setData(Object o) { data = o; }

    public ListNode getNext() { return next; }
    public void setNext(ListNode next) { this.next = next; }


} // class ListNode