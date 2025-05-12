/* 
Valid Palindrome
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

 

Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
Example 2:

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.
Example 3:

Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.
 

Constraints:

1 <= s.length <= 2 * 105
s consists only of printable ASCII characters.
*/

public class Vp {
    public static boolean isPalindrome(String s) {
        System.out.println(s);
        String procd=s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        System.out.println(procd);
        StringBuilder sb=new StringBuilder(procd); //convert string to stringBuilder for mutability
        sb.reverse(); //reverse the string
        System.out.println(sb);
        if(procd.equals(sb.toString())){ //chech palindrome
            return true;
        }
        return false;
    }//Time Complexity: O(n)
    public static void main(String[] args){
        String s="A man, a plan, a canal: Panama";
        System.out.println("isPalindrome():"+Vp.isPalindrome(s));
    }
}
/*
notes:
use regex:"[^a-zA-Z0-9]"
This is the regex pattern:

^ (inside brackets []): means "not"

a-z: lowercase letters

A-Z: uppercase letters

0-9: digits

So, [^a-zA-Z0-9] means "any character that is NOT a letter or digit".

🔸 "" (empty string)
This means you're replacing those non-alphanumeric characters with nothing — i.e., removing them.
*/