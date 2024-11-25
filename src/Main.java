import datastructures.linkedlist.LLLeetcodeProblems;
import datastructures.linkedlist.LinkedList;

public class Main {
    public static void main(String[] args){
        LLLeetcodeProblems ll = new LLLeetcodeProblems(1);
        ll.append(2);
        ll.append(3);
        ll.append(4);
        ll.append(5);
        ll.append(6);
        ll.printList();
        LinkedList.Node n =  ll.findMiddleNode();
        System.out.println("The value of the middle node is: " + n.value);
    }
}