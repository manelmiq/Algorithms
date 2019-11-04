package dataStructures;

public class DoublyLinkedList {

    Node head;
    Node tail;
    int size = 0;

    class Node {
        String val;
        Node next;
        Node previous;

        Node(String val) {
            this.val = val;
        }

        public Node(String val, Node next, Node previous) {
            this.val = val;
            this.next = next;
            this.previous = previous;
        }
    }

    public void addFirst(String element) {
        Node newNode = new Node(element, head, null);
        if (head != null) {
            head.previous = newNode;
        }
        head = newNode;
        if (tail == null) {
            tail = newNode;
        }
        size++;
        System.out.println("adding: " + element);
    }


    public void addLast(String element) {
        Node newNode = new Node(element, null, tail);
        if (tail != null) {
            tail.next = newNode;
        }
        tail = newNode;
        if (head == null) {
            head = newNode;
        }
        size++;
    }

    public void removeByValue(String element) {
        Node tmp = head;
        Node begin = null;
        while (tmp != null) {
            if (tmp.val.equals(element)) {
                if (begin != null) {
                    begin.next = tmp.next;
                }
                if (tmp.next != null) {
                    tmp.next.previous = begin;
                }
                head = begin;
                size--;
                break;
            }
            begin = new Node(tmp.val, null, begin);
            tmp = tmp.next;
        }
    }

    @Override
    public String toString() {
        Node tmp = head;
        StringBuilder str = new StringBuilder();
        int count = 0;
        while (tmp != null) {
            str.append((count > 0) ? ", " + tmp.val : tmp.val);
            count++;
            tmp = tmp.next;
        }
        return str.toString();
    }

    public DoublyLinkedList() {
        this.size = 0;
    }
}
