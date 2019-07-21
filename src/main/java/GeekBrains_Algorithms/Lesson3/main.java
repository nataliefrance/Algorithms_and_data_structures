package GeekBrains_Algorithms.Lesson3;

public class main {
    public static void main(String[] args) {
//        MyStack<Integer> myStack = new MyStack<Integer>();
//        for (int i = 0; i < 5; i++) {
//            myStack.push(i);
//        }
//        for (int i = 0; i < 5; i++) {
//            System.out.println(myStack.pop());
//        }
        Expression exp = new Expression("(1+2)-[3+(x*4}]");
        System.out.println(exp.checkBrackets());

    }
}
