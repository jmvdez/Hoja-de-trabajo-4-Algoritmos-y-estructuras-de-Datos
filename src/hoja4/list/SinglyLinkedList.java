package hoja4.list;

public class SinglyLinkedList<T> extends AbstractList<T> {

    private Node<T> head;

    @Override
    public void addFirst(T item) {
        Node<T> newNode = new Node<>(item);
        newNode.next = head;
        head = newNode;
        size++;
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            throw new RuntimeException("Lista vacía");
        }

        T value = head.data;
        head = head.next;
        size--;
        return value;
    }

    @Override
    public T getFirst() {
        if (isEmpty()) {
            throw new RuntimeException("Lista vacía");
        }
        return head.data;
    }
}
