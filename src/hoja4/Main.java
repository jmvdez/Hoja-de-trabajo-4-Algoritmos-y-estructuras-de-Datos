package hoja4;

import hoja4.calculator.InfixToPostfixConverter;
import hoja4.calculator.PostfixEvaluator;
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
                    listType = "Encadenado simple";
                } else if (listOption == 2) {
                    listType = "Encadenado doble";
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
        String expression = readExpressionFromFile("datos.txt", stackType, listType);

        if (expression == null) {
            System.out.println("No se pudo leer la expresión.");
            return;
        }

        System.out.println("Expresión leída: " + expression);

        // ===============================
        // CONVERSIÓN INFIX → POSTFIX
        // ===============================

        Stack<String> conversionStack =
                StackFactory.getStack(stackType, listType);

        InfixToPostfixConverter converter =
                new InfixToPostfixConverter(conversionStack);

        String postfix = converter.convert(expression);

        System.out.println("Postfix: " + postfix);

        // ===============================
        // 2️⃣ EVALUACIÓN POSTFIX
        // ===============================

        Stack<Double> evaluationStack =
                StackFactory.getStack(stackType, listType);

        PostfixEvaluator evaluator =
                new PostfixEvaluator(evaluationStack);

        double result = evaluator.evaluate(postfix);

        System.out.println("Resultado final: " + result);
    }

    private static String readExpressionFromFile(String fileName, String stackType, String listType) {
        try (BufferedReader br = new BufferedReader(new FileReader("datos.txt"))) {
            String line;

            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;

                return line;
            }

        } catch (IOException e) {
            System.out.println("No se pudo leer el archivo datos.txt");
            System.out.println("Directorio actual: " + System.getProperty("user.dir"));
            e.printStackTrace();
        }
        
        return null;
    }
}
