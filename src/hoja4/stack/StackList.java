package hoja4.stack;

import hoja4.list.List;

public class StackList<T> extends AbstractStack<T> {

    private List<T> list;

    public StackList(List<T> listImplementation) {
        this.list = listImplementation;
    }

    @Override
    public void push(T item) {
        list.addFirst(item);
        size++;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack vacío");
        }
        size--;
        return list.removeFirst();
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack vacío");
        }
        return list.getFirst();
    }
}
