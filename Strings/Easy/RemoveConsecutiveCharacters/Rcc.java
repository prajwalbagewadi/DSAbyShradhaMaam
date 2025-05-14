/*
Remove Consecutive Characters
You are given a string s, consisting of lowercase alphabets. Your task is to remove consecutive duplicate characters from the string. 

Example:

Input: s = "aabb"
Output:  "ab" 
Explanation: 
The character 'a' at index 2 is the same as 'a' at index 1, so it is removed.
Similarly, the character 'b' at index 4 is the same as 'b' at index 3, so it is removed.
The final string is "ab".
Input:s = "aabaa"
Output: "aba"
Explanation: 
The character 'a' at index 2 is the same as 'a' at index 1, so it is removed.
The character 'a' at index 5 is the same as 'a' at index 4, so it is removed.
The final string is "aba".
Input: s = "abcddcba"
Output: "abcdcba"
Explanation: 
The character 'd' at index 5 is the same as 'd' at index 4, so it is removed.
No other consecutive duplicates exist.
The final string is "abcdcba".
Constraints:
1 ≤ n ≤ 106
All characters in the string are lowercase English alphabets.
*/
public class Rcc {
    public static String removeConsecutiveCharacter(String s) {
        // code here
         char[] str=s.toCharArray();
        StringBuilder sb=new StringBuilder();
        sb.append(str[0]);
        for(int i=1;i<str.length;i++){
            if(str[i-1]!=str[i]){
                sb.append(str[i]);
            }
        }
        //System.out.println(sb.toString());
        return sb.toString();
    }
    public static void main(String[] args) {
        String s="aabaa";
        System.out.println("removeConsecutiveCharacter output:"+Rcc.removeConsecutiveCharacter(s));
    }
}
