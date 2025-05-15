//package Strings.Easy.LongestCommonPrefix;
/*
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

 

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 

Constraints:

1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters if it is non-empty.
*/
public class Lcp {
    public static String longestCommonPrefix(String[] strs) {
        String subStr=strs[0].substring(0,2); //extract a substring of two chars (Intial value)
        for(int i=1;i<strs.length;i++){
            String subStr1=strs[i].substring(0,2);
            if(subStr.equals(subStr1)){
                subStr=subStr1;
            }else{
                subStr="";
                break;
            }
        }
       //System.out.println(subStr);
       return subStr;
    }
    public static void main(String[] args){
       //String[] input={"interview", "interact", "internet", "pnternal"};
       String[] input={"flower", "flow", "flight"};
       //String[] input=new String[]{""};
       System.out.println("longest common prefix:"+ longestCommonPrefix(input));
   } 
}
