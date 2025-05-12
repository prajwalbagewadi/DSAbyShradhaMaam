



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

    // public static int binSearch(int st,int end,int[] nums,int target){
    //     if(st>end){
    //         return -1; //base case
    //     }
    //     int mid=st+(end-st)/2;
    //     if(nums[mid]==target){
    //         return mid;
    //     } else if(nums[mid]<target){
    //         //RHS    
    //         return binSearch(mid+1,end,nums,target);            
    //     } else {
    //         //LHS
    //         return binSearch(st,mid-1,nums,target);  
    //     }
    // }
    // public static int search(int[] nums, int target) { 
    //     return Srsa.binSearch(0, nums.length, nums, target);
    // }

    public static int search(int[] A, int tar) {
        int st=0,end=A.length-1;
        while(st<=end){
            int mid=st+(end-st)/2; //calculate mid
            if(A[mid]==tar){ //base case check if target == mid
                return mid;
            }
            if(A[st]<=A[mid]){ //left side sorted
                if(A[st]<=tar && tar<=A[mid]) { //mod binary search check
                    end=mid-1; // set end=mid-1 st to mid-1
                } else { //check the right side
                    st=mid+1; // set st to mid+1 to end
                }
            } else { //right side sorted
                if(A[mid]<=tar && tar<=A[end]){ //mod binary search check
                    st=mid+1; // set st=mid+1 st to end
                } else { //check the left side
                    end=mid-1;  // set end=mid-1 st to end
                }
            }
        }
        return -1;
    } //complexity O(log N)
    public static void main(String[] args) {
        int[] arr={4,5,6,7,0,1,2};
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
3(start)<=0(target)<=6(end) false
st(mid+1)7
end(2)
mid =0 target found

how to find which part of array is sorted
             Rsarr
left                      Right
if(arr[st]<arr[mid])->if false    else right half sorted

how can we be sure that one part of array is sorted as
the array was sorted in ascending order and then rotated one part will always 
follow the increamental order.

the pivot k will always lie to the lhs or rhs of mid
and the side where pivot is found is unsorted and the opposite side 
will be automatically sorted.

search tar in between st and end
if (arr[mid])<=tar<=(arr(end))

pesudocode: (modified binary search)
//init
st=0,end=n-1
while(st<=end){
    mid=st+(end-st)/2 //calculate mid
    if(arr[mid]==tar)->mid
    if(arr[st]<=arr[mid]) //check if left is sorted
        if(arr[st]<=tar<arr[mid])->left => end = mid-1
        else right -> st=mid+1
    else
         if(arr[mid]<=tar<arr[end])->right => st = mid+1
        else left -> end=mid-1
}

Algo
1.init start=0,end=n-1 
2.check if(start<=end)
3.calculate mid=start+(end-start)/2
4.check which side is sorted
5.check if(LHS)(arr[start]<=arr[mid]) is sorted
    5.1.check (mod binarysearch condition) if(arr[start]<=tar && tar<=arr[mid])
    5.2.set end to mid-1
    5.3.else check right hand and set start to mid+1
6.if false denoting else (prompting RHS) is sorted
    6.1.check (mod binarysearch condition) if(arr[mid]<=tar && tar<=arr[end])
    6.2.set start to mid+1
    6.3.else check left hand side and set end to mid-1
*/
