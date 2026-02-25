package hoja4.model;

public class Node<T> {

    private T data;
    private Node<T> next;
    private Node<T> prev;

    public Node(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public T getData() {
        return data;
    }

    public Node<T> getNextNode() {
        return next;
    }

    public Node<T> getPreviousNode() {
        return prev;
    }

    public void setNextNode(Node<T> next) {
        this.next = next;
    }

    public void setPreviousNode(Node<T> prev) {
        this.prev = prev;
    }
}
