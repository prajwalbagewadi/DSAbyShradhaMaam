import java.util.LinkedHashMap;
import java.util.Map;

/*
Given two strings s and t, return true if t is an anagram of s, and false otherwise.

 

Example 1:

Input: s = "anagram", t = "nagaram"

Output: true

Example 2:

Input: s = "rat", t = "car"

Output: false

 

Constraints:

1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.
 

Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
*/
public class Va {
    public static boolean isAnagram(String s, String t) {
        Map<Character,Integer> charCount1=new LinkedHashMap<Character,Integer>();
        Map<Character,Integer> charCount2=new LinkedHashMap<Character,Integer>();
        for(char c : s.toCharArray()){
            charCount1.put(c,charCount1.getOrDefault(c,0)+1); //put char as key , and get value or set default 
        }
        for(char c : t.toCharArray()){
            //System.out.println(c);
            charCount2.put(c,charCount2.getOrDefault(c,0)+1); //put char as key , and get value or set default 
        }
        //System.out.println(charCount1.get(new Character(s.charAt(0))));
        //System.out.println(charCount1);
        //System.out.println(charCount2);
        int valid=0;
        for(char k1:charCount1.keySet()){
            for(char k2:charCount2.keySet()){
                if(k1==k2 && charCount1.get(k1)==charCount2.get(k2)){ //check if both keys match and there counts
                    valid++;
                }
            }
        }
        if(valid==charCount1.size() && valid==charCount2.size()){
            return true;
        }
        return false;
    }//doesnt work with big strings
    public static void main(String[] args){
        String s="evil";
        String t="vilp";
        System.out.println("is a Valid Anagram:"+Va.isAnagram(s, t));
    }
}
/* 
notes:
An anagram is a word or phrase formed by rearranging the letters of another word or phrase, 
using all the original letters exactly once.

Examples:
"listen" → "silent"
"evil" → "vile"
"a gentleman" → "elegant man"
Anagrams are often used in word games and puzzles. 

A HashMap however, store items in "key/value" pairs, 
and you can access them by an index of another type (eg a String).


charCount.put(c,charCount.getOrDefault(c,0)+1);
means:
If the character is already in the map, get its current count and add 1.
If it’s not in the map, return 0 (default), then add 1 → store 1.

output:
v
i
l
e
{e=1, v=1, i=1, l=1}
{e=1, v=1, i=1, l=1}
the second map starts with e and not v.

Java's HashMap is unordered by default. That means:
It doesn't store keys in insertion order, and
It doesn't sort keys alphabetically either.

LinkedHashMap – preserves insertion order:
import java.util.LinkedHashMap;
Map<Character, Integer> charCount1 = new LinkedHashMap<>();
*/