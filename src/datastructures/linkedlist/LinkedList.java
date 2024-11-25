
package datastructures.linkedlist;

/*
 * append -> O(1)
 * removeLast -> O(n)
 * prepend -> O(1)
 * removeFirst -> O(1)
 * insert -> O(n)
 * remove -> O(n)
 * find by value/index -> O(n)
 *
 * */


public class LinkedList {

    public class Node {
        public int value;
        public Node next;


        public Node(int val) {
            this.value = val;
        }
    }

    protected Node head;
    protected Node tail;
    protected int length;

    public LinkedList(int value) {
        Node node = new Node(value);
        head = node;
        tail = node;
        length = 1;
    }

    public Node getHead() {
        System.out.println("HEAD: " + head.value);
        return head;
    }

    public Node getTail() {
        System.out.println("TAIL: " + tail.value);
        return tail;
    }

    public void getLength() {
        System.out.println("LENGTH: " + length);
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void append(int value) {
        Node node = new Node(value);
        if (length == 0) {
            head = node;
        } else {
            tail.next = node;
        }
        tail = node;
        length++;
    }

    public Node removeLast() {
        if (length == 0) {
            return null;
        }
        Node temp = head;
        Node pre = head;
        if (length == 1) {
            head = null;
            tail = null;
            length--;
            return temp;
        }
        while (temp.next != null) {
            pre = temp;
            temp = temp.next;
        }
        tail = pre;
        tail.next = null;
        length--;
        return temp;
    }

    public void prepend(int value) {
        Node node = new Node(value);
        if (length == 0) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head = node;
        }
        length++;
    }

    public Node removeFirst() {
        if (length == 0) return null;
        Node temp = head;
        head = head.next;
        temp.next = null;
        length--;
        if (length == 0) {
            tail = null;
        }
        return temp;
    }

    public Node get(int index) {
        if (index >= length || index < 0) return null;
        int temp = 0;
        Node current = head;
        while (temp < index) {
            current = current.next;
            temp++;
        }
        return current;
    }

    public boolean set(int index, int value) {
        Node target = get(index);
        if (target == null) return false;
        target.value = value;
        return true;
    }

    public boolean insert(int index, int value) {
        if (index < 0 || index > length) return false;
        if (index == 0) {
            prepend(value);
            return true;
        }
        if (index == length) {
            append(value);
            return true;
        }
        Node node = new Node(value);
        Node temp = get(index - 1);
        node.next = temp.next;
        temp.next = node;
        length++;
        return true;
    }

    public Node remove(int index) {
        if(index < 0 || index >= length) return null;
        if(index == 0) {
            return removeFirst();
        }
        if (index == length - 1) {
            return removeLast();
        }
        Node pre = get(index - 1);
        Node temp = get(index);
        pre.next = temp.next;
        temp.next = null;
        length--;
        return temp;
    }
}








