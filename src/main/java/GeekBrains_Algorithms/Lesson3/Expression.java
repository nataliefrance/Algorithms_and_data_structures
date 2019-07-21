package GeekBrains_Algorithms.Lesson3;

public class Expression {
    private String exp;

    public Expression(String exp) {
        this.exp = exp;
    }

    public boolean checkBrackets() {
        MyStack<Character> stack = new MyStack<Character>(exp.length());
        char currentChar;
        for (int i = 0; i < exp.length(); i++) {
            currentChar = exp.charAt(i);
            if (currentChar == '{' || currentChar == '[' || currentChar == '(') {
                stack.push(currentChar);
            } else if (currentChar == '}' || currentChar == ']' || currentChar == ')') {
                if (stack.isEmpty()) {
                    System.out.println("error in position " + i + ": no opening bracket.");
                    return false;
                }
                char top = stack.pop();
                if (currentChar == '}' && top != '{' ||
                        currentChar == ')' && top != '(' ||
                        currentChar == ']' && top != '[') {
                    System.out.println("Error in " + i + " position: bracket doesn't match");
                    return false;
                }
            }
        }
        if (!stack.isEmpty()) {
            System.out.println("Error: bracket doesn't match");
            return false;
        }
        return true;
    }
}
