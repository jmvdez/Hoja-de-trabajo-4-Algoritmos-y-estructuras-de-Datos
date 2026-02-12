package hoja4.stack;

import java.util.ArrayList;

public class StackArrayList<T> extends AbstractStack<T> {

    private ArrayList<T> list;

    public StackArrayList() {
        list = new ArrayList<>();
    }

    @Override
    public void push(T item) {
        list.add(item);
        size++;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack vacío");
        }
        size--;
        return list.remove(size);
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack vacío");
        }
        return list.get(size - 1);
    }
}
