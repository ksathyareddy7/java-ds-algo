package datastructures.binarysearchtree;

public class BinarySearchTree {
    public Node root;

    public class Node{
        public int value;
        public Node left;
        public Node right;
        Node(int value) {
            this.value = value;
        }
    }

    public boolean insert(int value) {
        Node newNode = new Node(value);
        if(root == null) {
            root = newNode;
            return true;
        }
        Node temp = root;
        while (true) {
            if(temp.value == newNode.value) return false;
            if(newNode.value > temp.value) {
                if(temp.right == null) {
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            }else {
                if(temp.left == null) {
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left;
            }
        }
    }
    public boolean contains(int value) {
        Node temp = root;
        while (temp != null) {
            if(temp.value > value) {
                temp = temp.left;
            } else if (temp.value < value) {
                temp = temp.right;
            }else {
                return true;
            }
        }
        return false;
    }
    private boolean rContains(Node currentNode, int value) {
        if(currentNode == null) return false;
        if (currentNode.value == value) return true;
        return true;
    }
}
