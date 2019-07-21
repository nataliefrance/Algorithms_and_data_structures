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
//        Expression exp = new Expression("(1+2)-[3+(x*4}]");
//        System.out.println(exp.checkBrackets());

//        MyQueue<Integer> myQueue = new MyQueue<Integer>(10);
//        for (int i = 0; i < 5; i++) {
//            myQueue.insert(i);
//        }
//        System.out.println(myQueue);
//        myQueue.remove();
//        myQueue.remove();
//        System.out.println(myQueue);
//        myQueue.insert(5);
//        myQueue.insert(6);
//        System.out.println(myQueue);

        MyDeque<Integer> myDeque = new MyDeque<>(10);
        for (int i = 1; i < 6; i++) {
            myDeque.insertRight(i);
        }
        System.out.println(myDeque);
        myDeque.insertLeft(6);
        myDeque.insertLeft(7);
        System.out.println(myDeque);
        myDeque.removeLeft();
        myDeque.removeLeft();
        myDeque.removeLeft();
        System.out.println(myDeque);
        myDeque.removeRight();
        myDeque.removeRight();
        myDeque.removeRight();
        System.out.println(myDeque);



    }
}
