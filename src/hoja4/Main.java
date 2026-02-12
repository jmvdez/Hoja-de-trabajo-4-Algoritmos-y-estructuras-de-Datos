package hoja4;

import hoja4.stack.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Seleccione implementación de Stack:");
        System.out.println("1. ArrayList");
        System.out.println("2. Vector");
        System.out.println("3. List");

        String stackType = null;
        String listType = null;

        int option = scanner.nextInt();
        scanner.nextLine(); // limpiar buffer

        switch (option) {
            case 1:
                stackType = "arraylist";
                break;
            case 2:
                stackType = "vector";
                break;
            case 3:
                stackType = "list";

                System.out.println("Seleccione tipo de lista:");
                System.out.println("1. Singly Linked List");
                System.out.println("2. Doubly Linked List");

                int listOption = scanner.nextInt();
                scanner.nextLine();

                if (listOption == 1) {
                    listType = "singly";
                } else if (listOption == 2) {
                    listType = "doubly";
                } else {
                    System.out.println("Opción inválida");
                    return;
                }
                break;

            default:
                System.out.println("Opción inválida");
                return;
        }

        // Crear stack usando Factory
        Stack<String> stack = StackFactory.getStack(stackType, listType);

        // Leer expresión desde archivo
        String expression = readExpressionFromFile("datos.txt");

        if (expression == null) {
            System.out.println("No se pudo leer la expresión.");
            return;
        }

        System.out.println("Expresión leída: " + expression);

        // Por ahora solo probamos que el stack funciona
        stack.push("Prueba");
        System.out.println("Elemento en tope del stack: " + stack.peek());
    }

    private static String readExpressionFromFile(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            return br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
