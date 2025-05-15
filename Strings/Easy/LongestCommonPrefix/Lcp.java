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
        if(strs==null||strs.length==0){return "";}
        String prefix=strs[0];
        for(int i=1;i<strs.length;i++){
            while(strs[i].indexOf(prefix)!=0){
                prefix=prefix.substring(0,prefix.length()-1);
            }
            if(prefix.isEmpty()){
                prefix="";
            }
        }
        return prefix;
    }
    public static void main(String[] args){
       //String[] input={"interview", "interact", "internet", "pnternal"};
       String[] input={"flower", "flow", "flight"};
       //String[] input=new String[]{""};
       System.out.println("longest common prefix:"+ longestCommonPrefix(input));
   } 
}
/* 
notes:

if(!strs[0].equals("")) and why not if(!strs.length==0)
This array contains one element, which is an empty string (""). So:
input.length → 1
input[0] → "" (an empty string)

steps:
1.check if strs=null or strs.length=0 return=""
2.create a String variable prefix=strs[0] (complete elemenent length)
3.for each element in strs starting a index 1 
4.while strs[i].indexOf(prefix) get the substring(prefix) index and check !=0
5.if not zero set prefix=prefix.substring(0,prefix-1) extract the prefix substring from 0 to len of prefix-1 and insert into prefix
    eg : start with prefix:"flower" -> prefix:"flow" -> prefix:"fl"..
6.if prefix=0 return ""
*/