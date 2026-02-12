package hoja4.model;

public class Node<T> {

    T data;
    Node<T> next;
    Node<T> prev;

    public Node(T data) {
        this.data = data;
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

    public T getData() {
        return data;
    }

}
