package hoja4.calculator;
import hoja4.stack.Stack;

public class PostfixEvaluator {

    private Stack<Double> stack;
    
    public PostfixEvaluator() {
    }

    public PostfixEvaluator(Stack<Double> stack) {
        this.stack = stack;
    }

    public double evaluate(String postfixExpression) {
        // Cada caracter se define como un token, se separan por espacios
        String[] tokens = postfixExpression.split("\\s+");

        for (String token : tokens) {
            // Si es un numero se convierte a double y se agrega a la pila
            if (isNumber(token)) {
                stack.push(Double.parseDouble(token));
            }

            else if (isOperator(token)) {
                // Si es un operador, se empuja la pila para meter el operador
                double operand2 = stack.pop();
                double operand1 = stack.pop();
                // Se aplican los operadores y se pushea el resultado
                double result = applyOperator(operand1, operand2, token);

                stack.push(result);
            }
        }

        return stack.pop();
    }

    private boolean isNumber(String token) {
        // Se verifica si el token es un numero
        return token.matches("\\d+");
    }

    private boolean isOperator(String token) {
        return token.equals("+") ||
               token.equals("-") ||
               token.equals("*") ||
               token.equals("/");
    }

    private double applyOperator(double op1, double op2, String operator) {

        switch (operator) {
            case "+": return op1 + op2;
            case "-": return op1 - op2;
            case "*": return op1 * op2;
            case "/": return op1 / op2;
            default: throw new IllegalArgumentException("Operador inválido");
        }
    }
}