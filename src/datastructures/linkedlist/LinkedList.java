
package datastructures.linkedlist;


public class LinkedList {
    public class Node {
        public int value;
        Node next;
        public Node(int n) {
            value = n;
        }
    }
    Node head;
    Node tail;
    int length;
    public LinkedList(int n) {
        Node newNode = new Node(n);
        head = newNode;
        tail = newNode;
        length = 1;
    }


    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void getHead() {
        if (head == null) {
            System.out.println("Head: null");
        } else {
            System.out.println("Head: " + head.value);
        }
    }

    public void getTail() {
        if (head == null) {
            System.out.println("Tail: null");
        } else {
            System.out.println("Tail: " + tail.value);
        }
    }

    public void getLength() {
        System.out.println("Length: " + length);
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if(length == 0) {
            head = newNode;
        }else {
            tail.next = newNode;
        }
        tail = newNode;
        length++;
    }
    public boolean removeLast() {
        if(length == 0) return false;
        if(length == 1) {
            head = null;
            tail = null;
            length--;
        }else {
            Node temp = head;
            while(temp.next != null) {
                if(temp.next == tail) {
                    temp.next = null;
                    tail = temp;
                    length--;
                }else {
                    temp = temp.next;
                }
            }
        }
       if(length == 0 ) {
           System.out.println("head " + head);
           System.out.println("tail " +tail);
           System.out.println("length "+ length);
       }else {
           System.out.println("head " + head.value);
           System.out.println("tail " +tail.value);
           System.out.println("length "+ length);
       }
       return true;
    }
    public Node tutorRemoveLast() {
        if(length == 0) return null;
        Node temp = head;
        Node pre = head;
        while(temp.next != null) {
            pre = temp;
            temp = temp.next;
        }
        tail = pre;
        tail.next = null;
        length--;
        if(length == 0) {
            head = null;
            tail = null;
        }
        System.out.println("length : " + length);
        System.out.println("temp value: " +temp.value);
        return temp;
    }
    public void prepend(int value) {
        Node newNode = new Node(value);
        if(length == 0) {
            tail = newNode;
        }
        newNode.next = head;
        head = newNode;
        length++;
    }

    public boolean removeFirst() {
        if(length == 0) return false;
        if(length == 1) {
            head = null;
            tail = null;
        }else {
            head = head.next;
        }
        length--;
        return true;
    }

    public Node get(int index) {
        if(length < 0 || index >= length) {
            return null;
        }
        if(index == 0) {
            return head;
        }
        if(index == length - 1) {
            return tail;
        }
        int temp = 0;
        Node target = null;
        while (temp < index) {
            target = head.next;
            temp++;
        }
        return target;
    }

    public boolean set(int index, int value) {
        Node temp = get(index);
        if(temp != null) {
            temp.value = value;
            return true;
        }
        return false;
    }

    public boolean insert(int index, int value){
        if(index < 0 || index > length) {
            return false;
        }
        if(index == 0) {
            prepend(value);
            return true;
        }
        if(index == length) {
            append(value);
            return true;
        }
        Node newNode = new Node(value);
        Node temp = get(index - 1);
        newNode.next = temp.next;
        temp.next = newNode;
        length++;
        return true;
    }

    public Boolean remove(int index) {
        if(index < 0 || index >= length) {
            return null;
        }
        if(index == 0) return removeFirst();
        if(index == length - 1) return removeLast();
        Node prev = get(index - 1);
        Node temp = prev.next;
        prev.next = temp.next;
        temp.next = null;
        length--;
        return true;
    }

    public void reverse(){
        Node temp = head;
        head = tail;
        tail = temp;
        Node before = null;
        Node after = temp.next;
        for (int i = 0; i < length; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }

}


