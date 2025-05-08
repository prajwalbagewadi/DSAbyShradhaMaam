import java.lang.*;
/* 
LeetCode
Given an integer array nums, 
find the subarray with the largest sum, and return its sum. 
Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.
Example 2:

Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.
Example 3:

Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
*/

public class MaxSubArr{
    public static void largestSum(int[] arr){
        // Kadane's Algorithm (optimum sol)
    }
    public static void main(String[] args){
        //int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int[] nums = {5,4,-1,7,8};
        MaxSubArr.largestSum(nums);
    }
}

/*
//Kadane's Algorithm | Maximum Subarray Sum (notes)
Max subarray sum

1 2 3 4 5

what is sub Array -> continuous part of a given array 

1 2 3 4 5
 
{ {1},{2},{3},{4},{5},   
  {1,2},{2,3},{3,4},{4,5},     All Possible Sub arrays
  {1,2,3},{2,3,4},{3,4,5},
  {1,2,3,4},{2,3,4,5},
  {1,2,3,4,5},      
}

for a given array N the possible sub arrays are (N*(N+1)/2)
if N=5
=5*(5+1)/2
=5*6/2
=30/2 = 15//-

how to print sub arrays -
we need to find start and end points of sub array
eg : 1 2 3 4 5 
       1   3    start=1 end=3
find all possible start and end
start	end(start to n-1)
0        0,1,2,3,4 n-1
1        1,2,3,4  n-1
2        2,3,4
3        3,4
4        4

for(st=0;st<n;st++){
    for(end=st;end<n;end++){
		
    }
}

public static void printSubArray(int[] arr,int size){
        //brute force method to Print Sub Array
        for(int st=0;st<size;st++){
            for(int end=st;end<size;end++){
                for(int i=st;i<=end;i++){
                    System.out.print(arr[i]);
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }

output:
Print Sub Arrays
1 12 123 1234 12345 
2 23 234 2345 
3 34 345 
4 45 
5 


Max SubArray Sum (BruteForce):
{3, -4, 5, 4, -1, 7, -8}

for(int st=0;st<n;st++){
    for(int end=st;end<n;end++){
        for(int i=st;i<=end;i++){ // third loop removed for optimization
            System.out.print(arr[i]);
        }
        System.out.print(" ");
    }
    System.out.println();

}

O(n^3)

Slight optimization: O(n^2)

{3, -4, 5, 4, -1, 7, -8}

1)3 sum=3
2)3+(-4) sum= //optimization add newNum to previous sum
  = previousSum(3) += (-4)
3) previousSum(3,-4) += (5) 

logic:
for(st=0;st<n;st++){
    currSum=0 //add a variable to store current sum.
    for(end=st;end<n;end++){
	    currSum+=arr[end] //add newNum to previous sum, Hence arr[end]
    }
} 

//Dry run.
cs=0 //init
0.cs=0+3=3 end++
1.cs=3+(-4)=-1 end++
2.cs=(-1)+5=4 end++
3.cs=4+4=8 end++
4.cs=8+(-1)=7 end++
5.cs=7+7=14 end++
6.cs=14+(-8) end++
// array end reached currSum reinitialized currSum=0
start increamented. st++

maxSum=0 //store the max sum for each subarray
for(st=0;st<n;st++){
    currSum=0
    for(end=st;end<n;end++){
	    currSum+=arr[end]
	    maxSum=max(currSum,maxSum)
    }
} 
return maxSum;
*/