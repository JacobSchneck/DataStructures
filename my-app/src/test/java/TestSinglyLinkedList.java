
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TestSinglyLinkedList {

    @Test
    public void TestPop() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>(new Node<Integer>(3));
        list.push(new Node<Integer>(4));
        list.push(new Node<Integer>(5));
        assertEquals(3, list.pop().val);
        assertEquals(4, list.pop().val);
        assertEquals(5, list.pop().val);
        assertEquals(null, list.pop());
    }

    @Test
    public void TestInsert() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>(new Node<Integer>(3));
        assertEquals(true, list.insert(new Node<Integer>(2), 0));
        assertEquals(false, list.insert(new Node<Integer>(4), 5));
        assertEquals(true, list.insert(new Node<Integer>(4), 2));
    }

    @Test
    public void TestRemove() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>(new Node<Integer>(3));
        list.push(new Node<Integer>(4));
        list.push(new Node<Integer>(5));
        assertEquals(true, list.remove(4));
        assertEquals(false, list.remove(4));
        assertEquals(true, list.remove(5));
        assertEquals(true, list.remove(3));
        assertEquals(false, list.remove(3));
    }
}

  