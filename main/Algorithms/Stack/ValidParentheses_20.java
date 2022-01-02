package Stack;

import java.util.LinkedList;
import java.util.Stack;

public class ValidParentheses_20 {
    /**
     * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
     *
     * An input string is valid if:
     *
     * Open brackets must be closed by the same type of brackets.
     * Open brackets must be closed in the correct order.
     *
     * @param s the input string with characters of parenthesis only.
     * @return true if the string s has a correct order/type of brackets.
     */
    public static boolean isValid(String s) {
        if(s.length() % 2 == 1)
            return false;
        Stack<Character> q = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                q.add(')');
            } else if (c == '{') {
                q.add('}');
            } else if (c == '[') {
                q.add(']');
            }else if(q.isEmpty() || q.peek() != c){
                return false;
            }else{
                q.pop();
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
