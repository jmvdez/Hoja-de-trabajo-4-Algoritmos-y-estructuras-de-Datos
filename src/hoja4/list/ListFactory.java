package hoja4.Lista;

public class ListFactory {

    public static <T> List<T> getList(String listType) {

        if (listType == null) {
            throw new IllegalArgumentException("Debe especificar el tipo de lista.");
        }

        switch (listType.toLowerCase()) {
            case "singly":
                return new SinglyLinkedList<>();
            case "doubly":
                return new DoublyLinkedList<>();
            default:
                throw new IllegalArgumentException("Tipo de lista inválido.");
        }
    }
}
