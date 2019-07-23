package GeekBrains_Algorithms.Lesson3;

class ClassForReverseString {
    String stringToReverse;

    ClassForReverseString(String stringToReverse) {
        this.stringToReverse = stringToReverse;
    }

    String reverseString(){
        String result = "";

        MyStack<Character> stack = new MyStack<>(stringToReverse.length());
        char[] arrayFromString = stringToReverse.toCharArray();
        for (int i = 0; i < stringToReverse.length(); i++) {
            stack.push(arrayFromString[i]);
        }

        for (int i = 0; i < stringToReverse.length(); i++) {
            result += stack.pop();
        }
        return result;
    }

}
