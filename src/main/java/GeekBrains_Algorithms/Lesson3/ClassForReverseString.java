package GeekBrains_Algorithms.Lesson3;

public class ClassForReverseString {
    String stringToReverse;

    public ClassForReverseString(String stringToReverse) {
        this.stringToReverse = stringToReverse;
    }

    public void reverseString(){
        MyStack<Character> stack = new MyStack<>(stringToReverse.length());
        char[] arrayFromString = stringToReverse.toCharArray();
        for (int i = arrayFromString.length - 1; i >= 0; i--) {
            stack.push(arrayFromString[i]);
        }
        stringToReverse = stack.toString();
    }

}
