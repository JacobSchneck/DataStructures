package node;

public class Node<T> {
    public T val;
    public Node<T> next;

    // Constructors
    public Node(T val) {
        this.val = val;
        next = null;
    }
    public Node(T val, Node<T> next) {
        this.val = val;
        this.next = next;
    }

    public String toString() {
        return val.toString();
    }

    public static void main(String[] args) {
        Node<String> n = new Node<String>("HI");
        System.out.println(n.toString());

        Node<Integer> n1 = new Node<Integer>(1);
        System.out.println(n1.toString());
    }
}