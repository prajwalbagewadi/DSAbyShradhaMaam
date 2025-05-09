import java.lang.*;
import java.util.HashSet;
/* 
Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

 

Example 1:

Input: nums = [1,2,3,1]

Output: true

Explanation:

The element 1 occurs at the indices 0 and 3.

Example 2:

Input: nums = [1,2,3,4]

Output: false

Explanation:

All elements are distinct.

Example 3:

Input: nums = [1,1,1,3,3,4,3,2,4,2]

Output: true

 

Constraints:

1 <= nums.length <= 105
-109 <= nums[i] <= 109
*/
public class Cd {
    // public static  boolean containsDuplicate(int[] nums) {
    //     //Brute force Apporach.
    //     boolean res=false;
    //     for(int st=0;st<nums.length;st++){
    //         for(int i=st+1;i<nums.length;i++){
    //             if(nums[st]==nums[i]){
    //                 res=true;
    //             }
    //         }
    //     }
    //     return res;
    // } //Time Limit Exceeded 

    // public static  boolean containsDuplicate(int[] nums) {
    //     boolean res=false;
    //     HashSet<Integer> seen = new HashSet<Integer>();
    //     HashSet<Integer> duplicates = new HashSet<Integer>();
    //     for(int n:nums){
    //         if(!seen.add(n)){ //If num is already in the set" → it's a duplicate.
    //             duplicates.add(n);
    //             res=true; 
    //         }
    //     }
    //     return res;
    // } //Runtime 26 ms Beats 6.00%

    public static  boolean containsDuplicate(int[] nums) {
        HashSet<Integer> seen = new HashSet<Integer>();
        HashSet<Integer> duplicates = new HashSet<Integer>();
        for(int n:nums){
            if(!seen.add(n)){ //If num is already in the set" → it's a duplicate.
                duplicates.add(n);
                return true; 
            }
        }
        return false;
    } //Runtime 9 ms Beats 92.69% Complexity O(n)
    

    public static void main(String[] args) {
        int[] nums={1,2,3,1};
        //int[] nums={1,2,3,4};
        System.out.println("the Constains Duplicate:"+containsDuplicate(nums));
    }
}
/* 
HashSet apporach:
In Java, a HashSet is a part of the Java Collections Framework. 
It is a collection that stores unique elements and is backed by a hash table.

Key Features of HashSet:
No Duplicates: Automatically ignores duplicate entries.
Unordered: Elements are not stored in insertion order.
Allows null: At most one null element is allowed.
Fast operations: Offers O(1) average time complexity for add, remove, and contains operations.

HashSet<int> seen = new HashSet<int>();
seen.add(num) tries to add num to the set.

if(!seen.add(n)){ //If num is already in the set" → it's a duplicate.
    duplicates.add(n);
    res=true; 
}

It returns:
**true** if num was not in the set (added successfully).
**false** if num was already in the set (duplicate).
!seen.add(num) means:
"If num is already in the set" → it's a duplicate.
*/