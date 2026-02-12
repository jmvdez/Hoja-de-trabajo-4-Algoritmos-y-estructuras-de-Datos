package hoja4.list;

import hoja4.model.Node;

public class DoublyLinkedList<T> extends AbstractList<T> {

    private Node<T> head;

    @Override
    public void addFirst(T item) {
        Node<T> newNode = new Node<>(item);

        if (head != null) {
            head.setPreviousNode(newNode);
            newNode.setNextNode(head);
        }

        head = newNode;
        size++;
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            throw new RuntimeException("Lista vacía");
        }

        T value = head.getData();
        head = head.getNextNode();

        if (head != null) {
            head.setPreviousNode(null);
        }

        size--;
        return value;
    }

    @Override
    public T getFirst() {
        if (isEmpty()) {
            throw new RuntimeException("Lista vacía");
        }
        return head.getData();
    }
}
