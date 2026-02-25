package hoja4.Stack;

import hoja4.list.List;
import hoja4.list.ListFactory;

public class StackFactory {

    public static <T> Stack<T> getStack(String stackType, String listType) {

        if (stackType == null) {
            throw new IllegalArgumentException("Debe especificar el tipo de stack.");
        }

        switch (stackType.toLowerCase()) {

            case "arraylist":
                return new StackArrayList<>();

            case "vector":
                return new StackVector<>();

            case "list":
                List<T> list = ListFactory.getList(listType);
                return new StackList<>(list);

            default:
                throw new IllegalArgumentException("Tipo de stack inválido.");
        }
    }
}
