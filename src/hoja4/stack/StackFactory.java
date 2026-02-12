package hoja4.stack;

import hoja4.list.*;

public class StackFactory {

    public static <T> Stack<T> getStack(String stackType, String listType) {

        switch (stackType.toLowerCase()) {

            case "arraylist":
                return new StackArrayList<>();

            case "vector":
                return new StackVector<>();

            case "list":

                if (listType == null) {
                    throw new IllegalArgumentException("Debe especificar tipo de lista");
                }

                switch (listType.toLowerCase()) {
                    case "singly":
                        return new StackList<>(new SinglyLinkedList<>());
                    case "doubly":
                        return new StackList<>(new DoublyLinkedList<>());
                    default:
                        throw new IllegalArgumentException("Tipo de lista inválido");
                }

            default:
                throw new IllegalArgumentException("Tipo de stack inválido");
        }
    }
}
