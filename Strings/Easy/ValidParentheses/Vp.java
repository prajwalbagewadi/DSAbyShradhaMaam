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
    public static boolean isValid(String s) {
        Stack<Character> stk = new Stack<Character>();
        for(char c:s.toCharArray()){
            switch(c){
                case '{':
                case '(':
                case '[':
                    stk.push(c);
                break;
                case '}':
                    if(!stk.empty() && stk.peek()=='{'){
                        stk.pop();
                    }else{
                        return false;
                    }
                break;
                case ')':
                    if(!stk.empty() && stk.peek()=='('){
                        stk.pop();
                    }else{
                        return false;
                    }
                break;
                case ']':
                    if(!stk.empty() && stk.peek()=='['){
                        stk.pop();
                    }else{
                        return false;
                    }
                break;
                default:
                    System.err.print("invalid character");
            }
        }
        if(!stk.empty()){ // if stack is not empty return false.
            return false;
        }
        return true;
    }
    public static void main(String[] args){
        String s="]";
        System.out.println("output:"+Vp.isValid(s));
    }    
}

/*
notes:
use stack class:java.util.Stack
get top of the stack using peek() method.
insert into stack push() and remove pop().

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
*/