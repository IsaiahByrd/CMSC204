public class Notation {
   
    public static double evaluatePostfixExpression(String postfixExpr) throws InvalidNotationFormatException {
        MyStack<String> stack = new MyStack<>(postfixExpr.length()); 
    
        for(int i = 0; i < postfixExpr.length(); i++) {
            Character currentChar = postfixExpr.charAt(i);
            try {
                checkCharacterEvaluation(currentChar, stack);
            } catch(InvalidNotationFormatException e) {
                throw new InvalidNotationFormatException();
            }
        }
        
        double result = Double.parseDouble(stack.pop());
        if (stack.size() == 0) {
            return result;
        } else {
            throw new InvalidNotationFormatException();
        }
    }

    public static String convertInfixToPostfix(String infix) throws InvalidNotationFormatException {
        StringBuilder postfixExpression = new StringBuilder();
        MyStack<String> operatorStack = new MyStack<>(infix.length()); 
        MyQueue<String> outputQueue = new MyQueue<>(infix.length());

        for(int i = 0; i < infix.length(); i++) {
            Character currentChar = infix.charAt(i);
            checkCharacter(currentChar, operatorStack, outputQueue);
        }

        while (!operatorStack.isEmpty()) {
            outputQueue.enqueue(operatorStack.pop());
        }

        while (!outputQueue.isEmpty()) {
            postfixExpression.append(outputQueue.dequeue());
        }

        return postfixExpression.toString(); 
    }

    private static void checkCharacter(Character currentChar, MyStack<String> operatorStack, MyQueue<String> outputQueue) {
        if (Character.isDigit(currentChar)) {
            outputQueue.enqueue(String.valueOf(currentChar));
        } else {
            switch (currentChar) {
                case '(':
                    operatorStack.push("(");
                    break;
                case '+':
                case '-':
                case '*':
                case '/':
                    isOperator(operatorStack, currentChar, outputQueue);
                    break;
                case ' ':
                    return;
                case ')': {
                    while (!operatorStack.isEmpty() && !operatorStack.top().equals("(")) {
                        outputQueue.enqueue(operatorStack.pop());
                    }
                    if (operatorStack.isEmpty()) {
                        throw new InvalidNotationFormatException();
                    }
                    operatorStack.pop();
                }
            }
        }
    }

    private static void isOperator(MyStack<String> operatorStack, char currentChar, MyQueue<String> outputQueue) {
        int precedenceCurrentChar = getPrecedence(currentChar);

        while (!operatorStack.isEmpty()) {
            char topOperator = operatorStack.top().charAt(0);
            int precedenceTop = getPrecedence(topOperator);

            if (precedenceTop >= precedenceCurrentChar) {
                outputQueue.enqueue(operatorStack.pop());
            } else {
                break;
            }
        }

        operatorStack.push(String.valueOf(currentChar));
    }

    private static int getPrecedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
        }
        return 0;
    }

    private static void checkCharacterEvaluation(Character currentChar, MyStack<String> stack) {
        if (Character.isDigit(currentChar)) {
            stack.push(String.valueOf(currentChar));
        } else {
            switch (currentChar) {
                case '(':
                    stack.push("(");
                    break;
                case '+':
                case '-':
                case '*':
                case '/':
                    isOperatorInfixToPostfix(stack, currentChar);
                    break;
                case ' ':
                    return;
            }
        }
    }

    private static void isOperatorInfixToPostfix(MyStack<String> stack, char currentChar) {
    	
        if (stack.size() < 2) {
            throw new InvalidNotationFormatException();
        }
        double rightOperand = Double.parseDouble(stack.pop());
        
        double leftOperand = Double.parseDouble(stack.pop());
        
        double result;

        switch (currentChar) {
            case '+': 
                result = leftOperand + rightOperand;
                stack.push(Double.toString(result));
                break;
            case '-':
                result = leftOperand - rightOperand;
                stack.push(Double.toString(result));
                break;
            case '*':
                result = leftOperand * rightOperand;
                stack.push(Double.toString(result));
                break;
            case '/':
                result = leftOperand / rightOperand;
                stack.push(Double.toString(result));
                break;
        }
    }

    public static String convertPostfixToInfix(String postfix) throws InvalidNotationFormatException {
    	
        StringBuilder infixString = new StringBuilder(postfix.length());
        
        MyStack<String> stack = new MyStack<>();

        for (int i = 0; i < postfix.length(); i++) {
            Character currentChar = postfix.charAt(i);
            
            checkCharacterPostfixToInfix(currentChar, stack);
        }

        
        if (stack.size() > 1) {
            throw new InvalidNotationFormatException();
        }

        
        infixString.append(stack.pop());
        
        return infixString.toString();
    }

    private static void checkCharacterPostfixToInfix(Character currentChar, MyStack<String> stack) {
    	
        if (Character.isDigit(currentChar)) {
            stack.push(String.valueOf(currentChar));
        } else {
            switch (currentChar) {
                case '+':
                case '-':
                case '*':
                case '/':
                    isOperatorPostfixToInfix(stack, currentChar);
                    break;
                case ' ':
                    return;
            }
        }
    }
    
    

    private static void isOperatorPostfixToInfix(MyStack<String> stack, Character currentChar) throws InvalidNotationFormatException {
    	
        StringBuilder infixString = new StringBuilder("(");

        if (stack.size() < 2) {
            throw new InvalidNotationFormatException();
        }

        String rightOperand = stack.pop();
        
        String leftOperand = stack.pop();

        infixString.append(leftOperand);
        
        infixString.append(currentChar);
        
        infixString.append(rightOperand);
        infixString.append(")");

        stack.push(infixString.toString());
    }
}
