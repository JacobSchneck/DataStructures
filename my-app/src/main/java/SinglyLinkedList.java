
public class SinglyLinkedList<T extends Comparable<T>> {
    /************** Instance Variables **************/
    private Node<T> head;

    /************** Constructors ********************/
    public SinglyLinkedList(Node<T> newHead) {
        this.head = newHead;
    }

    /************** LIFO Methods *******************/
    public void push(Node<T> node) {
        Node<T> curr = head; // soft coppies head
        node.next = curr;
        head = node;
    }

    public Node<T> pop() {
        if (head == null ) {
            return null;
        }

        if (head.next == null) {
            Node<T> temp = head;
            head = null;
            return temp;
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

    /************** Insert, Remove and Append ******/
    public boolean insert(Node<T> node, int pos) {
        if (pos == 0) {
            push(node);
            return true;
        }
        boolean inserted = false; 
        Node<T> curr = head;
        int count = 0;
        while (curr != null && inserted == false) {
            if (count == pos - 1) { // looking for node that links to the position (not position itself)
                Node<T> temp = curr.next;
                node.next = temp;
                curr.next = node;
                inserted = true;
            }
            curr = curr.next;
            count += 1;            
        }

        return inserted;
    }

    public boolean remove(T val) {
        if (head == null) {
            return false;
        }

        boolean removed = false;
        Node<T> curr = head;        
        Node<T> prev = null;

        if (curr.val.compareTo(val) == 0) { // first node
            head = head.next;
            return true;
        }

        while (curr != null && removed == false) {
            if (curr.val.compareTo(val) == 0) {
                prev.next = curr.next;
                curr = prev.next;
                removed = true;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }

        return removed;
    }

    public void append(Node<T> node) {
        Node<T> curr = head;
        while (curr.next != null){
            curr = curr.next;
        }
        curr.next = node;
    }

    /************** To String Method ***************/
    @Override
    public String toString() {
        String result = "";
        Node<T> curr = this.head;
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

    /************** Main Method ********************/
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
        System.out.println(list);

        list.pop();
        System.out.println(list);

        System.out.println(list.insert(new Node<Integer>(5), 2));
        System.out.println(list);
        System.out.println(list.insert(new Node<Integer>(5), 5));
        System.out.println(list);
        System.out.println(list.insert(new Node<Integer>(9), 0));
        System.out.println(list);

        System.out.println(list.remove(2));
        System.out.println(list);
        System.out.println(list.remove(4));
        System.out.println(list);
        System.out.println(list.remove(7));
        System.out.println(list);
        System.out.println(list.remove(9));
        System.out.println(list);

        list.append(new Node<Integer>(6));
        System.out.println(list);
        list.append(new Node<Integer>(7));
        System.out.println(list);

        SinglyLinkedList<String> stringList = new SinglyLinkedList<String>(new Node<String>("Hello"));
        stringList.append(new Node<String>("World"));
        System.out.println(stringList);
        stringList.remove("Hello");
        stringList.push(new Node<String>("Goodbye"));
        stringList.insert(new Node<String>("Cruel"), 1); 
        System.out.println(stringList);
    }
}