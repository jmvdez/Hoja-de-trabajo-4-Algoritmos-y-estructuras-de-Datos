package hoja4.stack;

import java.util.Vector;

public class StackVector<T> extends AbstractStack<T> {

    private Vector<T> vector;

    public StackVector() {
        vector = new Vector<>();
    }

    @Override
    public void push(T item) {
        vector.add(item);
        size++;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack vacío");
        }
        size--;
        return vector.remove(size);
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack vacío");
        }
        return vector.get(size - 1);
    }
}
