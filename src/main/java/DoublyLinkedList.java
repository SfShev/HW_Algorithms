public class DoublyLinkedList {
    Node head;
    Node tail;

    public void add(int value) {
        Node node = new Node();
        node.value = value;
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.previos = tail;
            tail = node;
        }
    }

    public void add(int value, Node node) {
        Node next = node.next;
        Node newNode = new Node();
        newNode.value = value;
        node.next = newNode;
        if (next == null) {
            tail = newNode;
        } else {
            next.previos = newNode;
            newNode.next = next;
        }
    }

    public void delete(Node node) {
        Node previous = node.previos;
        Node next = node.next;
        if (previous == null) {
            next.previos = null;
            head = next;
        } else {
            if (next == null) {
                previous.next = null;
                tail = previous;
            } else {
                previous.next = next;
                next.previos = previous;
            }
        }
    }

    public void revert() {
        Node currentNode = head;
        while (currentNode != null) {
            Node next = currentNode.next;
            Node previous = currentNode.previos;
            currentNode.next = previous;
            currentNode.previos = next;
            if (previous == null) {
                tail = currentNode;
            }
            if (next == null) {
                head = currentNode;
            }
            currentNode = next;
        }
    }

    public Node find(int value) {
        Node currentNode = head;
        while (currentNode != null) {
            if (currentNode.value == value) {
                return currentNode;
            }
            currentNode = currentNode.next;
        }
        return null;
    }

    public class Node {
        int value;
        Node next;

        Node previos;
    }
}
