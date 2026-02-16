package hoja4.calculator;
import hoja4.stack.Stack;

public class InfixToPostfixConverter {

    private Stack<String> stack;

    public InfixToPostfixConverter(Stack<String> stack) {
        this.stack = stack;
    }

    public String convert(String expression) {

        StringBuilder output = new StringBuilder();
        // Los tokens son los posibles operadores, caracteres o parentesis
       String[] tokens = expression.replaceAll("(?<=\\d)(?=[^\\d\\s])", " ")
                             .replaceAll("(?<=[^\\d\\s])(?=\\d)", " ")
                             .replaceAll("(?<=[+\\-*/%()])(?=[+\\-*/%()])", " ")
                             .trim()
                             .split("\\s+");
        
        for (String token : tokens) {

            token = token.trim();

            if (token.isEmpty()) {
                continue;
            }
            // se usa append para agregar el numero al output
            if (isNumber(token)) {
                output.append(token).append(" ");
            }

            else if (isOperator(token)) {

                while (!stack.isEmpty() &&
                        // usamos la funcion precedence para comparar la prioridad de los operadores
                        isOperator(stack.peek()) &&
                        precedence(stack.peek()) >= precedence(token)) {

                    output.append(stack.pop()).append(" ");
                }

                stack.push(token);
            }
            
            else if (token.equals("(")) {
                stack.push(token);
            }

            else if (token.equals(")")) {

                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    output.append(stack.pop()).append(" ");
                }

                stack.pop(); // eliminar "("
            }
        }

        while (!stack.isEmpty()) {
            output.append(stack.pop()).append(" ");
        }

        return output.toString().trim();
    }

    private boolean isNumber(String token) {
        return token.matches("\\d+");
    }

    private boolean isOperator(String token) {
        return token.equals("+") ||
               token.equals("-") ||
               token.equals("*") ||
               token.equals("/");
    }

    private int precedence(String operator) {
        switch (operator) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            default:
                return 0;
        }
    }
}
