
import java.util.Arrays;



/*
33. Search in Rotated Sorted Array
There is an integer array nums sorted in ascending order (with distinct values).
Prior to being passed to your function, nums is possibly rotated at an unknown 
pivot index k (1 <= k < nums.length) such that the resulting 
array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). 
For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
Example 3:

Input: nums = [1], target = 0
Output: -1
 
Constraints:
1 <= nums.length <= 5000
-104 <= nums[i] <= 104
All values of nums are unique.
nums is an ascending array that is possibly rotated.
-104 <= target <= 104
*/
public class Srsa {

    public static int binSearch(int st,int end,int[] nums,int target){
        if(st>end){
            return -1; //base case
        }
        int mid=st+(end-st)/2;
        if(nums[mid]==target){
            return mid;
        } else if(nums[mid]<target){
            //RHS    
            return binSearch(mid+1,end,nums,target);            
        } else {
            //LHS
            return binSearch(st,mid-1,nums,target);  
        }
    }
    public static int search(int[] nums, int target) { 
        return Srsa.binSearch(0, nums.length, nums, target);
    }
    public static void main(String[] args) {
        int[] arr={3,4,5,6,7,0,1,2};
        Arrays.sort(arr);
        System.out.print("target found at index:"+Srsa.search(arr,0));
    }
}

/*

brute force to reverse the array:

for(st=0,end=n;st<end;st++,end--)
st==end mid

Why st < end is needed:
When st == end: you’re at the middle (no need to swap)
When st > end: you've already swapped all needed elements — continuing causes wrong results



notes :
{3,4,5,6,7,0,1,2}

arr is sorted in ascending order {0,1,2,3,4,5,6,7}
the array is rotated  from k= 1 <= k < nums.length
{0,1,2,3,4,5,6,7}
 (LHS) k (RHS)
       -----------
<------------------       
{3,4,5,6,7}{0,1,2}  
(RHS)       (LHS)
rotated array becomes = {3,4,5,6,7,0,1,2}

distinct val = all values are unique.
we need to search target.

brute force apporach
{3,4,5,6,7,0,1,2}
 t t t t t t
move to each index and return the index at which the element is found 
Linear search o(n)

array given is sorted -> meaning binary search can be used.
O(log n)

binary search algo:
{0,1,2,3,4,5,6,7}

calculate mid - (st+end/2)  mid=st+(end-st)/2 {optimized}
if tar is less then mid
the element will be in (LHS) and no need to search in (RHS)

binary search 
tar==a[mid](best case)

binary search:
decides which search space (L or R)
normal binary search will not work

//simple binary search
public static int binSearch(int st,int end,int[] nums,int target){
    if(st>end){
        return -1; //base case
    }
    int mid=st+(end-st)/2; //calculate mid
    if(nums[mid]==target){
            return mid;
    } else if(nums[mid]<target){
        //RHS    
        return binSearch(mid+1,end,nums,target);            
    } else {
        //LHS
        return binSearch(st,mid-1,nums,target);  
    }
}
public static int search(int[] nums, int target) { 
    return Srsa.binSearch(0, nums.length, nums, target);
}

apporach : 
one condition is always true for a rotated sorted array:
1.that one part of the array is sorted and the other part is unsorted.
->so the binary search can be applied on the sorted part. 

so how binary search can be applied on rotated sorted array
              Rs
left(sorted)       right(unsorted)
left->binarysearch
a[st]<=tar<=a[mid] (normal binary condition to search in left.)
else move to right

left ->(st,mid-1)
right ->(mid+1,end)

dry run:
{3,4,5,6,7,0,1,2}
divide the array
8/

*/
