
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

import java.util.ArrayList;
import java.util.HashSet;

public class LinkedList {

    public class Node {
        public int value;
        public Node next;


        public Node(int val) {
            this.value = val;
        }
    }

    private Node head;
    private Node tail;
    private int length;

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

    public void reverse() {
        Node temp = head;
        head = tail;
        tail = temp;
        Node after = temp.next;
        Node before = null;
        for (int i = 0; i < length; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }

    /*
    * In this problem, you should use the slow and fast pointer technique
    * (also known as Floyd's Tortoise and Hare algorithm) to find the middle element
    * of the linked list efficiently.
    * */

    public Node findMiddleNode() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /*
    * Implement a method called hasLoop that checks whether the list contains a loop or not.
    * If the list contains a loop, the method should return true; otherwise, it should return false.
    * THE FAST WILL CATCH UP WITH SLOW NODE IF THERE IS A LOOP AS IT WILL GET INSIDE THE LOOP AS SOON AS IT
    * REACHES THE NODE THAT HAS A POINTER TO A PREVIOUS NODE.
    * */
    public boolean hasLoop() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }

        return false;
    }

    /*
    * Implement a method called findKthFromEnd that returns the k-th node from the end of the list.
    * */
    public Node findKthFromEnd(int k) {
        Node slow = head;
        Node fast = head;
        for(int i = 0; i < k; i++) {
            if(fast == null) return null;
            fast = fast.next;
        }
        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public void reverseBetween(int m, int n) {
        if(head == null) return;
        Node dummy = new Node(0);
        dummy.next = head;
        Node prev = dummy;
        for(int i = 0; i < m; i++) {
            prev = prev.next;
        }
        Node current = prev.next;
        for(int j = 0; j < n - m; j++) {
            Node temp = current.next;
            current.next = temp.next;
            temp.next = prev.next;
            prev.next = temp;
        }
        head = dummy.next;
    }

    /*
    * Your task is to write a method named "partitionList" that takes an integer "x" as input and rearranges
    * the linked list in such a way that all nodes with values less than "x" come before nodes with values
    * greater than or equal to "x".
    *
    * The method should maintain the relative order of the nodes with values less than "x" and the nodes
    * with values greater than or equal to "x".
    * */

    public void partitionList(int x) {
        if(head == null) return;
        Node dummy1 = new Node(0);
        Node dummy2 = new Node(0);
        Node prev1 = dummy1;
        Node prev2 = dummy2;
        Node current = head;
        while(current != null) {
            if(current.value < x) {
                prev1.next = current;
                prev1 = current;
            } else {
                prev2.next = current;
                prev2 = current;
            }
            current = current.next;
        }
        prev2.next = null;
        prev1.next = dummy2.next;
        head = dummy1.next;
    }

    public void partition(int x) {
        Node temp = head;
        LinkedList left = new LinkedList(0);
        LinkedList right = new LinkedList(0);
        while (temp != null) {
            if(temp.value < x) {
                left.append(temp.value);
            }else {
                right.append(temp.value);
            }
            temp = temp.next;
        }
        head = left.head.next;
        right.head = right.head.next;
        left.tail.next = right.head;
        tail = right.tail;
    }

    public void removeDuplicates() {
        HashSet unique = new HashSet<Number>();
        Node prev = null;
        Node current = head;
        while (current != null) {
            if(unique.contains(current.value)) {
                prev.next = current.next;
                current = current.next;
                length--;
            }else {
                unique.add(current.value);
                prev = current;
                current = current.next;
            }
        }
    }


}








