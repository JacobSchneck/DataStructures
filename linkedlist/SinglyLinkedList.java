package linkedlist;

import node.Node; 

public class SinglyLinkedList<T> {
    private Node<T> head;

    public SinglyLinkedList(Node<T> newHead) {
        this.head = newHead;
    }

    public void push(Node<T> node) {
        Node<T> curr = head;
        node.next = curr;
        head = node;
    }

    public Node<T> pop() {
        if (head == null || head.next == null) {
            return null;
        }
        
        Node<T> curr = head;
        while (curr.next.next != null) {
            // System.out.println(curr.toString());
            curr = curr.next;
        }
        Node<T> temp = curr.next;
        curr.next = null;
        return temp;
    }

    public String toString() {
        String result = "";
        var curr = this.head;
        while (curr != null) {
            if (curr.next == null) {
                result += curr.val.toString();
            } else {
                result += curr.val.toString() + " -> ";
            }

            curr = curr.next;
        }

        return result;
    }

    public static void main(String[] args) {
        Node<Integer> n0 = new Node<Integer>(3);
        Node<Integer> n1 = new Node<Integer>(4);
        Node<Integer> n2 = new Node<Integer>(5);
        n0.next = n1;
        n1.next = n2;
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>(n0);
        // list.head = n0;
        Node<Integer> newNode = new Node<Integer>(2);
        list.push(newNode);
        System.out.println(list.toString());
        list.pop();
        System.out.println(list);
    }
}