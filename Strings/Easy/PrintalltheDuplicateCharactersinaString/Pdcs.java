/*
Print all the duplicate characters in a string
Given a string S, the task is to print all the duplicate characters with their occurrences in the given string.

Example:
Input: S = "geeksforgeeks"
Output:
e, count = 4
g, count = 2
k, count = 2
s, count = 2

Explanation: g occurs 2 times in the string, k occurs 2 times in the string, s occurs 2 times in the string while e occurs 4 times in the string rest of the characters have unique occurrences.
Find the duplicate characters in a string using Sorting
If we sort the string then all duplicates will come together in the string. Then, traverse the string from starting index to the ending index and check if the neighbor character is same then increment the count by 1.
*/

import java.util.HashMap;

public class Pdcs{
    public static void main(String[] args) {
        String s="geeksforgeeks";
        char[] chrs=s.toCharArray();
        HashMap<Character,Integer> seen=new HashMap<Character,Integer>();
        HashMap<Character,Integer> duplicate=new HashMap<Character,Integer>();
        for(int i=0;i<chrs.length;i++){
            seen.put(chrs[i],seen.getOrDefault(chrs[i],0)+1);
            System.out.println("Seen:"+seen);
            if(seen.get(chrs[i])>=2){
               duplicate.put(chrs[i], seen.get(chrs[i])); 
            }
        }
        System.out.println("duplicate:"+duplicate);
    }
}
/*
notes:
used hashmap<Key,val>;
steps:
1.convert string to toCharArray()
2.create two HashMap seen and duplicate
3.for each char add in seen HashMap and getOrDefault(get count val or set default:0) and +1
4.if(seen.get(char)(get value for key)=count >=2)
5.add in duplicates HashMap
*/