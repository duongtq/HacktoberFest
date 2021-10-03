import java.util.Stack;

public class ReversePolishNotation {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (!isOperation(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int result = doOperation(token, operand1, operand2);
                stack.push(result);
            }
        }
        return stack.peek();
    }

    public static boolean isOperation(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    public static int doOperation(String token, int operand1, int operand2) {
        if (token.equals("+")) {
            return operand1 + operand2;
        }
        if (token.equals("-")) {
            return operand1 - operand2;
        }
        if (token.equals("*")) {
            return operand1 * operand2;
        }
        return operand1 / operand2;
    }

    public static void main(String[] args) {
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};

        System.out.println("Result: " + evalRPN(tokens));
    }
}
