/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 

Example 1:

Input: s = "()"

Output: true

Example 2:

Input: s = "()[]{}"

Output: true

Example 3:

Input: s = "(]"

Output: false

Example 4:

Input: s = "([])"

Output: true

 

Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.
*/
import java.util.Stack;

public class Vp {
    public static void main(String[] args) {
        Stack<String> s=new Stack<String>();
        s.push("{");
        s.push("(");
        s.push(")");
        s.push("}");
        System.out.println("print stack:"+s);
        System.out.println("Top of stack:"+s.peek());
        s.pop();
        System.out.println("print stack:"+s);
        System.out.println("Top of stack:"+s.peek());
    }    
}

/*
notes:
use stack class:java.util.Stack
get top of the stack using peek() method.
insert into stack push() and remove pop().
*/