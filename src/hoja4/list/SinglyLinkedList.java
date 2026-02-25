package hoja4.list;

import hoja4.model.Node;

public class SinglyLinkedList<T> extends AbstractList<T> {

    private Node<T> head;

    @Override
    public void addFirst(T item) {
        Node<T> newNode = new Node<>(item);
        newNode.setNextNode(head);
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
